package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Income;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface IncomeMapper {

    //查看
    @Select("SELECT income.`id` ,datetime,money,weight,unitprice,name FROM income,vegetables WHERE `income`.`vegetable` =`vegetables` .id ORDER BY datetime ASC ")
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

    //获取总数据
    @Select("select name,\n" +
            "       datetime as datetime,\n" +
            "       vegetable,\n" +
            "       SUM(money) AS sum,\n" +
            "       sum(weight) as sumweight\n" +
            "  from income,\n" +
            "       vegetables\n" +
            " WHERE `income`.`vegetable`= `vegetables` .`id`\n" +
            " group by vegetable")
    @Results({
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "datetime", property = "datetime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "vegetable", property = "vegetable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
            @Result(column = "sumweight", property = "sumweight", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true)
    })
    List<Income> getIncomeAll();

    //获取年月数据
    @Select("select name,\n" +
            "       date_format(datetime,'%Y-%m') as datetime,\n" +
            "       SUM(money) AS sum,\n" +
            "       sum(weight) as sumweight,\n" +
            "       round(AVG(unitprice), 2) as unitprice\n" +
            "  from income,\n" +
            "       vegetables\n" +
            " WHERE `income`.`vegetable`= `vegetables` .`id`\n" +
            "   AND YEAR(datetime) IN(#{year})\n" +
            " group by  MONTH (datetime)")
    @Results({
            @Result(column = "itimeYearMounth", property = "itimeYearMounth", jdbcType = JdbcType.DATE),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "datetime", property = "datetime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "vegetable", property = "vegetable", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sum", property = "sum", jdbcType = JdbcType.INTEGER),
            @Result(column = "sumweight", property = "sumweight", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true)
    })
    List<Income> getIncomeYearMounth(Integer year);

    @SelectProvider(type = IncomeMapperSqlProvider.class,method = "selectAllByConditions")
    List<Income> getIncomeAllByConditions(String type, String conditions);

}
