//HW6
//Checkout class

//Name: Nathan Tyson

//This class maintains a list of sweets and prints them out with their total cost,
//it is the class that utilizes all of the "return cost" methods and adds them up
public class Checkout{
	public static int numberOfItems = 0;
	private Sweet[] itemArray;

	public Checkout(){
		this.itemArray = new Sweet[100]; //establish array
	}

	public void enterItem(Sweet newItem){
		itemArray[numberOfItems] = newItem; //maintains added items on list
		numberOfItems++; 
	}

	public void clear(){
		itemArray = new Sweet[100]; //clears the item list
		numberOfItems = 0;
	}

	public int numberOfItems(){
		return numberOfItems; //returns number of items on list
	}

	public int totalCost(){ // no tax yet
		int cost = 0;
		for (int i = 0; i < numberOfItems; i++){
			cost += itemArray[i].getCost();   //for loop to add up total cost
		}
		return cost;
	}

	public int totalTax(){
		return (int)Math.round(totalCost() * SweetShop.TAX_RATE /100); //gets tax of total cost
	}

	public java.lang.String toString(){
		String s = "";
		//column width formatting to make it ~pretty~
		String leftColumn = "%-" + SweetShop.MAX_ITEM_NAME_SIZE + "s";
		String rightColumn = "%" + SweetShop.COST_WIDTH + "s";
		int recieptWidth = SweetShop.MAX_ITEM_NAME_SIZE + SweetShop.COST_WIDTH;

		//store name underlined by pretty dashes
		String storeName = SweetShop.STORE_NAME;
		String dashes = "";
		//create string of dashes equal to length of store name
		for(int i = 0; i < storeName.length(); i++){
			dashes += "-";
		}
		//centering by using some padding
		String padding = "%" + (recieptWidth - storeName.length())/2 + "s";
		s += String.format(padding + "%s\n" + padding +"%s\n\n", "", storeName,"", dashes);
		
		//Item names and prices
		for (int i = 0; i < numberOfItems; i++){
			String itemName = itemArray[i].getName();
			String itemCost = SweetShop.toDollarsAndCents(itemArray[i].getCost());
			if (itemArray[i] instanceof Candy){
				double candyWeight = ((Candy)itemArray[i]).getWeight();
				String candyCost = SweetShop.toDollarsAndCents(((Candy)itemArray[i]).getPricePerLb());
				s += String.format("%,.2f lbs. @ %s /lb.\n", candyWeight, candyCost);
				//%,.2f is a double with 2 decimal places of precision
			}
			if (itemArray[i] instanceof Cookie){
				int numCookies = ((Cookie)itemArray[i]).getNumCookies();
				String cookieCost = SweetShop.toDollarsAndCents(((Cookie)itemArray[i]).getPricePerDozen());
				s += String.format("%d @ %s /dz.\n", numCookies, cookieCost);
			}
			if (itemArray[i] instanceof Sundae){
				String nameTopping = ((Sundae)itemArray[i]).getNameTopping();
				s += String.format("%s Sundae with\n", nameTopping);
			}
			s += String.format(leftColumn + rightColumn + "\n", itemName, itemCost); 
		}

		//Tax
		String tax = SweetShop.toDollarsAndCents(totalTax());
		s += String.format(leftColumn + rightColumn + "\n", "Tax", tax);

		//Total
		String total = SweetShop.toDollarsAndCents(totalTax() + totalCost());
		s += String.format(leftColumn + rightColumn + "\n", "Total Cost", total);
		
		return s;
	}
}