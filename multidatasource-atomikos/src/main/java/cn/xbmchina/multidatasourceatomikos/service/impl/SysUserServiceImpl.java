package cn.xbmchina.multidatasourceatomikos.service.impl;

import cn.xbmchina.multidatasourceatomikos.domain.SysUser;
import cn.xbmchina.multidatasourceatomikos.mapper.SysUserMapper;
import cn.xbmchina.multidatasourceatomikos.service.SysUserService;
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