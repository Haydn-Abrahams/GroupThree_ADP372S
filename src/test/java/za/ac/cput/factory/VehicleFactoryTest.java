package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Vehicle;
import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {
    @Test
    public void test(){
        Vehicle vehicle =VehicleFactory.createVehicle("2356236","CAA 291243","Volkswagen","white","Golf GTI 6");
        System.out.println(vehicle.toString());
        assertNotNull(vehicle);
    }


}