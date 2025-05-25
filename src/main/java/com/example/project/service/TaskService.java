package com.example.project.service;

import com.example.project.dto.TaskDTO;
import com.example.project.entity.Task;

import java.util.List;

public interface TaskService {

   TaskDTO create(TaskDTO taskDto);

   List<TaskDTO> getList();

   Task getByid(Long id);

   TaskDTO upadateById(Long id ,  TaskDTO dto);

   String deleteById(Long id);
}
