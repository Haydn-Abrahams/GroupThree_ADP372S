package za.ac.cput.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payroll;
import za.ac.cput.factory.PayrollFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PayrollServiceImplTest {
    @Autowired
    private PayrollServiceImpl service;
    private static Payroll payroll1 = PayrollFactory.buildPayroll("Detailer", 21, 2,90,15390);

    @Test
    void a_create() {
        Payroll created = service.create(payroll1);
        assertEquals(payroll1.getPaymentID(), created.getPaymentID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Payroll read = service.read(payroll1.getPaymentID());
        Assertions.assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Payroll payrollUpdate = new Payroll.Builder().copy(payroll1).setOvertime(3).setSalaryAmount(15525).build();
        Payroll updated = service.update(payrollUpdate);
        assertNotNull(payrollUpdate.getPaymentID(), updated.getPaymentID());
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = service.delete(payroll1.getPaymentID()) ;
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }
}