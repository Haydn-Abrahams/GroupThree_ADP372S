package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Payroll;

import java.util.List;

public interface PayrollService  {

    Payroll create(Payroll payroll);

    Payroll read(String employeeCode);

    Payroll update(Payroll payroll);

    boolean delete(String employeeCode);
    List<Payroll> getAll();
}
