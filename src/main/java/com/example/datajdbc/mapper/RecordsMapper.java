package com.example.datajdbc.mapper;

import com.example.datajdbc.pojo.Records;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface RecordsMapper {

    //查看所有
    @Select("select * from records,projects,vegetables where records.projectid=projects.id and projects.vegeid=vegetables.id order by records.createtime desc")
    List<Records> getRecordsAll();

    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into records(projectid,createtime,thingid,remarks,areaid) values(#{projectid},#{createtime},#{thingid},#{remarks},#{areaid})")
    void saveRecords(Records records);

    @Delete("delete from records where id=#{id}")
    void delRecords(Integer id);

    //更新
    @Update("update records set areaid=#{areaid} where id=#{id}")
    void updateRecordsById(Records records);

    //根据项目Id 获取所有操作记录
    @Select("select * from records where projectid=#{id} order by createtime asc")
    List<Records> getRecordsByProjectId(Integer id);
}
