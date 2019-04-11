package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into users(name,age) values(#{name},#{age})")
    void insertUser(Users users);

    @Select("select * from users where id=#{id}")
    public Users getUserById(Integer id);

    @Delete("delete from users where id=#{id}")
    boolean deleteUserById(Integer id);

    @Update("update users set name=#{name} where id=#{id}")
    public int updateUser(Users users);

    @Select("select * from users")
    List<Users> getUserList();

}
