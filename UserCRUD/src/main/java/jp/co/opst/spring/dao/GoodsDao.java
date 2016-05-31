package jp.co.opst.spring.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.spring.entity.Item;

@Repository
public class GoodsDao {

    @Autowired
    NamedParameterJdbcTemplate template;


    BeanPropertyRowMapper<Item> mapper = new BeanPropertyRowMapper<Item>() {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) {
            Item goods = new Item();
            // 省略
            return goods;
        }
    };


    public List<Item> byId (String id) {


        return null;

    }


}
