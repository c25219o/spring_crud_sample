package jp.co.opst.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.spring.dao.UserDao;
import jp.co.opst.spring.entity.User;
import jp.co.opst.util.list.ListUtil;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public boolean isCorrectUser(String userId, String password) {

        User user = selectById(userId);

        if (password.equals(user.getPassword())) {
            return true;

        } else {
            return false;
        }
    }


    public List<User> selectAll() {
        return dao.all();
    }


    public User selectById(String userId) {
        List<User> list = dao.byId(userId);

        if (ListUtil.hasOnlyOneElement(list)) {
            return list.get(0);
        } else {
            return new User();
        }

    }


}
