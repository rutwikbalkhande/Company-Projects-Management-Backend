package com.example.project.service;

import com.example.project.dto.ProjectDTO;
import com.example.project.entity.Project;

import java.util.List;

public interface ProjectService {

    Project create(ProjectDTO projectDto);

    List<ProjectDTO> getList();

    Project getById(Long id);

    Project updateById(Long id, ProjectDTO projectDto);

    String deleteById(Long id);
}
