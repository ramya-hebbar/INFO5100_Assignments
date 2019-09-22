/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO

        double sumOfAllSalaries = 0.0;

        for (Employee e : employees) {
            double currentEmployeeSalary = e.getSalary();

            if(currentEmployeeSalary > 5000) {
                sumOfAllSalaries += currentEmployeeSalary;
            }
        }

        return sumOfAllSalaries;
    }


    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        // @TODO

        int empId = employee.getId();

        if(empId % 3 == 0 && empId % 5 == 0) {
            System.out.println("FizzBuzz");
        }
        else if(empId % 3 == 0) {
            System.out.println("Fizz");
        }
        else if(empId % 5 == 0) {
            System.out.println("Buzz");
        }
    }


    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        // @TODO

        double empSalary = employee.getSalary();

        double empTax = 0.0;

        if(empSalary <= 2500) {
            empTax = empSalary * 10 /100;
        }
        else if(empSalary > 2500 && empSalary <= 5000) {
            empTax = empSalary * 25/100;
        }
        else {
            empTax = empSalary * 35/100;
        }

        return empTax;
    }


    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO

        double tempVarForFirstSalary = firstEmployee.getSalary();

        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tempVarForFirstSalary);
    }


    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO

        int countOfEmployeesAbove50 = 0;

        for (Employee e : employees) {
            if(e.getAge() > 50) {
                countOfEmployeesAbove50++;
            }
        }

        return countOfEmployeesAbove50;
    }


    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO

        String currentName = employee.getFirstName();

        char[] reversedCharactersOfName = new char[currentName.length()];

        for (int i = 0; i < currentName.length(); i++) {
            reversedCharactersOfName[currentName.length() - i - 1] = currentName.charAt(i);
        }

        String reversedName = new String(reversedCharactersOfName);
        employee.setFirstName(reversedName);
    }


    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        // @TODO

        String empFirstName = employee.getFirstName();

        CharSequence digits = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";

        if(empFirstName.contains(digits)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }


    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public void tripleSalary(Employee employee) {
        // @TODO

        employee.raiseSalary(3.0);
    }


    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */

    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        // @TODO

        for (int i = 0; i < employeesStr.length; i++) {

            String empRecord = employeesStr[i];

            String[] splitRecord = empRecord.split(",");

            int empID = Integer.valueOf(splitRecord[0]);
            String empFirstName = splitRecord[1];
            int empAge = Integer.valueOf(splitRecord[2]);
            double empSalary = Double.valueOf(splitRecord[3]);

            Employee employee = new Employee(empID, empFirstName , empAge, empSalary);
            employees[i] = employee;
        }

        return employees;
    }
}