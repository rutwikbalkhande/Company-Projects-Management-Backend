package com.example.project.service;

import com.example.project.dto.TaskDTO;
import com.example.project.entity.Task;

import java.util.List;

public interface TaskService {

   Task create(TaskDTO taskDto);

   List<TaskDTO> getList();

   Task getByid(Long id);

   Task upadateById(Long id ,  TaskDTO taskDto);

   void deleteById(Long Id);
}
