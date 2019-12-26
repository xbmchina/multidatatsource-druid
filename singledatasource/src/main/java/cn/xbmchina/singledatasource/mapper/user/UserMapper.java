package cn.xbmchina.singledatasource.mapper.user;

import cn.xbmchina.singledatasource.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    @Insert("INSERT  INTO  user (name,age) VALUES (#{name},#{age})")
    int insertUser(User user);
}
