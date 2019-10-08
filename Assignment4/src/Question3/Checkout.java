package Question3;

import java.util.Objects;
import java.util.Vector;

public class Checkout {

    private Vector<DessertItem> items;

    private int totalCost;

    private int totalTax;

    //Constructor

    public Checkout() {
        items = new Vector<DessertItem>();
    }

    //Methods

    public int numberOfItems() {
        return items.size();
    }

    public void enterItem(DessertItem item) {
        items.add(item);
    }

    public void clear() {
        items.clear();
    }

    public int getNumberOfItems() {
        return 0;
    }

    public int totalCost() {

        int finalTotalCost = 0;

        for (DessertItem di: items) {
            finalTotalCost += di.getCost();
        }

        this.totalCost = finalTotalCost;

        return finalTotalCost;
    }

    public int totalTax() {

        double finalTax = (totalCost() * DessertShop.TAX_RATE)/100;

        this.totalTax = (int)Math.round(finalTax);

        return this.totalTax;
    }

    public String toString() {

        System.out.println("\t\t");
        System.out.println(DessertShop.SHOP_NAME);
        System.out.println("--------------------");

        String outputStr = new String();

        for (DessertItem di: items) {
            outputStr = outputStr + di.getInvoiceString() + "\n";
        }

        outputStr = outputStr + "\n" + "Tax\t\t\t\t\t\t" + (this.totalTax*0.01) + "\n";
        outputStr = outputStr + "Total Cost\t\t\t\t\t\t" + (this.totalCost*0.01 + this.totalTax*0.01) + "\n";

        return outputStr;
    }
}
