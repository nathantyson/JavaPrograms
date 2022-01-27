//HW6 
//Candy subclass

//Name: Nathan Tyson

//the Candy subclass extends Sweet class, it calculates the cost of a candy by multiplying
//the weight of candy by the pricePerPound of candy, then rounding the number.
	

public class Candy extends Sweet{
	private double weight;
	private int pricePerLb;
	
	public Candy(String name, double weight, int pricePerLb){
		super(name); //gets name of Candy
		this.weight = weight; //gets weight of Candy
		this.pricePerLb = pricePerLb; //gets the price per pound of candy
	}
	
	//method for attaining cost from a rounded (price per pound x weight of candy)
	//then returns the cost
	public int getCost(){
		int cost = (int)Math.round(pricePerLb * weight);
		return cost;
	}

	//method for attaining weight of candy and returning it
	public double getWeight(){
		return weight;
	}

	//method for attaining price per pound of candy, which is used in GetCost()
	//then returns the price per pound
	public int getPricePerLb(){
		return pricePerLb;
	}
	
	//I put this method here to stop the "public Class Candy is not abstract" error
	//which was coming from Sweet class toString() method.
	//I did this to override the abstract class
	public String toString(){
	   return name;}


}
