package com.example.datajdbc.service.impl;

import com.example.datajdbc.mapper.ProjectsMapper;
import com.example.datajdbc.pojo.Projects;
import com.example.datajdbc.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    private ProjectsMapper projectsMapper;

    @Override
    public List<Projects> getAll() {
        return projectsMapper.getProjectsAll();
    }

    @Override
    public void addProject(Projects projects) {
        projectsMapper.addProject(projects);
    }

    @Override
    public void updateProjectById(Projects projects) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 0 代表季度结束  1 代表正在种植
        if(projects.getState()==1){
            projects.setState(0);
            projects.setEndtime(dateFormat.format(new Date()));
        }else {
            projects.setState(1);
            projects.setEndtime(null);
        }
        System.out.println(projects.getEndtime());
        projectsMapper.updateProjectById(projects);
    }

    @Override
    public List<Projects> getStateList(Integer state) {
        return projectsMapper.getProjectByState(state);
    }

    @Override
    public void delProject(Integer id) {
        projectsMapper.delProject(id);
    }


}
