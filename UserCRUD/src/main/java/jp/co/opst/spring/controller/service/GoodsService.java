package jp.co.opst.spring.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.spring.controller.params.SearchParam;
import jp.co.opst.spring.dao.GoodsDao;
import jp.co.opst.spring.entity.Goods;

@Service
public class GoodsService {

    @Autowired
    GoodsDao dao;

    public List<Goods> findByCondition(SearchParam params) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Goods> findAll() {

        // TODO Auto-generated method stub
        return dao.all();
    }

    public Goods findById(String goodsNum) {

        return null;
    }

}
