//HW 6 
//Cookie subclass

//Name: Nathan Tyson

//The Cookie subclass extends Sweet class, it calculates the cost of a cookie by multiplying
//the number of cookies by the pricePerDozen, then rounding the number.

public class Cookie extends Sweet{
	private int numCookies;
	private int pricePerDozen;

	public Cookie(String name, int numCookies, int pricePerDozen){
		super(name); //gets name of the cookie
		this.numCookies = numCookies; //gets the amount of cookies
		this.pricePerDozen = pricePerDozen; //gets the price per dozen cookies
	}

	//getCost() calculates the cost, then returns it
	public int getCost(){
		int cost = (int)Math.round(numCookies * pricePerDozen / 12);
		return cost;
	}

	//numCookies attains the amount of cookies, used in the getCost calculation
	public int getNumCookies(){
		return numCookies;
	}

	//getPricePerDozen attains the price per dozen cookies, used in the getCost calculation
	public int getPricePerDozen(){
		return pricePerDozen;
	}
	
	
	//I put this method here to stop the "public Class Cookie is not abstract" error
	//which was coming from Sweet class toString() method.
	//I did this to override the abstract class
	public String toString(){
	   return name;}
}