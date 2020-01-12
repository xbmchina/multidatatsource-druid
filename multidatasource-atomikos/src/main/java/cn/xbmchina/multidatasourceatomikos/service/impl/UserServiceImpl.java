package cn.xbmchina.multidatasourceatomikos.service.impl;

import cn.xbmchina.multidatasourceatomikos.domain.SysUser;
import cn.xbmchina.multidatasourceatomikos.domain.User;
import cn.xbmchina.multidatasourceatomikos.mapper.SysUserMapper;
import cn.xbmchina.multidatasourceatomikos.mapper.UserMapper;
import cn.xbmchina.multidatasourceatomikos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<User> listUser() {
        return userMapper.selectUserList();
    }


    @Override
    @Transactional
    public void update(User user) {

        User user1 = new User();
        user1.setUserId(6);
        user1.setUserName("name-8888");

        userMapper.update(user1);

        SysUser sysUser = new SysUser();
        sysUser.setUserId(1);
        sysUser.setUserName("name-8888");
        sysUserMapper.update(sysUser);

        int i = 10 / 0;
    }
}