package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.model.Employee;
import com.HippyAir.hippyair_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Update employee
    public Employee updateEmployee(Long id, Employee empDetails) {
        Employee employee = getEmployeeById(id);
        employee.setProfession(empDetails.getProfession());
        employee.setTitle(empDetails.getTitle());
        employee.setUser(empDetails.getUser());
        return employeeRepository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
