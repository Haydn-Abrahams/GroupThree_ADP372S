package za.ac.cput.service;

import za.ac.cput.domain.Employee;

import java.util.List;

public interface EmployeeService {
        Employee create(Employee employee);

        Employee read(String employeeCode);

        Employee update(Employee employee);

        boolean delete(String employeeCode);

        List<Employee> getAll();
        }
