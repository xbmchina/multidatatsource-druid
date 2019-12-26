package cn.xbmchina.singledatasource.web;

import cn.xbmchina.singledatasource.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService02 userService02;

    @RequestMapping("/hello")
    public String test() {

        userService02.test01Andtest02("gggg",323);
        return "hello";
    }

}
