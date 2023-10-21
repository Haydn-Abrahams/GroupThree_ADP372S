package za.ac.cput.factory;
import za.ac.cput.domain.Vehicle;
import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {


    public void test(){
        Vehicle vehicle =VehicleFactory.createVehicle("CAA87986","John Hendricks","volswagen","white","white","GTI");
        System.out.println(vehicle.toString());
        assertNotNull(vehicle);
    }


}