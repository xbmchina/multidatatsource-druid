package cn.xbmchina.multidatasourcedynamic.service.impl;

import cn.xbmchina.multidatasourcedynamic.domain.slave.User;
import cn.xbmchina.multidatasourcedynamic.mapper.slave.UserMapper;
import cn.xbmchina.multidatasourcedynamic.service.UserService;
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
    @Transactional(value = "slaveTransactionManager")
    public void update(User user) {
        userMapper.update(user);
        int i = 10 / 0;
    }
}