package ro.fortech.employee.service;

public class EmployyeNotFoundException extends RuntimeException {
    public EmployyeNotFoundException(String id) {
        super(id);
    }
}
