

import java.io.Serializable;


public class Food extends Item implements Serializable{
	private String [] nameArray = {"Apple", "Potato", "Ambrosia", "Orange", "Unsuspicious Meat"}; //Names of food
	private int [] weightArray = {5, 6, 10, 5, 15}; //Weights of food
	private int [] nourArray = {10, 25, 50, 15, 45}; //Nourishment value of food
	private int foodchoice = 1 + (int)(Math.random() * ((4 - 1) + 1)); //Chooses a food from the list
	private String name;
	private int nourish;
	private int weight;
	
	public Food(){
		name = nameArray[foodchoice];
		nourish = nourArray[foodchoice];
		weight = weightArray[foodchoice];
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
		return name;
	}
	
	/**
	 * Prints out everything in object
	 */
	
	public String toString(){
		return "Food: "+name+", WEIGHT: "+weight+", NOURISHMENT VALUE: "+nourish;
	}

}
