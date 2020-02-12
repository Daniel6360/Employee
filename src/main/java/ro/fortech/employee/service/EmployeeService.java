package ro.fortech.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.employee.controller.EmployeeDto;
import ro.fortech.employee.repository.EmployeeEntity;
import ro.fortech.employee.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void addEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> findByCnp(String cnp) {
        return employeeRepository.findByCnp(cnp);
    }

    public EmployeeDto update(String cnp, EmployeeDto employeeDto) throws EmployyeNotFoundException{


        if (employeeRepository.findByCnp(cnp).isPresent()) {
            EmployeeEntity existing = employeeRepository.findByCnp(cnp).get();
            existing.setFirstName(employeeDto.getFirstName());
            existing.setLastName(employeeDto.getLastName());
            EmployeeEntity updated = employeeRepository.save(existing);
            return employeeDto;
        } else{
            throw new EmployyeNotFoundException("Employee doesn't exist");
        }
    }

    public void deleteByCnp(String cnp){
        employeeRepository.deleteByCnp(cnp);
    }

}
