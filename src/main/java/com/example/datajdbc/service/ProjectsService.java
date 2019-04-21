package com.example.datajdbc.service;

import com.example.datajdbc.pojo.Projects;

import java.util.List;

public interface ProjectsService {

    List<Projects> getAll();
    void addProject(Projects projects);

    void delProject(Integer id);

    void updateProjectById(Projects projects);

    List<Projects>getStateList(Integer state);
}
