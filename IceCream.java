//HW6
//IceCream subclass

//Name: Nathan Tyson

//The IceCream class extends Sweet class, it simply returns the cost of a certain icecream
public class IceCream extends Sweet{
	private int cost;

	public IceCream(String name, int cost){
		super(name); //gets name of Ice Cream
		this.cost = cost; //gets cost
	}

	//this method returns cost
	public int getCost(){
		return cost;
	}
	
	//once again, this method is here because it is the only way I could
	//stop an error message of "cannot extend Sweet class"
	public String toString(){
	   return name;}
}
