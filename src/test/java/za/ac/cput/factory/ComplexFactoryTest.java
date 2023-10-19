package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Complex;

import static org.junit.jupiter.api.Assertions.*;

class ComplexFactoryTest {
    @Test
    void createComplex() {
        Complex createComplex = ComplexFactory.createComplex("Libertas", "35A", "3", "Cape Town", "Western Cape", "Parow","7500", "South Africa");

        assertNotNull(createComplex);

        System.out.println("Original Complex: " + createComplex);

        Complex updatedComplex = createComplex.toBuilder().unit("25A").build();

        assertNotNull(updatedComplex);


        System.out.println("Updated Complex: " + updatedComplex);
    }
}