// CSCI 221, Fall 2020, HW 6
// TestCheckout.java - main method to test Checkout class
//                         and Sweet hierarchy
// Adapted from S. Balik

public class TestCheckout {

  public static void main(String[] args) {
  
    Checkout checkout = new Checkout();
    
    checkout.enterItem(new Candy("Werthers Candies", 3.25, 399));
    checkout.enterItem(new IceCream("Coffee Dream Ice Cream",210));
    checkout.enterItem(new Sundae("Nanner Split",160, "Hot Fudge", 40));
    checkout.enterItem(new Cookie("Peanut Butter Cookies", 6, 299));
    
    System.out.println("\nNumber of items: " + checkout.numberOfItems());
    System.out.println("Total cost: " + SweetShop.toDollarsAndCents(checkout.totalCost()));
    System.out.println("Total tax: " + SweetShop.toDollarsAndCents(checkout.totalTax()));
    System.out.println("Cost + Tax: " + SweetShop.toDollarsAndCents(checkout.totalCost() + checkout.totalTax())+"\n");
    System.out.println(checkout);
    
    checkout.clear();
    
    checkout.enterItem(new IceCream("Cookies and Cream Ice Cream",145));
    checkout.enterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));
    checkout.enterItem(new Candy("Nutter Butters", 1.33, 89));
    checkout.enterItem(new Cookie("Choco Chip Cookies", 4, 399));
    checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
    checkout.enterItem(new Candy("KitKats",3.0, 109));
    
    System.out.println("\nNumber of items: " + checkout.numberOfItems());
    System.out.println("Total cost: " + SweetShop.toDollarsAndCents(checkout.totalCost()));
    System.out.println("Total tax: " + SweetShop.toDollarsAndCents(checkout.totalTax()));
    System.out.println("Cost + Tax: " + SweetShop.toDollarsAndCents(checkout.totalCost() + checkout.totalTax())+"\n");
    System.out.println(checkout);
  }
}
