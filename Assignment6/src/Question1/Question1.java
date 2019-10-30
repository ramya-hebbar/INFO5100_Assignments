package Question1;

import java.util.HashMap;
import java.util.Scanner;

public class Question1 {

    ATM atm;

    String loggedInUser;

    public static void main(String[] args) {
        Question1 q1 = new Question1();

        q1.atm = new ATM(9999.99, 0.99);

        while (true) {
            System.out.println("Welcome! User type? NEW/CURRENT");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            if (input.equals("NEW")) {
                //add new user entry

                System.out.println("Enter name of user");

                String name = scanner.next();

                System.out.println("Enter age of user");

                int age = scanner.nextInt();

                System.out.println("Enter address of user");

                String address = scanner.next();

                System.out.println("Enter phone number of user");

                String phoneNumber = scanner.next();

                System.out.println("Enter bank account number to create a new user");

                String bankAccountNumber = scanner.next();

                System.out.println("Enter password for new user");

                String password = scanner.next();

                User newUser = new User(name, age, address, phoneNumber, bankAccountNumber);

                q1.atm.addToUserData(bankAccountNumber, password, newUser);

                q1.loggedInUser = bankAccountNumber;
                q1.performActionsPostLogin();

            } else if (input.equals("CURRENT")) {
                //retrieve user details

                System.out.println("Do you remember credentials to login? Enter YES/NO");

                input = scanner.next();

                if (input.equals("YES")) {
                    System.out.println("Enter bank account number to login");

                    String accNum = scanner.next();

                    System.out.println("Enter password to login");

                    String password = scanner.next();

                    HashMap storedRecord = q1.atm.fetchFromUserData(accNum);

                    if (storedRecord == null) {
                        System.out.println("Record does not exist.");
                    } else {
                        String storedPassword = (String) storedRecord.get("PASSWORD");

                        if(!password.equals(storedPassword)) {
                            System.out.println("Password incorrect. Cannot login.");
                        }
                        else {
                            q1.performActionsPostLogin();
                        }
                    }
                }
                else {
                    System.out.println("Forgot password? YES/NO");

                    input = scanner.next();

                    if(input.equals("YES")) {
                        System.out.println("Enter the following details to reset password");

                        System.out.println("Enter bank account number");

                        String accNum = scanner.next();

                        System.out.println("Enter username");

                        String name = scanner.next();

                        System.out.println("Enter age");

                        int age = scanner.nextInt();

                        System.out.println("Enter phone number");

                        String number = scanner.next();

                        HashMap requestedRecord = q1.atm.fetchFromUserData(accNum);

                        if(requestedRecord == null) {
                            System.out.println("Record does not exist.");
                        }
                        else {
                            User storedUser = (User) requestedRecord.get("USERINFO");

                            if(storedUser.getName().equals(name) &&
                            storedUser.getAge() == age &&
                            storedUser.getPhoneNumber().equals(number)) {
                                System.out.println("Enter new password to reset");

                                input = scanner.next();

                                q1.atm.addToUserData(accNum, input, storedUser);

                                System.out.println("Password successfully reset! Please login again.");
                            }
                        }
                    }
                }
            }
        }
    }

    public void performActionsPostLogin() {

        System.out.println("Login successful! What do you wish to do?\n");

        String selectedInput;

        do {
            System.out.println("1. Check Available Balance (BAL)\n" +
                    "2.Withdraw Amount (WIT)\n" +
                    "3.Deposit Amount (DEP)\n" +
                    "4.View Recent Transactions (HIS)\n" +
                    "5.Change Password (CHA)\n" +
                    "6. Exit (EX)");

            Scanner scanner = new Scanner(System.in);

            selectedInput = scanner.next();

            if(selectedInput.equals("BAL")) {
                checkAvailableBalance();
                selectedInput = "";
            }
            else if(selectedInput.equals("WIT")) {
//            withdrawAmount();
            }
            else if(selectedInput.equals("DEP")) {
//            depositAmount();
            }
            else if(selectedInput.equals("HIS")) {
                viewRecentTransactions();
            }
            else if(selectedInput.equals("CHA")) {
                changePassword();
            }
            else if(selectedInput.equals("EX")) {

            }
            else {
                System.out.println("Invalid input - please try again");
            }

        } while(!selectedInput.equals("EX"));
    }

    public void checkAvailableBalance() {
        HashMap fetchedRecord = atm.fetchFromUserData(loggedInUser);

        double balance = (double) fetchedRecord.get("AVAILABLEBALANCE");

        System.out.println("Available balance is : " + balance);
    }

    public void withdrawAmount(double amount) {

    }

    public void depositAmount(double amount) {

    }

    public void viewRecentTransactions() {

    }

    public void changePassword() {

    }
}
