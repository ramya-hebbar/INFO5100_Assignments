package Question1;

import java.util.HashMap;

public class ATM {
    private double availableAmountInMachine;
    private double transactionFee;
    private HashMap userData;

    public ATM(double availableAmountInMachine, double transactionFee) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;

        this.userData = new HashMap();
    }

    public void addToUserData(String bankAccountNumber, String password, User userInfo) {
        HashMap values = new HashMap();

        values.put("PASSWORD", password);
        values.put("USERINFO", userInfo);
        values.put("AVAILABLEBALANCE", 999.99);

        this.userData.put(bankAccountNumber, values);
    }

    public HashMap fetchFromUserData(String bankAccountNumber) {
        HashMap recordToReturn = (HashMap) this.userData.get(bankAccountNumber);
        return recordToReturn;
    }
}
