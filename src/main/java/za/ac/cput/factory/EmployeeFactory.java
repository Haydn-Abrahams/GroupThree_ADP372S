package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Employee;

public class EmployeeFactory {
    public static Employee createEmployee( int id, String firstName, String lastName, String password) {

        if(Helper.isNullorEmpty(String.valueOf(id)) || Helper.isNullorEmpty(firstName)
                || Helper.isNullorEmpty(lastName)|| Helper.isNullorEmpty(password))
            return null;

        String employeeCode = Helper.generateID();

        return new Employee.Builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setEmployeeCode(employeeCode)
                .build();
    }
}
