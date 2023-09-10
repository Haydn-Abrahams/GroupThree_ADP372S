package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payroll;
import za.ac.cput.repository.IPayrollRepository;
import za.ac.cput.service.PayrollService;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {
    private IPayrollRepository repository;
    @Autowired
    private PayrollServiceImpl(IPayrollRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payroll create(Payroll payroll) {
        return this.repository.save(payroll);
    }

    @Override
    public Payroll read(String employeeCode) {
        return this.repository.findById(employeeCode).orElse(null);
    }

    @Override
    public Payroll update(Payroll payroll) {
        if(this.repository.existsById(payroll.getEmployeeCode())) {
            return this.repository.save(payroll);
        }
        return null;
    }

    @Override
    public boolean delete(String employeeCode) {
        if (this.repository.existsById(employeeCode)) {
            this.repository.deleteById(employeeCode);
            return true;
        }
        return false;
    }

    @Override
    public List<Payroll> getAll() {
        return this.repository.findAll();
    }
}
