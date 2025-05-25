package com.example.project.controller;

import com.example.project.dto.ProjectDTO;
import com.example.project.entity.Project;
import com.example.project.serviceImpli.ProjectServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpli projectServiceImpli;

    @PostMapping("/save")
    public Project create(@RequestBody ProjectDTO projectDto) {

        return projectServiceImpli.create(projectDto);
    }

@GetMapping("/list")
    public List<ProjectDTO> getList() {

        return projectServiceImpli.getList();
    }

@GetMapping("/get")
    public Project getById(@RequestParam Long id) {
        return projectServiceImpli.getById(id);
    }

@PutMapping("/update")
    public Project updateById(@RequestParam Long id, @RequestBody ProjectDTO projectDto) {

        return projectServiceImpli.updateById( id, projectDto);
    }

@DeleteMapping("/delete")
    public String deleteById(@RequestParam Long id) {

       return projectServiceImpli.deleteById( id);
    }

}
