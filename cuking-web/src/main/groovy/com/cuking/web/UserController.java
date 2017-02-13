package com.cuking.web;

import com.cuking.security.CustomUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cuking on 2017/1/5.
 */
@Controller
class UserController {


    private CustomUserService customUserService;

    AuthenticationManager authenticationManager;


    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password, String url){

        //authenticationManager.authenticate()

        UserDetails details = customUserService.loadUserByUsername(username);

        //密码加密校验


        return "login";
    }

//    @Autowired
//    private MyConfig config;
//
//    @Autowired
//    private UserService userService;
//
////    @RequestMapping("/i")
////    public String index() {
////        return "login";
////    }
//
//    @RequestMapping("/error")
//    public String rmm() {
//        return "regist";
//    }
//
//    @RequestMapping("/s")
//    public String suc() {
//        return "success";
//    }

//    @RequestMapping("/regist")
//    @ResponseBody
//    public MappingChange.Map<String, Object> regist(User user) {
//
//        Map map = new HashMap();
//
//        userService.save(user);
//        map.put("status", 200);
//        map.put("data", "注册成功");
//
//
//        return map;
//    }
//
//    @RequestMapping("/login")
//    @ResponseBody
//    public Map<String, Object> login(String username, String password) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        User user = userService.findByName(username);
//
//        if (null != user && user.getPassword().equals(password)) {
//            map.put("status", 200);
//            map.put("data", "登录成功!  欢迎回来!  " + user.getNickName());
//        } else {
//            map.put("status", 500);
//            map.put("data", "登录失败!用户名或者密码不正确!!");
//        }
//        return map;
//    }
}
