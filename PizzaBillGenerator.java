package Projects;

import java.util.Scanner;

class Pizza{
    private int price;
    private Boolean veg;              // true = veg , false = non-veg
    private int extraCheesePrice = 100;
    private int extraToppingPrice = 150;
    private int backPackPrice = 20;
    private int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingAdded = false;
    private boolean isOptedForTakeAway = false;

    public Pizza(Boolean veg){           // Constructor
        this.veg = veg;

        if(this.veg){
            this.price = 300;             // veg
        }
        else {
            this.price = 400;             // non-veg
        }
        basePizzaPrice = this.price;           // give price according to veg or non-veg
    }

    public void addExtraCheese(){
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;
    }

    public void addExtraToppings(){
        isExtraToppingAdded = true;
        this.price += extraToppingPrice;
    }

    public void takeAway(){                                   // for bagPack
        isOptedForTakeAway = true;
        this.price += backPackPrice;
    }

    public void getBill(){
        String bill = "";
        System.out.println("Pizza = " + basePizzaPrice);

        if(isExtraCheeseAdded){
            bill += "Extra Cheese Added = " + extraCheesePrice + "\n";
        }
        if(isExtraToppingAdded){
            bill += "Extra Topping Added = " + extraToppingPrice + "\n";
        }
        if(isOptedForTakeAway){
            bill += "BackPack Added = " + backPackPrice + "\n";
        }

        bill +=  "Bill = " + this.price + "\n";
        System.out.println(bill);

    }

}

class DeluxPizza extends Pizza{
    public DeluxPizza(Boolean veg){
        super(veg);
        super.addExtraCheese();           // super used to call methods of parent class
        super.addExtraToppings();
    }
}

public class PizzaBillGenerator {
    public static void main(String[] args) {
        Pizza basePizza = new Pizza(true);       // non- veg pizza passing in constructor
        basePizza.addExtraCheese();
        basePizza.addExtraToppings();
//        basePizza.takeAway();
        basePizza.getBill();

        DeluxPizza dp = new DeluxPizza(true);
        dp.getBill();
    }
}
