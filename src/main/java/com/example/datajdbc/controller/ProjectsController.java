package com.example.datajdbc.controller;


import com.example.datajdbc.pojo.Projects;
import com.example.datajdbc.pojo.Records;
import com.example.datajdbc.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yn")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;

    @PostMapping("/project")
    public boolean saveProject(@RequestBody Projects projects) {
        if (projects.getId() == null) {
            projectsService.addProject(projects);
        } else {

        }
        return true;
    }

    @GetMapping("/project")
    public List<Projects> getAll() {
        return projectsService.getAll();
    }

    @GetMapping("/projectdel")
    public boolean delProjectsById(@RequestParam("id") Integer id) {
        projectsService.delProject(id);
        return true;
    }

    @PostMapping("/projectsupdate")
    public boolean updateProjectById(@RequestBody Projects projects) {
        projectsService.updateProjectById(projects);
        return true;
    }

    @GetMapping("/projects/state")
    public List<Projects> getProjectByState(@RequestParam(value = "state", defaultValue = "1") Integer state) {
        return projectsService.getStateList(state);
    }

}
