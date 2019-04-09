package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into users(name,age) values(#{name},#{age})")
    void insertUser(Users users);

    @Select("select * from users where id=#{id}")
    public Users getUserById(Integer id);

    @Delete("delete from users where id=#{id}")
    public int deleteUserById(Integer id);

    @Update("update users set name=#{name} where id=#{id}")
    public int updateUser(Users users);

}
