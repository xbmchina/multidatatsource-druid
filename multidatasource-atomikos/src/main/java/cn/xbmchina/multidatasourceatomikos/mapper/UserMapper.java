package cn.xbmchina.multidatasourceatomikos.mapper;

import cn.xbmchina.multidatasourceatomikos.annotations.TargetDataSource;
import cn.xbmchina.multidatasourceatomikos.constants.DataSourceKey;
import cn.xbmchina.multidatasourceatomikos.domain.User;

import java.util.List;

@TargetDataSource(DataSourceKey.TWO)
public interface UserMapper {

    List<User> selectUserList();

    void update(User user);
}