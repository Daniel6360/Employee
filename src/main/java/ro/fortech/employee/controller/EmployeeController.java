package ro.fortech.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.fortech.employee.repository.EmployeeEntity;
import ro.fortech.employee.service.EmployeeService;

@RestController
public class EmployeeController {

    EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void addEmployee(@RequestBody EmployeeEntity employeeEntity) {
        service.addEmployee(employeeEntity);
    }
}
