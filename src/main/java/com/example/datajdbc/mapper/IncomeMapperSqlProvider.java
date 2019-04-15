package com.example.datajdbc.mapper;

import org.apache.ibatis.jdbc.SQL;

public class IncomeMapperSqlProvider {

    public static final String YEAR="year";
    public  static  final  String MOUNTH="mounth";

    public String selectAllByConditions(String type, String conditions){
        SQL sql = new SQL();
        sql.SELECT(selectHanldeConditions(type));
        sql.SELECT("SUM(money) AS sum,sum(weight) as weight,round(AVG(unitprice), 2) as unitprice,name");
        sql.FROM("income,vegetables");
        sql.WHERE("`income`.`vegetable`= `vegetables` .`id`");
        sql.WHERE(whereHanldeConditions(type,conditions));
        sql.GROUP_BY(groupByConditisons(type));
        return sql.toString();
    }
    private String selectHanldeConditions(String type){
        String select=new String();
        switch (type){
            case YEAR:
                select= "date_format(datetime,'%Y-%m') as datetime";
                break;
            case MOUNTH:
                select=  "datetime";
                break;
        }
        return  select;
    }
    private String whereHanldeConditions(String type, String conditions){
        switch (type){
            case YEAR:
                conditions="YEAR(datetime) IN('"+conditions+"') ";
                break;
            case MOUNTH:
                conditions="DATE_FORMAT(datetime,'%Y-%m') IN('"+conditions+"')";
                break;
        }
        return  conditions;

    }
    private String groupByConditisons(String type){
        String groupBy=new String();
        switch (type){
            case YEAR:
                groupBy="MONTH (datetime)";
                break;
            case MOUNTH:
                groupBy="datetime";
                break;
        }
        return groupBy;
    }
}
