package cn.xbmchina.singledatasource.service;

import cn.xbmchina.singledatasource.entity.Movies;
import cn.xbmchina.singledatasource.entity.User;
import cn.xbmchina.singledatasource.mapper.movies.MoviesMapper;
import cn.xbmchina.singledatasource.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService02 {

    @Autowired
    MoviesMapper moviesMapper;

    @Autowired
    UserMapper userMapper;


//    @Transactional
    public int test01Andtest02(String name, Integer age){
        for (int i = 0;i < 5;i++) {
            if(i < 2) {
                User user = new User("user_"+i, 10);
                userMapper.insertUser(user);
            }else {
                int w = 1/0;
//				throw new RuntimeException();
            }
            Movies movies = new Movies("blibli"+i,2121);
            moviesMapper.insertmovies(movies);
        }
        return 1;
    }

}