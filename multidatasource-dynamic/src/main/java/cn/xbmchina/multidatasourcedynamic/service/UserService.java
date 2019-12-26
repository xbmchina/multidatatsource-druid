package cn.xbmchina.multidatasourcedynamic.service;


import cn.xbmchina.multidatasourcedynamic.domain.slave.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    void update(User user);
}
