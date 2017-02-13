package com.cuking.service;

import com.cuking.domain.User;

/**
 * Created by cuking on 2017/1/5.
 */
public interface UserService {

    User save(User user);

    User findByName(String username);

}
