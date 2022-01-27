// CSCI 221, Fall 2020, HW 6
// 
// Sweet.java - Sweet items abstract superclass
// Adapted from S. Balik

public abstract class Sweet {
  
  protected String name;
  
/**
 * Null constructor for Sweet item class
 */
  public Sweet() {
    this("");
  }
/**
 * Initializes data
 */   
  public Sweet(String name) {
    if (name.length() <= SweetShop.MAX_ITEM_NAME_SIZE)
      this.name = padName(name); // Use all 25 spaces, to 
    else                         // make printout look nice
      this.name = name.substring(0,SweetShop.MAX_ITEM_NAME_SIZE);
  }
/**
 * Returns name of item
 * @return name of item
 */  
  public final String getName() {
    return name;
  }
  
  private String padName(String n){
      
      if (n.length() < SweetShop.MAX_ITEM_NAME_SIZE)
         for (int i = n.length(); i < SweetShop.MAX_ITEM_NAME_SIZE; i++)
             n += " "; // add a blank
      return n;
  }
  
  /**
   * Returns cost of item
   * @return cost of item
   */  
  public abstract int getCost();
  /**
   * Generates "printable" String
   */
  public abstract String toString();

}
   
  
  
   
   
