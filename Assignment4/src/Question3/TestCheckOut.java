package Question3;

public class TestCheckOut {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

        System.out.println("\nNumber of items: " + checkout.numberOfItems());

        int totalCost = checkout.totalCost();
        int totalTax = checkout.totalTax();

        System.out.println("\nTotal cost: " + totalCost);
        System.out.println("\nTotal tax: " + totalTax);
        System.out.println("\nCost + Tax: " + (totalCost + totalTax) + "\n");
        System.out.println(checkout);

        checkout.clear();

        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));

        System.out.println("\nNumber of items: " + checkout.numberOfItems());

        totalCost = checkout.totalCost();
        totalTax = checkout.totalTax();

        System.out.println("\nTotal cost: " + totalCost);
        System.out.println("\nTotal tax: " + totalTax);
        System.out.println("\nCost + Tax: " + (totalCost + totalTax) + "\n");
        System.out.println(checkout);
    }
}
