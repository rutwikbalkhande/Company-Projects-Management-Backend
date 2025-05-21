package com.example.project.service;

import com.example.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO create(ProjectDTO projectDto);

    List<ProjectDTO> getList();

    ProjectDTO getByid(Long id);
}
