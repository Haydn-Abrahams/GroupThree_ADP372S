package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BaseAddress;
import za.ac.cput.domain.Residential;

import static org.junit.jupiter.api.Assertions.*;

class ResidentialFactoryTest {
    @Test
    void createResidential() {
        Residential residential = ResidentialFactory.createResidential("87 King Edward Road", "Cape Town", "Western Cape", "Parow", "7500", "South Africa");
        assertNotNull(residential);

        System.out.println("Original Residential: " + residential);

        Residential updatedResidential = residential.toBuilder().baseAddress(residential.getBaseAddress().toBuilder().city("Port Elizabeth").build()).street_Address("107 Klosser Street").build();

        assertNotNull(updatedResidential);

        System.out.println("Updated Residential: " + updatedResidential);

    }
}