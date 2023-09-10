package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(long id , String firstName, String lastName){

        if(Helper.isNullorEmpty(String.valueOf(id)) || Helper.isNullorEmpty(firstName) || Helper.isNullorEmpty(lastName))
            return null;

        String employeeCode = Helper.generateID();

        return new Employee.Builder()
                .setId((int) id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmployeeCode(employeeCode)
                .build();
    }
}
