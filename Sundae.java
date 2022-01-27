//HW6
//Sundae subclass

//Name: Nathan Tyson

//The Sundae class extends IceCream, and adds on the price of any added toppings to ice cream
public class Sundae extends IceCream{
	private String nameTopping;
	private int costTopping;

	
	public Sundae(String nameIceCream, int costIcecream, String nameTopping, int costTopping){
		super(nameIceCream, costIcecream); //gets name and cost of ice cream
		this.nameTopping = nameTopping; //gets name of topping
		this.costTopping = costTopping; //gets cost of topping
	}

	//this method gets the cost of ice cream and returns it with the added topping cost
	public int getCost(){
		return super.getCost() + costTopping;
	}

	//this method returns name of the topping used
	public String getNameTopping(){
		return nameTopping;
	}
	
}
 