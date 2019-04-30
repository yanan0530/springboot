package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Projects;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectsMapper {

    //查看所有
    @Select("select sum(income.money)as sum,\n" +
            "       projects.id,\n" +
            "       projects.vegeid,\n" +
            "       projects.createtime,\n" +
            "       projects.endtime,\n" +
            "       projects.state,\n" +
            "       sum(income.weight) as weight,\n" +
            "       round(avg(income.unitprice),2) as average,vegetables.name\n" +
            "from projects projects\n" +
            "left join  income income on income.project_id = projects.id\n" +
            "left join vegetables vegetables on  projects.vegeid=vegetables.id\n" +
            "group by projects.id DESC")
    List<Projects> getProjectsAll();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into projects(vegeid,createtime,endtime,state,sum,weight,average) values(#{vegeid},#{createtime},#{endtime},#{state},#{sum},#{weight},#{average})")
    void addProject(Projects projects);

    @Delete("delete from projects where id=#{id}")
    void  delProject(Integer id);

    //更新
    @Update("update projects set state=#{state},endtime=#{endtime} where id=#{id}")
    void updateProjectById(Projects projects);

    @Select("select * from projects,vegetables where projects.vegeid=vegetables.id and projects.state=#{state}")
    List<Projects> getProjectByState(Integer state);

}
