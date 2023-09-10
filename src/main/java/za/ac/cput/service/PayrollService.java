package za.ac.cput.service;

import za.ac.cput.domain.Payroll;

import java.util.List;

public interface PayrollService extends IService<Payroll, String> {
    List<Payroll> getAll();
}
