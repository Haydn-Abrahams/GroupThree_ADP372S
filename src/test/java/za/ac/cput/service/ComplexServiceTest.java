package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Complex;
import za.ac.cput.factory.ComplexFactory;
import za.ac.cput.repository.BaseAddressRepository;
import za.ac.cput.repository.ComplexRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComplexServiceTest {
    private static BaseAddressRepository baseAddressRepository;
    private static ComplexRepository complexRepository;
    @Autowired
    private ComplexService complexService;
    @Autowired
    private BaseAddressService baseAddressService;
    private static Complex createComplex1 = ComplexFactory.createComplex("Libertas", "35A", "3", "Cape Town", "Western Cape", "Parow","7500", "South Africa");
    private static Complex createComplex2 = ComplexFactory.createComplex("Picton", "12B", "1", "Cape Town", "Western Cape", "Delft","7100", "South Africa");

    @Test
    @Order(1)
    void save() {
        Complex created1 = complexService.save(createComplex1);
        assertNotNull(created1.getId());
        System.out.println("Created: " + created1);

        Complex created2 = complexService.save(createComplex2);
        assertNotNull(created2.getId());
        System.out.println("Created: " + created2);
    }

    @Test
    @Order(2)
    void getById() {
        Complex readById = complexService.getById(createComplex1.getId());
        assertNotNull(readById);
        System.out.println("Read: " + readById);
    }
    @Test
    @Order(3)
    void update() {
        Complex updatedComplex = createComplex1.toBuilder().name("Sherif House").build();
        Complex saveComplex = complexService.save(updatedComplex);
        assertNotNull(saveComplex);
        System.out.println("Updated Complex: " + saveComplex);
    }

    @Test
    @Order(4)
    void deleteById() {
       boolean succcess =  complexService.deleteById(createComplex2.getId());
       assertTrue(succcess);
        System.out.println("Deleted: " + succcess);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Show All: ");
        System.out.println(complexService.getAll());
    }
}