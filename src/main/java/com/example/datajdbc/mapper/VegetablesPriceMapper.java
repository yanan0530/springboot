package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.VegetablesPrice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VegetablesPriceMapper {
    @Select("select * from vegetables_price,vegetables where vegetables.id=vegetables_price.vegetable_id order by create_time desc")
    List<VegetablesPrice> selectVegetablePriceAll();

    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into vegetables_price(vegetable_id,unitprice,datetime) value(#{vegetableId},#{unitprice},#{datetime})")
    boolean insetVegetablePrice(VegetablesPrice vegetablesPrice);

    @Delete("delete from  vegetables_price where id=#{id}")
    void delVegetablePriceById(Integer id);

    @Update("update vegetables_price set vegetable_id=#{vegetableId},unitprice=#{unitprice},datetime=#{datetime}")
    boolean updateVegetablePrice(VegetablesPrice vegetablesPrice);


    /**
     * 根据ID 搜素当前蔬菜所有的日期的单价
     * @param id
     * @return
     */
    @Select("select datetime,vegetable_id,round(avg(unitprice),2) as unitprice,vegetables.name as name\n" +
            "from\n" +
            "       (\n" +
            "       select income.datetime,vegetable as vegetable_id,unitprice,vegetables.name\n" +
            "       from income,vegetables where vegetables.id=income.vegetable\n" +
            "       union ALL\n" +
            "       select datetime,vegetable_id,unitprice,vegetables.name\n" +
            "       from vegetables_price,vegetables\n" +
            "       where vegetables.id=vegetables_price.vegetable_id\n" +
            "       ) as i,vegetables\n" +
            "where i.vegetable_id=vegetables.id and i.vegetable_id=#{id} and date_format(datetime,\"%Y\")=#{year}\n" +
            "group by i.datetime,vegetable_id\n" +
            "order by i.datetime asc")
    List<VegetablesPrice> getVegetablePriceAndIncomeById(@Param("id") Integer id, @Param("year") String year);
}
