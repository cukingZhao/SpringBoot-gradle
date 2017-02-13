import com.cuking.Application;
import com.cuking.Dao.PermissionsDao;
import com.cuking.Dao.SysRoleDao;
import com.cuking.Dao.SysUserDao;
import com.cuking.domain.Permissions;
import com.cuking.domain.SysRole;
import com.cuking.domain.SysUser;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by cuking on 2017/2/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringbootTest {

    @Autowired
    private PermissionsDao permissionsDao;

    @Autowired
    private SysRoleDao sysRoleDao;


    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void run1(){


        //权限
//        Permissions goodsPer = new Permissions();
//        goodsPer.setCreateDate(new Date());
//        goodsPer.setUpdateDate(new Date());
//        goodsPer.setDes("商品权限");
//        goodsPer.setDeep(1);
//        permissionsDao.save(goodsPer);
//
//
//        Permissions goodslistpagePer = new Permissions();
//        goodslistpagePer.setDeep(2);
//        goodslistpagePer.setParent(goodsPer);
//        goodslistpagePer.setDes("商品管理页面");
//        permissionsDao.save(goodslistpagePer);
//
//        Permissions goodsList = new Permissions();
//        goodsList.setCreateDate(new Date());
//        goodsList.setUpdateDate(new Date());
//        goodsList.setDes("商品查看");
//        goodsList.setUrl("/goods/list");
//        goodsList.setParent(goodslistpagePer);
//
//        Permissions goodsDel = new Permissions();
//        goodsDel.setCreateDate(new Date());
//        goodsDel.setUpdateDate(new Date());
//        goodsDel.setDes("商品删除");
//        goodsDel.setUrl("/goods/del");
//        goodsDel.setParent(goodslistpagePer);
//
//        permissionsDao.save(goodsList);
//        permissionsDao.save(goodsDel);
//
//
//        //角色
//        SysRole admin = new SysRole();
//        admin.setName("管理员");
//        List<Permissions> list = new ArrayList<>();
//        list.add(goodsList);
//        list.add(goodsDel);
//        admin.setPermissionses(list);
//        sysRoleDao.save(admin);
//
//
//        SysRole userR = new SysRole();
//        userR.setName("普通用户");
//        List<Permissions> list2 = new ArrayList<>();
//        list2.add(goodsList);
//        userR.setPermissionses(list2);
//        sysRoleDao.save(userR);
//
//
//
//        //用户
//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("adminUser");
//        sysUser.setPassword("123456");
//        List<SysRole> roles  = new ArrayList<>();
//        roles.add(admin);
//        sysUser.setRoles(roles);
//        sysUserDao.save(sysUser);
//
//
//
//        SysUser user2 = new SysUser();
//        user2.setUsername("aUser");
//        user2.setPassword("123456");
//        List<SysRole> roles2  = new ArrayList<>();
//        roles.add(userR);
//        user2.setRoles(roles2);
//        sysUserDao.save(user2);

        SysUser adminUser = sysUserDao.findByUsername("adminUser");
        SysUser auser = sysUserDao.findByUsername("aUser");

        adminUser.getRoles();
        //获取用户的展示模块

        int deep = 3;
        int deep2 = 1;
        List<String> permissionsUrls = new ArrayList<>();
        for (SysRole role  :adminUser.getRoles()) {
            for (Permissions p :role.getPermissionses()) {
                if (deep == p.getDeep()){
                    permissionsUrls.add(p.getUrl());
                }
            }
        }


        Set<Permissions> permissionsSet = new LinkedHashSet<>();
        for (SysRole role  :adminUser.getRoles()) {
            for (Permissions p :role.getPermissionses()) {
                while (null != p.getParent()){
                   p = p.getParent();
                }
                permissionsSet.add(p);
            }
        }





        System.err.print("ok");
    }


}
