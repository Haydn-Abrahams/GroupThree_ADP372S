package za.ac.cput.util.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.util.domain.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,String> {

}
