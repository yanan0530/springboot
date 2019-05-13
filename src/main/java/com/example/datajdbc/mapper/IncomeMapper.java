package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Income;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface IncomeMapper {

    //查看
    @Select("SELECT income.`id` ,datetime,money,weight,unitprice,name,project_id FROM income,vegetables WHERE `income`.`vegetable` =`vegetables` .id ORDER BY datetime DESC ")
    List<Income> getIncomeList();

    //添加
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into income(datetime,vegetable,money,weight,unitprice,project_id) values(#{datetime},#{vegetable},#{money},#{weight},#{unitprice},#{projectId})")
    void insertIncome(Income income);

    //更新
    @Update("update income set datetime=#{datetime},vegetable=#{vegetable},money=#{money},weight=#{weight},unitprice=#{unitprice},project_id=#{projectId} where id=#{id}")
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
    //返回进货单:年月
    @Select("select date_format(income.datetime,\"%m-%d\") as datetime from income where income.vegetable=#{id} group by datetime order by date_format(income.datetime,\"%m-%d\") ASC")
    String[] getIncomeMounthDay(Integer id);
    //返回进货单:年
    @Select("select date_format(income.datetime,\"%Y\") as datetime from income where income.vegetable=#{id} group by date_format(income.datetime,\"%Y\") order by date_format(income.datetime,\"%Y\") ASC")
    String[] getIncomeYears(Integer id);
    //进货单 按照日期返回进货单信息
    @Select("select date_format(income.datetime,\"%Y-%m-%d\") as datetime,\n" +
            "       vegetables.name,\n" +
            "       income.vegetable,\n" +
            "       avg(BINARY (income.unitprice)) as unitprice\n" +
            "from income,vegetables\n" +
            "where income.vegetable=vegetables.id and income.vegetable=#{id}\n" +
            "group by datetime,vegetables.name\n" +
            "order by date_format(income.datetime,\"%m-%d\") ASC;")
    List<Income> getIncomeDataMountDay(Integer id);
}
