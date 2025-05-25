package com.example.project.serviceImpli;

import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Address;
import com.example.project.entity.Client;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.repository.AddressRepository;
import com.example.project.repository.ClientRepository;
import com.example.project.repository.EmployeeRepository;
import com.example.project.repository.ProjectRepository;
import com.example.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpli implements EmployeeService {

    private final EmployeeRepository employeeRepo;

    private final AddressRepository addressRepo;

    private final ClientRepository clientRepo;

    private final ProjectRepository projectRepo;

    @Override
    public Employee create( EmployeeDTO employeeDto) {
        Employee employee=new Employee();
      /*  BeanUtils.copyProperties(employeeDto,employee);
        System.out.println(employee);
        */
        employee.setName( employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setRole(employeeDto.getRole());
        employee.setAsset(employeeDto.getAsset());
        employee.setJoiningDate(employeeDto.getJoiningDate());

        //save project Id
        Project project = projectRepo.findById(employeeDto.getProjectId()).orElseThrow(() -> new RuntimeException("Project not Found."));
        employee.setProject(project);

        //client Id save link in employee table
       Client client=  clientRepo.findById(employeeDto.getClientId()).
                                  orElseThrow(()-> new RuntimeException("not fount client id: " + employeeDto.getClientId() ));
             employee.setClient(client);

             //Address Id save in Employee table
         Address  address= addressRepo.findById(employeeDto.getAddressId()).
                                              orElseThrow( () -> new RuntimeException("address id not found"));
               employee.setAddress(address);

        return employeeRepo.save(employee);
    }


    @Override
    public List<EmployeeDTO> getList() {
        return employeeRepo.findAll().stream().map(EmployeeDTO :: new).collect(Collectors.toList());
    }


    @Override
    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not found with id: "+ id)) ;
    }


    @Override
    public Employee updateById(Long id, EmployeeDTO employeeDto) {

       return employeeRepo.findById(id).map(emp ->{

            emp.setName(employeeDto.getName());
            emp.setEmail(employeeDto.getEmail());
            emp.setPhone(employeeDto.getPhone());
            emp.setRole(employeeDto.getRole());
            emp.setAsset(employeeDto.getAsset());

            return  employeeRepo.save(emp);
        }) .orElseThrow(() -> new RuntimeException("employee not found with id: "+ id)) ;

    }

    @Override
    public String deleteById(Long id) {

     Employee employee=   employeeRepo.findById(id).orElseThrow();
        employeeRepo.delete(employee);
        return "employee delete successfully using id:"+ id;
    }
}
