import java.io.*;

public class Enemy {
	private String [] nameArray = {"Noah","Liam", "Mason", "Jacob ", "William", "Ethan", "Michael", "Alexander", "James", "Daniel", "Emma", "Olivia", "Sophia", "Isabella", "Ava", "Mia", "Emily", "Abigail", "Madison", "Charlotte"}; 
	private int namechoice = 1 + (int)(Math.random() * ((19 - 1) + 1));
	private String name;
	private int HP = 50;
	
	public Enemy() {
		name = nameArray[namechoice];
	}
	
	/**
	 * Returns enemy health
	 * @return enemy health value
	 */
	
	public int getEnemHealth(){
		return HP;
	}
	
	/**
	 * Sets HP value
	 * @param HPval Value of HP
	 */
	
	public void setHP(int HPval){
		HP = HPval;
	}
	
	/**
	 * Gets enemy name
	 * @return Returns enemy name
	 */
	
	public String getName(){
		return name;
	}
	
	/**
	 * Method that causes the enemy damage
	 * @param heroDamage Strength value of Hero Attack
	 */
	
	public void enemDamage(int heroDamage){
		HP = HP- heroDamage;
		System.out.println("Enemy took "+heroDamage+" damage!");
	}
	
	

}
