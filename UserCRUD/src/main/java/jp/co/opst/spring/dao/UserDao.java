package jp.co.opst.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.spring.entity.User;

@Repository
public class UserDao {

    private static final String SELECT_ALL = "SELECT * FROM USER_TEST";
    private static final String SELECT_BY_ID = SELECT_ALL + " WHERE USER_ID = :userId";

    @Autowired
    private NamedParameterJdbcTemplate template;

    private BeanPropertyRowMapper<User> mapper = new BeanPropertyRowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getString("USER_ID"));
            user.setPassword(rs.getString("PASSWORD"));
            return user;
        }
    };


    public List<User> byId(String userId) {
        MapSqlParameterSource source = new MapSqlParameterSource().addValue("userId", userId);
        return template.query(SELECT_BY_ID, source, mapper);
    }


    public List<User> all() {
        return template.query(SELECT_ALL, mapper);
    }


}
