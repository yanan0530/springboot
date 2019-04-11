package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Income;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import javax.swing.*;
import java.util.List;

@Mapper
public interface IncomeMapper {

    //查看
    @Select("select * from income")
    List<Income> getIncomeList();

    //添加
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into income(datetime,vegetable,money,weight,unitprice) values(#{datetime},#{vegetable},#{money},#{weight},#{unitprice})")
    void insertIncome(Income income);

    //更新
    @Update("update income set vegetable=#{vegetable},money=#{money},weight=#{weight},unitprice=#{unitprice} where id=#{id}")
    boolean upIncomeById(Income income);

    //删除
    @Delete("delete from  income where id=#{id}")
    boolean delIncomeById(Integer id);

    //获取今天所有数据

    @Select("select datetime ,vegetable, SUM(money)  AS sum ,sum(weight) as sumweight  from income  group by vegetable")
    @Results({
            @Result(column = "datetime", property = "datetime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "vegetable", property = "vegetable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
            @Result(column = "sumweight", property = "sumweight", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER,id = true)
    })
    List<Income> getIncomeToday();

}
