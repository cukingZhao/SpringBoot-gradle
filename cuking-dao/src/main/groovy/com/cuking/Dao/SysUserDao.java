package com.cuking.Dao;

import com.cuking.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuking on 2017/2/7.
 */
public interface SysUserDao extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
