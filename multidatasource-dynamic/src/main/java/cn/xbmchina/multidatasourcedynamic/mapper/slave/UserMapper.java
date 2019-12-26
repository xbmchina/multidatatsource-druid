package cn.xbmchina.multidatasourcedynamic.mapper.slave;

import cn.xbmchina.multidatasourcedynamic.domain.slave.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUserList();

    void update(User user);
}