package ro.fortech.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.employee.controller.EmployeeDto;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByCnp(String cnp);

    Optional<EmployeeEntity> getByCnp(String cnp);
    void deleteByCnp(String cnp);
}
