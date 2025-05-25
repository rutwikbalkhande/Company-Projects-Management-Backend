package com.example.project.serviceImpli;

import com.example.project.dto.TaskDTO;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import com.example.project.repository.EmployeeRepository;
import com.example.project.repository.ProjectRepository;
import com.example.project.repository.TaskRepository;
import com.example.project.service.TaskService;
import com.example.project.serviceImpli.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpli implements TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskDTO create(TaskDTO taskDto) {
        Task task = taskMapper.dtoToentity(taskDto);
        Task saved = taskRepo.save(task);
        return taskMapper.entityToDto(saved);
    }

   @Override
    public List<TaskDTO> getList() {
        return taskRepo.findAll()
                .stream()
                .map(TaskDTO :: new)     //   .map(taskMapper::entityToDto)
                .toList();
    }



    @Override
    public Task getByid(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task ID not found: " + id));
    }

    @Override
    public TaskDTO upadateById(Long id, TaskDTO dto) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setDeadline(dto.getDeadline());
        task.setResponsibility(dto.getResponsibility());
        task.setStatus(dto.getStatus());

        if (dto.getEmployeeId() != null) {
            Employee employee = employeeRepo.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            task.setEmployee(employee);
        }

        if (dto.getProjectId() != null) {
            Project project = projectRepo.findById(dto.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            task.setProject(project);
        }

        Task updated = taskRepo.save(task);
        return taskMapper.entityToDto(updated);
    }

    @Override
    public String deleteById(Long id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found: " + id));
        taskRepo.delete(task);
        return "Task deleted successfully";
    }
}
