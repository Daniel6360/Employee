package ro.fortech.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.employee.repository.EmployeeEntity;
import ro.fortech.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void addEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }
}
