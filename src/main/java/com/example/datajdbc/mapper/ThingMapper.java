package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Thing;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ThingMapper {
    //查看所有
    @Select("select * from thing")
    List<Thing> getThingAll();
    //添加
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into thing(name) values(#{name})")
    void insertThing(Thing thing);

    @Delete("delete from thing where id=#{id}")
    void delThing(Integer id);

    //更新
    @Update("update thing set name=#{name} where id=#{id}")
    void updateThing(Thing thing);
}
