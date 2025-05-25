package com.example.project.serviceImpli;

import com.example.project.dto.EmployeeDTO;
import com.example.project.dto.ProjectDTO;
import com.example.project.dto.TaskDTO;
import com.example.project.entity.Client;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import com.example.project.repository.ClientRepository;
import com.example.project.repository.EmployeeRepository;
import com.example.project.repository.ProjectRepository;
import com.example.project.repository.TaskRepository;
import com.example.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor          //@Required ArgsConstructor in the place of @Autowired It will work when
public class ProjectServiceImpli implements ProjectService {      // repository declare final 7 generate constructor

      private final ProjectRepository projectRepo;
      private final ClientRepository clientRepo;
      private final EmployeeRepository employeeRepo ;
      private final TaskRepository taskRepo;


    @Override
    public Project create(ProjectDTO projectDto) {

        Project project= new Project();

        project.setName(projectDto.getName());
        project.setProjectStartDate(projectDto.getProjectStartDate());
        project.setProjectEndDate(projectDto.getProjectEndDate());
        project.setStatus(projectDto.getStatus());
         project.setDescription(projectDto.getDescription());

        if(projectDto.getClientId() != null) {
            Client client = clientRepo.findById(projectDto.getClientId()).orElseThrow(() ->
                    new RuntimeException("clientId not found" + projectDto.getClientId()));

            project.setClient(client);
        }

        List<Employee> employees = projectDto.getEmployeeDto().stream()
                .map(e -> employeeRepo.findById(e.getId())
                        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + e.getId())))
                .collect(Collectors.toList());
        project.setEmployee(employees);


        List<Task> task = projectDto.getTaskDto().stream()
                .map(t -> taskRepo.findById(t.getId())
                        .orElseThrow(() -> new RuntimeException("Task not found with id: " + t.getId())))
                .toList();
        project.setTask(task);

        return projectRepo.save(project) ;
    }

    @Override
    public List<ProjectDTO> getList() {
        return projectRepo.findAll().stream().map(ProjectDTO :: new).toList();
    }

    @Override
    public Project getById(Long id) {
        return projectRepo.findById(id).orElseThrow(() ->new RuntimeException("project Id not found " +id));
    }

    @Override
    public Project updateById(Long id, ProjectDTO projectDto) {

     return projectRepo.findById(id).map(p ->{

         p.setName(projectDto.getName());
         p.setDescription(projectDto.getDescription());
         p.setProjectStartDate(projectDto.getProjectStartDate());
         p.setProjectEndDate(projectDto.getProjectEndDate());
         p.setStatus(projectDto.getStatus());

         if(projectDto.getClientId() != null) {
             Client client = clientRepo.findById(projectDto.getClientId()).orElseThrow(() ->
                     new RuntimeException("clientId not found" + projectDto.getClientId()));

             p.setClient(client);
         }

         if(projectDto.getTaskDto()!=null) {
             List<Task> taskList = projectDto.getTaskDto().stream().map(t ->
                     taskRepo.findById(t.getId()).orElseThrow()).toList();

             p.setTask(taskList);
         }

         if (projectDto.getEmployeeDto() != null) {
             List<Employee> employees = projectDto.getEmployeeDto().stream()
                     .map(e -> employeeRepo.findById(e.getId()).orElseThrow())
                     .collect(Collectors.toList());
             p.setEmployee(employees);
         }
         return projectRepo.save(p);
     }).orElseThrow(()->new RuntimeException());

    }

    @Override
    public String deleteById(Long id) {

      Project project=  projectRepo.findById(id).orElseThrow(()-> new RuntimeException("project id not found id: "+ id));
        projectRepo.delete(project);
        return "project delete succwessfulley";
    }
}
