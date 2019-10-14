/*
1. Explain the difference between `final` and `finally` in Java 8.

The final keyword is used to depict that a certain variable/class/method is the last version of declaration
and cannot be further changed/extended/overwritten respectively.

Examples:

a. variable declared as final

class ExampleMath {
    final double PI = 22 / 7; //this value is constant and cannot be changed - hence final
}

b. class declared as final

    final class Doctor extends Person { //"final" in front of a class means it cannot be extended

    }

c. method declared as final

public class Person {

    private final String name; // "final" in front of data means it cannot be changed after being initialized

    Person(String name) {
        this.name = name;
    }

    public final void eat() { // "final" in front of a method means it cannot be overwritten
        System.out.println("Eat the choco-lava cake!");
    }
}


The finally keyword is used with the try-catch block while checking for exceptions. A single try block can be followed
with multiple catch blocks, hence checking for various possible exceptions. At the end of all the possible catch blocks,
there can exist a block of code with the finally keyword which gets executed irrespective of which of the catch blocks
get called.

Example:

class EmployeeNotHungryException extends RuntimeException {

}

class EmployeeFastingException extends RuntimeException {

}

private static void letEmployeeGoForLunch(Employee e) {
        //one try can have multiple catch blocks

        try {
            e.goForLunch();
        }
        catch (EmployeeNotHungryException enhe) {
            System.out.println("I'm not hungry - I won't eat");
        }
        catch (EmployeeFastingException efe) {
            System.out.println("I'm on a fast - I won't eat");
        }
        finally {
            //piece of code which gets executed irrespective of which of the above block executes
            System.out.println("There's always room for dessert - Let's eat!!");
        }
}

*/