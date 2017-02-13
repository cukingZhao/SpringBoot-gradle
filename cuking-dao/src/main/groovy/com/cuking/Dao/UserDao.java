package com.cuking.Dao;

import com.cuking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by cuking on 2017/1/5.
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("from User u where u.username=:username")
    User findUser(@Param("username") String username);

    //http://passport.iqiyi.com/apis/phone/send_cellphone_authcode_vcode.action?requestType=2&cellphoneNumber=18625915770&serviceId=2&vcode=rawz&agenttype=1&callback=window.Q.__callbacks__.cb4gdfs1

}
