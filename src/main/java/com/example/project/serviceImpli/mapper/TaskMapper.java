package com.example.project.serviceImpli.mapper;

import com.example.project.dto.TaskDTO;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import com.example.project.repository.EmployeeRepository;
import com.example.project.repository.ProjectRepository;
import com.example.project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private EmployeeRepository employeeRepo ;


    //DTOtoEntity convert
    public Task dtoToentity(TaskDTO taskDto)
    {
        Task task = new Task();

        task.setName(taskDto.getName());
        task.setDeadline(taskDto.getDeadline());
        task.setStatus(taskDto.getStatus());
        task.setResponsibility(taskDto.getResponsibility());
        task.setDescription(taskDto.getDescription());

        if (taskDto.getEmployeeId() != null) {
            Employee emp = employeeRepo.findById(taskDto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            task.setEmployee(emp);
        }

        if (taskDto.getProjectId() != null) {
            Project pro = projectRepo.findById(taskDto.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            task.setProject(pro);
        }

        return task;

    }


    //entitytoDTO convert
    public TaskDTO entityToDto (Task task)
    {

        TaskDTO taskDto= new TaskDTO();

        taskDto.setName(task.getName());
        taskDto.setDeadline(task.getDeadline());
        taskDto.setStatus(task.getStatus());
        taskDto.setResponsibility(task.getResponsibility());
        taskDto.setDescription(task.getDescription());

        if (task.getEmployee() != null) {
            taskDto.setEmployeeId(task.getEmployee().getId());
        }

        if (task.getProject() != null) {
            taskDto.setProjectId(task.getProject().getId());
        }

        return taskDto;
    }


}
