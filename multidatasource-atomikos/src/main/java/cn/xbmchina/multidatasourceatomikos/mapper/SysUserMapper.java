package cn.xbmchina.multidatasourceatomikos.mapper;

import cn.xbmchina.multidatasourceatomikos.annotations.TargetDataSource;
import cn.xbmchina.multidatasourceatomikos.constants.DataSourceKey;
import cn.xbmchina.multidatasourceatomikos.domain.SysUser;

import java.util.List;

@TargetDataSource(DataSourceKey.ONE)
public interface SysUserMapper {

    List<SysUser> selectUserList();

    void update(SysUser sysUser);
}