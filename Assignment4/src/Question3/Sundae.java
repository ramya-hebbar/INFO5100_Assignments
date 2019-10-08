package Question3;

public class Sundae extends IceCream {
    private String nameOfTopping;

    private int costOfToppingAsInteger;

    private double costOfTopping;

    private double totalCost;

    public Sundae(String nameOfIceCream, int costOfIceCream, String nameOfTopping, int costOfTopping) {
        super(nameOfIceCream, costOfIceCream);

        this.nameOfTopping = nameOfTopping;
        this.costOfToppingAsInteger = costOfTopping;
    }

    //Methods

    @Override
    public int getCost() {

        DessertShop dShop = new DessertShop();

        String valueAsStr = dShop.cents2dollarsAndCentsMethod(costOfToppingAsInteger);
        this.costOfTopping = Double.parseDouble(valueAsStr);

        int costOfIceCream = super.getCost();

        this.totalCost = (costOfIceCream * 0.01) + this.costOfTopping;

        double costInCents = this.totalCost * 100;

        return (int) Math.round(costInCents);

    }

    @Override
    public String getInvoiceString() {
        String invoiceStr = new String(this.nameOfTopping + " Sundae with " + super.name + "\t\t\t\t\t\t");
        invoiceStr = invoiceStr + String.format("%.2f", this.totalCost);

        return invoiceStr;
    }
}
