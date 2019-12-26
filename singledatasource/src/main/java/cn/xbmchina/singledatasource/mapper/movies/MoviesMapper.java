package cn.xbmchina.singledatasource.mapper.movies;

import cn.xbmchina.singledatasource.entity.Movies;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoviesMapper {

    @Insert("INSERT  INTO  movies (name,price) VALUES (#{name},#{price})")
    int insertmovies(Movies movies);


}
