package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Projects;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectsMapper {

    //查看所有
    @Select("select * from projects,vegetables where projects.vegeid=vegetables.id")
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
