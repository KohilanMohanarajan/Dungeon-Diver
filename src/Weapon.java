

import java.io.IOException;

public class Weapon extends Item{
	private String [] nameArray = {"Apple", "Potato", "Ambrosia", "Orange", "Unsuspicious Meat"}; //Name of weapon
	private int [] weightArray = {5, 6, 10, 5, 15}; //Weights of weapons
	private int [] damArray = {10, 25, 50, 15, 45}; //Damage values of weapons
	private int weapchoice = 1 + (int)(Math.random() * ((4 - 1) + 1)); //Chooses a weapon from the list
	private String name;
	private int damage;
	private int weight;
	
	public Weapon(){
		name = nameArray[weapchoice];
		damage = damArray[weapchoice];
		weight = weightArray[weapchoice];
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
		return "Weapon: "+name+", WEIGHT: "+weight+", DAMAGE VALUE: "+damage;
	}

}
