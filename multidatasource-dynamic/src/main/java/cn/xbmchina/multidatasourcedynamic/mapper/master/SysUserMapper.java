package cn.xbmchina.multidatasourcedynamic.mapper.master;

import cn.xbmchina.multidatasourcedynamic.domain.master.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {

    List<SysUser> selectUserList();

    void update(SysUser sysUser);
}