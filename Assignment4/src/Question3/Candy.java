package Question3;

public class Candy extends DessertItem {

    private double weight;
    private int pricePerPoundAsInteger;
    private double pricePerPound;
    private double finalCost;

    //Constructors

    public Candy(String name, double weight, int pricePerPound) {
        this.name = name;
        this.weight = weight;
        this.pricePerPoundAsInteger = pricePerPound;
    }

    //Methods

    @Override
    public int getCost() {

        DessertShop dShop = new DessertShop();

        String valueAsStr = dShop.cents2dollarsAndCentsMethod(pricePerPoundAsInteger);
        this.pricePerPound = Double.parseDouble(valueAsStr);

        this.finalCost = this.weight * this.pricePerPound;
        double costInCents = this.finalCost * 100;

        return (int)Math.round(costInCents);
    }

    @Override
    public String getInvoiceString() {
        String invoiceStr = new String(this.weight+" lbs. @ "+this.pricePerPound+"/lb.\n"+this.name
                +"\t\t\t\t\t\t");
        invoiceStr = invoiceStr + String.format("%.2f", this.finalCost);

        return invoiceStr;
    }
}
