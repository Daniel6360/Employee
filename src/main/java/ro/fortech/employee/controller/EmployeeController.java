package ro.fortech.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fortech.employee.repository.EmployeeEntity;
import ro.fortech.employee.service.EmployeeService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
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

    @GetMapping("/")
    public List<EmployeeDto> getAll() {
        return service.getAll().stream().map(EmployeeDto::toDto).collect(Collectors.toList());

    }

    @GetMapping("/{cnp}")
    public EmployeeDto getByCnp(@PathVariable String cnp) {
        return service.findByCnp(cnp).map(EmployeeDto::toDto).get();
    }

    @PostMapping("/update/{cnp}")
    public void update(@PathVariable String cnp, @RequestBody EmployeeDto employeeDto) {
        service.update(cnp, employeeDto);
    }

    //for debuging purpose
    @GetMapping("/all")
    public List<EmployeeEntity> findAll() {
        return service.getAll();
    }

    @DeleteMapping("/{cnp}")
    @Transactional
    public void deleteByCnp(@PathVariable String cnp){
        service.deleteByCnp(cnp);
    }

}
