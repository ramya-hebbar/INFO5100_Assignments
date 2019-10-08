package Question3;

public class Cookie extends DessertItem {

    private int number;
    private int pricePerDozenAsInteger;
    private double pricePerDozen;
    private double finalCost;

    //Constructors

    public Cookie(String name, int noOfCookies, int pricePerDozen) {
        this.name = name;
        this.number = noOfCookies;
        this.pricePerDozenAsInteger = pricePerDozen;
    }

    //Methods

    @Override
    public int getCost() {
        DessertShop dShop = new DessertShop();

        String valueAsStr = dShop.cents2dollarsAndCentsMethod(pricePerDozenAsInteger);
        this.pricePerDozen = Double.parseDouble(valueAsStr);

        double pricePerCookie = this.pricePerDozen/12;

        this.finalCost = this.number * pricePerCookie;
        double costInCents = this.finalCost * 100;

        return (int)Math.round(costInCents);
    }

    @Override
    public String getInvoiceString() {
        String invoiceStr = new String(this.number+" @ "+this.pricePerDozen+"/dz.\n"+this.name+"\t\t\t\t\t\t");
        invoiceStr = invoiceStr + String.format("%.2f", this.finalCost);

        return invoiceStr;
    }
}
