package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Residential;
import za.ac.cput.factory.ResidentialFactory;
import za.ac.cput.repository.BaseAddressRepository;
import za.ac.cput.repository.ResidentialRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ResidentialServiceTest {
    private static BaseAddressRepository baseAddressRepository;
    private static ResidentialRepository residentialRepository;
    @Autowired
    private ResidentialService residentialService;
    @Autowired
    private BaseAddressService baseAddressService;
    private static Residential residential1 = ResidentialFactory.createResidential("87 King Edward Road", "Cape Town", "Western Cape", "Parow", "7500", "South Africa");
    private static Residential residential2 = ResidentialFactory.createResidential("18 Kloser Street", "Cape Town", "Western Cape", "Delft", "7500", "South Africa");

    @Test
    @Order(1)
    void save() {
        Residential created1 = residentialService.save(residential1);
        assertNotNull(created1.getId());
        assertNotNull(created1.getBaseAddress().getId());
        System.out.println("Saved: ");
        System.out.println(created1);

        Residential created2 = residentialService.save(residential2);
        assertNotNull(created2.getId());
        assertNotNull(created2.getBaseAddress().getId());
        System.out.println("Saved: ");
        System.out.println(created2);


    }

    @Test
    @Order(2)
    void getById() {
        Residential readById = residentialService.getById(residential1.getId());
        assertNotNull(readById);
        System.out.println("Read: " + readById);
    }

    @Test
    @Order(3)
    void update() {
        Residential updatedResidential = residential1.toBuilder().baseAddress(residential1.getBaseAddress().toBuilder().city("Port Elizabeth").build()).street_Address("107 Klosser Street").build();
        Residential saveResidential = residentialService.save(updatedResidential);
        assertNotNull(saveResidential);
        System.out.println("Updated Residential: " + saveResidential);
    }

    @Test
    @Order(4)
//    @Disabled
    void deleteById() {
        residentialService.deleteById(residential2.getId());
        System.out.println("Deleted: ");

    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Show All: ");
        System.out.println(residentialService.getAll());
    }

}