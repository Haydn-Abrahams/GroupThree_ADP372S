package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payroll;

import static org.junit.jupiter.api.Assertions.*;

class PayrollFactoryTest {

    @Test
    void buildPayroll() {
        Payroll payroll1 =  PayrollFactory.buildPayroll("Detailer", 23, 2, 90,16830.00);
        System.out.println(payroll1.toString());
        assertNotNull(payroll1);
    }


}