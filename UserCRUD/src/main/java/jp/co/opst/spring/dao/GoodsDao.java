package jp.co.opst.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.spring.entity.Goods;

@Repository
public class GoodsDao {


    private static final String SELECT_ALL = "SELECT * FROM GOODS";
    private static final String SELECT_BY_ID = SELECT_ALL + " WHERE GOODS_NUM = :num";
    private static final String ORDER_BY_GOODS_NUM = " ORDER BY GOODS_NUM + 0";
    private static final String PAGING_OPTION = " LIMIT :offset, :rowCount";

    private static final String SELECT_ALL_PAGING = SELECT_ALL + ORDER_BY_GOODS_NUM + PAGING_OPTION;
    private static final String SELECT_BY_ID_PAGING = SELECT_BY_ID + ORDER_BY_GOODS_NUM + PAGING_OPTION;

    private static final String SELECT_MAX_GOODS_NUM = "SELECT max(cast(GOODS_NUM as unsigned)) FROM GOODS";

//    private static final String SELECT_ONLY_ID  = "SELECT GOODS_NUM FROM GOODS";

    @Autowired
    NamedParameterJdbcTemplate template;

    private BeanPropertyRowMapper<Goods> allColumnMapper = new BeanPropertyRowMapper<Goods>(){
        @Override
        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
            Goods goods = new Goods();
            goods.setGoodsNum(rs.getString("GOODS_NUM"));
            goods.setGoodsName(rs.getString("GOODS_NAME"));
            goods.setGoodsPrice(rs.getString("GOODS_PRICE"));
            goods.setGoodsExp(rs.getString("GOODS_EXP"));
            goods.setMaker(rs.getString("MAKER"));
            goods.setLstUpdateTime(rs.getDate("LST_UPDATE_TIME"));
            goods.setRegDate(rs.getDate("REG_DATE"));
            return goods;
        }
    };

    private BeanPropertyRowMapper<Integer> maxMapper = new BeanPropertyRowMapper<Integer>(){
        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt("max(cast(GOODS_NUM as unsigned))");
////        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Goods goods = new Goods();
////            goods.setGoodsNum(rs.getString("GOODS_NUM"));
//               goods.setGoodsNum(rs.getString("max(cast(GOODS_NUM as unsigned))"));
//            return goods;
        }
    };



    public List<Goods> byId(String num) {
        MapSqlParameterSource source = new MapSqlParameterSource().addValue("num", num);
//        return template.query(SELECT_BY_ID + ID_ASC, source, mapper);
        return template.query(SELECT_BY_ID + ORDER_BY_GOODS_NUM, source, allColumnMapper);
    }

    public List<Goods> pageById(String num, int nextPage, int rowCount) {
        int offset = rowCount * (nextPage - 1);
        MapSqlParameterSource source = new MapSqlParameterSource().addValue("num", num).addValue("rowCount", rowCount).addValue("offset", offset);
//        return template.query(SELECT_BY_ID_PAGING + ID_ASC, source, mapper);
        return template.query(SELECT_BY_ID_PAGING, source, allColumnMapper);
    }

    public List<Goods> all() {
//        return template.query(SELECT_ALL + ID_ASC, mapper);
        return template.query(SELECT_ALL + ORDER_BY_GOODS_NUM, allColumnMapper);
    }

//    public Page<Goods> pageAll(Pageable pageable) {
//        int total = template.query(SELECT_ALL, mapper).size();
//
//        return null;
//    }

//    public List<Goods> getOnlyGoodsNum() {
//        return template.query(SELECT_ONLY_ID, maxMapper);
//    }

    public Integer maxGoodsNum() {
//        String sql = "SELECT max(cast(GOODS_NUM as unsigned)) FROM GOODS";
        return template.query(SELECT_MAX_GOODS_NUM, maxMapper).get(0);

//        for (Goods goods : goodsNumList) {
//            System.out.println(goods.getGoodsNum());
//        }
//
//        return 0;
    }


    public List<Goods> pageAll(int nextPage, int rowCount) {
        int offset = rowCount * (nextPage - 1);
        MapSqlParameterSource source = new MapSqlParameterSource().addValue("rowCount", rowCount).addValue("offset", offset);
//        return template.query(SELECT_ALL_PAGING + ID_ASC, source, mapper);
//        String sql = "select * from GOODS order by GOODS_NUM + 0";
//        return template.query(sql, source, allColumnMapper);
        return template.query(SELECT_ALL_PAGING, source, allColumnMapper);
    }



}

//@Repository
//public class GoodsDao {
//
//    @Autowired
//    NamedParameterJdbcTemplate template;
//
//    private static final String SELECE_ALL = "SELECT * FROM GOODS";
//
//
//    BeanPropertyRowMapper<Goods> mapper = new BeanPropertyRowMapper<Goods>() {
//        @Override
//        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Goods goods = new Goods();
//            goods.setGoodsNum(rs.getString("GOODS_NUM"));
//            goods.setGoodsName(rs.getString("GOODS_NAME"));
//            goods.setGoodsExp(rs.getString("GOODS_EXP"));
//            goods.setGoodsPrice(rs.getString("GOODS_PRICE"));
//            goods.setMaker(rs.getString("MAKER"));
//            goods.setRegDate(rs.getDate("REG_DATE"));
//            goods.setLstUpdateTime(rs.getDate("LST_UPDATE_TIME"));
//            return goods;
//        }
//    };
//
//
//    public List<Goods> byId (String id) {
//
//        return null;
//
//    }
//
//
//    public List<Goods> all() {
//        return template.query(SELECE_ALL, mapper);
//    }
//
//
//
//
//}
