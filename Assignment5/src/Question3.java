public class Question3 {
}

abstract class Employee {
    private String name;
    private int paymentPerHour;

    //Constructors

    public Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    //Methods

    public abstract int calculateSalary();
}

class FullTime extends Employee {

    public FullTime(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return 0;
    }
}

class Contractor extends Employee {
    private int workingHours;

    public Contractor(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);

        this.workingHours = workingHours;
    }

    @Override
    public int calculateSalary() {
        return 0;
    }
}