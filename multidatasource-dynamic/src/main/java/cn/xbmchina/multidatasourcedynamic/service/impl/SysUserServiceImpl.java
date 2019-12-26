package cn.xbmchina.multidatasourcedynamic.service.impl;

import cn.xbmchina.multidatasourcedynamic.domain.master.SysUser;
import cn.xbmchina.multidatasourcedynamic.mapper.master.SysUserMapper;
import cn.xbmchina.multidatasourcedynamic.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> listUser() {
        return sysUserMapper.selectUserList();
    }

    @Override
    @Transactional
    public void update(SysUser sysUser) {
        sysUserMapper.update(sysUser);
//        int i = 10 / 0;
    }
}