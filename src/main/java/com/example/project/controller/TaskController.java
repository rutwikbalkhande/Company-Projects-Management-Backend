package com.example.project.controller;

import com.example.project.dto.TaskDTO;
import com.example.project.entity.Task;
import com.example.project.serviceImpli.TaskServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskServiceImpli taskService;

    @PostMapping("/save")
    public TaskDTO create(@RequestBody TaskDTO taskDto) {
        return taskService.create( taskDto );
    }

   @GetMapping("/list")
    public List<TaskDTO> getList() {
        return taskService.getList();
    }

    @GetMapping("/get")
    public Task getByid(@RequestParam Long id) {
        return taskService.getByid( id);
    }

    @PutMapping("/update")
    public TaskDTO upadateById(@RequestParam Long id, @RequestBody TaskDTO taskDto) {
        return taskService.upadateById(id , taskDto);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long Id) {
      return  taskService.deleteById( Id);
    }
}
