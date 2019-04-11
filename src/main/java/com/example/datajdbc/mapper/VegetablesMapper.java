package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Vegetables;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VegetablesMapper {
    @Delete("delete from  vegetables where id=#{id}")
    boolean delVegetById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into vegetables(name,state) value(#{name},#{state})")
    void InsetVege(Vegetables vegetables);

    @Select("select * from vegetables")
    List<Vegetables> VegList();

    @Update("UPDATE vegetables set name=#{name},state=#{state} where id=#{id}")
    void upVegeById(Vegetables vegetables);

    //查询当前状态为1的
    @Select("select * from vegetables where state=1")
    List<Vegetables> vegStateList();
}
