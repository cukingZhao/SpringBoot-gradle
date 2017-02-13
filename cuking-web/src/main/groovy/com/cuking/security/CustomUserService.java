package com.cuking.security;

import com.cuking.Dao.SysUserDao;
import com.cuking.domain.SysRole;
import com.cuking.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cuking on 2017/2/7.
 */

public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserDao sysUserDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }


        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        //遍历用户的所有的角色
        for(SysRole sysRole : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + sysRole.getName()));
        }

        System.out.println("s:" + username);
        System.out.println("username:" + user.getUsername() + ";password:" + user.getPassword());
        return new User(user.getUsername(), user.getPassword(), authorities);
    }


    /**
     * 返回验证角色
     *
     * @param userRoles
     * @return
     */
    private List<GrantedAuthority> buildUserAuthority(List<SysRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for (SysRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getId().toString()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }

    /**
     * 返回验证用户
     *
     * @param user
     * @param authorities
     * @return
     */
    private User buildUserForAuthentication(SysUser user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

}
