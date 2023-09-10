package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final IEmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee read(String employeeCode) {
        return repository.findById(employeeCode).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        if (repository.existsById(employee.getEmployeeCode())) {
            return repository.save(employee);
        }
        return null;
    }

    @Override
    public boolean delete(String employeeCode) {
        if (repository.existsById(employeeCode)) {
            repository.deleteById(employeeCode);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }
}