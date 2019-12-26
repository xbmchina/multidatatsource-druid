package cn.xbmchina.multidatasourceatomikos.service;



import cn.xbmchina.multidatasourceatomikos.domain.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> listUser();

    void update(SysUser sysUser);
}
