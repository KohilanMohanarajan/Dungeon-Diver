import java.io.Serializable;

public class Item implements Serializable {
	private String [] titleArray = {"Potion", "Big Potion", "Stick", "Ye Olde stick of the ancients", "Pyrite Ring"}; //List of items
	private int [] weightArray = {10, 25, 5, 5, 2}; //List of item weights
	private int itemchoice = 1 + (int)(Math.random() * ((4 - 1) + 1)); //Chooses a random item from list
	private String title; 
	private int weight;
	
	
	public Item(){
		title = titleArray[itemchoice];
		weight = weightArray[itemchoice];
		System.out.println("You got: "+title+"!  Its weight is: "+weight);
	}
	
	/**
	 * Gets weight value
	 * @return Returns weight value
	 */
	public int getWeight(){
		return weight;
	}
	
	/**
	 * Gets name value
	 * @return Returns name
	 */
	
	public String getTitle(){
		return title;
	}
	
	/**
	 * Prints out everything in object
	 */
	
	public String toString(){
		return "ITEM: "+title+", WEIGHT: "+weight;
	}

}
