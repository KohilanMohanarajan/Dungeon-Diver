

import java.io.IOException;

public class Warlock extends Enemy{
	private int attack;
	private int defense;
	private int speed;
	
	public Warlock(){
		attack = 20;
		defense = 20;
		speed = 25;
	}
	
	/**
	 * Move to Attack Hero during fight sequence
	 * @param target Hero is designated as target
	 * @return Returns Attack Strength value
	 */

	public void warlockAttack(Hero target){
		int chance = 1 + (int)(Math.random() * ((3 - 1) + 1)); //Calculates chance of attack hitting
		int atval = 1 + (int)(Math.random() * ((17 - 14) + 1)); //Calculates value of attack
		if (chance == 2){
			target.heroDamage(atval); //Damages hero
		}
	}
	
	/**
	 * Move to Block Hero Attacks during fight sequence
	 */

	public void warlockBlock(){

	}

	
	/**
	 * Method to give Hero exp
	 * @param target Chooses Hero as target
	 */
	
	public void giveWExp(Hero target){
		int expg = 50 + (int)(Math.random() * ((100 - 50) + 1)); //Calculates amount of exp given
		target.getExp(expg);
	}

}
