package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Employee;
import com.HippyAir.hippyair_backend.Model.User;
import com.HippyAir.hippyair_backend.DTO.EmployeeDTO;
import com.HippyAir.hippyair_backend.Repository.EmployeeRepository;
import com.HippyAir.hippyair_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new employee linked to an existing user
    public Employee createEmployee(EmployeeDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Employee employee = new Employee();
        employee.setProfession(dto.getProfession());
        employee.setTitle(dto.getTitle());
        employee.setUser(user);

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

    // Update employee info
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = getEmployeeById(id);
        employee.setProfession(dto.getProfession());
        employee.setTitle(dto.getTitle());

        // Optional: update linked user if needed
        if (dto.getUserId() != null && !dto.getUserId().equals(employee.getUser().getIdUser())) {
            User newUser = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("New user not found"));
            employee.setUser(newUser);
        }

        return employeeRepository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
