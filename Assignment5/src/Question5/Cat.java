package Question5;

import java.util.Date;

public class Cat extends Pet implements Boardable {
    private String hairLength;

    public Date boardingStart = new Date();

    public Date boardingEnd = new Date();

    //Constructor
    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    //Getter

    public String getHairLength() {
        return hairLength;
    }

    //Methods

    @Override
    public String toString() {
        return super.getPetName() + " owned by " + super.getOwnerName() + "\n" +
                "Color: " + super.getColor() + "\n" +
                "Sex: " + getSex() + "\n" +
                "Hair: " + this.hairLength;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        boardingStart = new Date(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        boardingEnd = new Date(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Date givenDate = new Date(year, month, day);

        if((givenDate.compareTo(boardingStart) == 0) || (givenDate.compareTo(boardingStart) > 0) &&
                (givenDate.compareTo(boardingEnd) == 0) || (givenDate.compareTo(boardingEnd) < 0)) {
            return true;
        }

        return false;
    }
}
