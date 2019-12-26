package cn.xbmchina.singledatasource;

import cn.xbmchina.singledatasource.entity.Movies;
import cn.xbmchina.singledatasource.entity.User;
import cn.xbmchina.singledatasource.mapper.movies.MoviesMapper;
import cn.xbmchina.singledatasource.mapper.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SingledatasourceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MoviesMapper moviesMapper;

	@Autowired
	UserMapper userMapper;


	@Test
	public void twodata() {
		for (int i = 0;i < 5;i++) {
			if(i < 2) {
				User user = new User("user_"+i, 10);
				userMapper.insertUser(user);
			}else {
				throw new RuntimeException();
			}
			Movies movies = new Movies("blibli"+i,2121);
			moviesMapper.insertmovies(movies);
		}
		System.out.println("做完了。。。。。。");
	}


	@Test
	public void testwwe() {
		User user = new User("user_1scf", 10);
		userMapper.insertUser(user);
	}

}
