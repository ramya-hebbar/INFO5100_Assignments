package Question3;

public abstract class DessertItem {
    protected String name;

    //Constructors
    public DessertItem() {

    }

    public DessertItem(String name) {
        this.name = name;
    }

    //Methods
    public final String getName() {
        return this.name;
    }

    public abstract int getCost();

    //for printing particulars

    public abstract String getInvoiceString();
}
