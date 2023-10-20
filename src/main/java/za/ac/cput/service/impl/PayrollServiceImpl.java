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
    public Payroll read(String paymentID) {
        return this.repository.findById(paymentID).orElse(null);
    }

    @Override
    public Payroll update(Payroll payroll) {
        if(this.repository.existsById(payroll.getPaymentID())) {
            return this.repository.save(payroll);
        }
        return null;
    }

    @Override
    public boolean delete(String paymentID) {
        if (this.repository.existsById(paymentID)) {
            this.repository.deleteById(paymentID);
            return true;
        }
        return false;
    }

    @Override
    public List<Payroll> getAll() {
        return this.repository.findAll();
    }
}
