package cn.xbmchina.multidatasourceatomikos.service.impl;

import cn.xbmchina.multidatasourceatomikos.domain.User;
import cn.xbmchina.multidatasourceatomikos.mapper.UserMapper;
import cn.xbmchina.multidatasourceatomikos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.selectUserList();
    }

    @Override
    @Transactional
    public void update(User user) {
        userMapper.update(user);
        int i = 10 / 0;
    }
}