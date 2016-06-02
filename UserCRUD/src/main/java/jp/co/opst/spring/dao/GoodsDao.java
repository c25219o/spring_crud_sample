package jp.co.opst.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.spring.entity.Goods;

@Repository
public class GoodsDao {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final String SELECE_ALL = "SELECT * FROM GOODS";


    BeanPropertyRowMapper<Goods> mapper = new BeanPropertyRowMapper<Goods>() {
        @Override
        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
            Goods goods = new Goods();
            goods.setGoodsNum(rs.getString("GOODS_NUM"));
            goods.setGoodsName(rs.getString("GOODS_NAME"));
            goods.setGoodsExp(rs.getString("GOODS_EXP"));
            goods.setGoodsPrice(rs.getString("GOODS_PRICE"));
            goods.setMaker(rs.getString("MAKER"));
            goods.setRegDate(rs.getDate("REG_DATE"));
            goods.setLstUpdateTime(rs.getDate("LST_UPDATE_TIME"));
            return goods;
        }
    };


    public List<Goods> byId (String id) {

        return null;

    }


    public List<Goods> all() {
        return template.query(SELECE_ALL, mapper);
    }




}
