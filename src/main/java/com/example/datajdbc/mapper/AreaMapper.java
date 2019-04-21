package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Area;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AreaMapper {

    @Select("select * from area")
    List<Area> getAreaAll();

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into area(areaname) values(#{areaname})")
    void insertArea(Area area);

    @Delete("delete from area where id=#{id}")
    boolean deleteAreaById(Integer id);

    @Update("update area set areaname=#{areaname} where id=#{id}")
    void updateArea(Area users);


}
