package cn.xbmchina.multidatasourceatomikos.service;



import cn.xbmchina.multidatasourceatomikos.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    void update(User user);
}
