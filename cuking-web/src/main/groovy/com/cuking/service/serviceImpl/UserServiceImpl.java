package com.cuking.service.serviceImpl;

import com.cuking.Dao.UserDao;
import com.cuking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by cuking on 2017/1/5.
 */
@Service
@Transactional
public class UserServiceImpl implements com.cuking.service.UserService {

    @Autowired
    private UserDao userDao;

    public User save(User user) {

        user.setCreateDate(new Date());
        User save = userDao.save(user);
//        int i=  1/0;
        return save;
    }

    public User findByName(String username) {
        return userDao.findByUsername(username);
    }
}
