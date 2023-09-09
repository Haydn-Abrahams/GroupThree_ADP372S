package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payroll;

public interface IPayrollRepository extends JpaRepository<Payroll, String> {
}
