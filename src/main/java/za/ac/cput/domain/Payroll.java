package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Payroll implements Serializable {
    @Id
    //@Column(name = "paymentID")
    private String paymentID;
    private String title;
    private int totalDaysWorked;
    private int overtime;
    private int hourlyRate;
    private double salaryAmount;

    protected Payroll() {}

    public Payroll(String paymentID, String title, int totalDaysWorked, int overtime, int hourlyRate, double salaryAmount) {
        this.paymentID = paymentID;
        this.title = title;
        this.totalDaysWorked = totalDaysWorked;
        this.overtime = overtime;
        this.hourlyRate = hourlyRate;
        this.salaryAmount = salaryAmount;
    }

    public Payroll(Builder builder) {
        this.paymentID = builder.paymentID;
        this.title = builder.title;
        this.totalDaysWorked = builder.totalDaysWorked;
        this.overtime = builder.overtime;
        this.hourlyRate = builder.hourlyRate;
        this.salaryAmount = builder.salaryAmount;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalDaysWorked() {
        return totalDaysWorked;
    }

    public int getOvertime() {
        return overtime;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payroll payroll = (Payroll) o;
        return totalDaysWorked == payroll.totalDaysWorked && overtime == payroll.overtime && hourlyRate == payroll.hourlyRate && Double.compare(payroll.salaryAmount, salaryAmount) == 0 && Objects.equals(paymentID, payroll.paymentID) && Objects.equals(title, payroll.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, title, totalDaysWorked, overtime, hourlyRate, salaryAmount);
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "PaymentID='" + paymentID + '\'' +
                ", title='" + title + '\'' +
                ", totalDaysWorked=" + totalDaysWorked +
                ", overtime=" + overtime +
                ", hourlyRate=" + hourlyRate +
                ", salaryAmount=" + salaryAmount +
                '}';
    }

    public static class Builder {
        private String paymentID;
        private String title;
        private int totalDaysWorked;
        private int overtime;
        private int hourlyRate;
        private double salaryAmount;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTotalDaysWorked(int totalDaysWorked) {
            this.totalDaysWorked = totalDaysWorked;
            return this;
        }

        public Builder setOvertime(int overtime) {
            this.overtime = overtime;
            return this;
        }

        public Builder setHourlyRate(int hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public Builder setSalaryAmount(double salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }
        public Builder copy(Payroll payroll) {
            this.paymentID = payroll.paymentID;
            this.title = payroll.title;
            this.totalDaysWorked = payroll.totalDaysWorked;
            this.overtime = payroll.overtime;
            this.hourlyRate = payroll.hourlyRate;
            this.salaryAmount = payroll.salaryAmount;
            return this;
        }
        public Payroll build() {
            return new Payroll(this);
        }
    }
}
