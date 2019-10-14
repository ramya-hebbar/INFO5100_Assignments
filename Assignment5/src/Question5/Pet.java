package Question5;

public class Pet {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    private String petName;
    private String ownerName;
    private String color;

    protected int sex;

    //Constructors

    public Pet(String name, String ownerName, String color) {
        this.petName = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    //Getters

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        switch (this.sex) {
            case MALE: {
                return "MALE";
            }

            case FEMALE: {
                return "FEMALE";
            }

            case SPAYED: {
                return "SPAYED";
            }

            case NEUTERED: {
                return "NEUTERED";
            }

            default:
                return "NOT DEFINED";
        }
    }

    public void setSex(int sexid) {
        this.sex = sexid;
    }

    @Override
    public String toString() {
        return this.petName + " owned by " + this.ownerName + "\n" +
                "Color: " + this.color + "\n" +
                "Sex: " + getSex();
    }
}