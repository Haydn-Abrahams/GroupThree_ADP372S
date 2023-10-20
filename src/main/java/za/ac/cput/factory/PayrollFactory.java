package za.ac.cput.factory;

import za.ac.cput.domain.Payroll;
import za.ac.cput.util.Helper;

public class PayrollFactory {
    public static Payroll buildPayroll(String title, int totalDaysWorked, int overtime, int hourlyRate, double salaryAmount) {
        if (Helper.isNullorEmpty(title)|| Helper.isNullorEmpty(String.valueOf(totalDaysWorked))
                || Helper.isNullorEmpty(String.valueOf(hourlyRate)) || Helper.isNullorEmpty(String.valueOf(salaryAmount))) {
            return null;
        }
        String paymentID = Helper.generateID();

        return new Payroll.Builder()
                .setPaymentID(paymentID)
                .setTitle(title)
                .setTotalDaysWorked(totalDaysWorked)
                .setOvertime(overtime)
                .setHourlyRate(hourlyRate)
                .setSalaryAmount(salaryAmount)
                .build();
    }
}
