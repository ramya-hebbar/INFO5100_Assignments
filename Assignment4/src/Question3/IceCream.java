package Question3;

public class IceCream extends DessertItem {

    private int finalCostAsInteger;
    private double finalCost;

    //Constructors

    public IceCream(String name, int finalCost) {
        this.name = name;
        this.finalCostAsInteger = finalCost;
    }

    //Methods

    @Override
    public int getCost() {
        DessertShop dShop = new DessertShop();

        String valueAsStr = dShop.cents2dollarsAndCentsMethod(finalCostAsInteger);
        this.finalCost = Double.parseDouble(valueAsStr);

        double costInCents = this.finalCost * 100;

        return (int)Math.round(costInCents);
    }

    @Override
    public String getInvoiceString() {
        String invoiceStr = new String(this.name+"\t\t\t\t\t\t");
        invoiceStr = invoiceStr + String.format("%.2f", this.finalCost);

        return invoiceStr;
    }
}
