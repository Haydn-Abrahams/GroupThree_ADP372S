package za.ac.cput.domain;

public enum EmployeeTitle {
    MANAGER("Manager"),
    SUPERVISOR("Supervisor"),
    WASHER("Car Washer"),
    CASHIER("Cashier");

    private final String titleDescription;

    EmployeeTitle(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public String getTitleDescription() {
        return titleDescription;
    }
}




