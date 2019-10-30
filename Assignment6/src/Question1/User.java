package Question1;

public class User {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;

    //CONSTRUCTOR

    public User(String name, int age, String address, String phoneNumber, String bankAccountNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    //GETTERS

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
