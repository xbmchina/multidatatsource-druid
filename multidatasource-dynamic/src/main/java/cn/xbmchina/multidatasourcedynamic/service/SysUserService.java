package cn.xbmchina.multidatasourcedynamic.service;


import cn.xbmchina.multidatasourcedynamic.domain.master.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> listUser();

    void update(SysUser sysUser);
}
