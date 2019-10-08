package Question3;

public class DessertShop {

    static final double TAX_RATE = 6.5; //based on the sample code provided, assuming the tax value to be 6.5%
    static final String SHOP_NAME = "M & M Dessert Shop";
    
    public String cents2dollarsAndCentsMethod(int cents) {

        int dollar = 0;

        while (cents >= 100) {
            dollar = dollar*10 + cents/100;
            cents = cents%100;
        }

        double finalValue = dollar + (cents*0.01);

        return String.valueOf(finalValue);
    }
}
