package Question2;

enum Gender {
    MALE,
    FEMALE
}

public class Student {
    private String id;
    private String name;
    private Gender gender;
    private float gpa;

    //Constructor
    public Student(String id, String name, Gender gender, float gpa) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.gpa = gpa;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}

