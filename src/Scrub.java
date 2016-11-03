

import java.io.IOException;

public class Scrub extends Enemy{
	
	public Scrub(){
		
	}
	
	/**
	 * Move to Attack Hero during fight sequence
	 * @param target Hero is designated as target
	 * @return Returns Attack Strength value
	 */
	
	public void scrubAttack(Hero target){
		int chance = 1 + (int)(Math.random() * ((5 - 1) + 1)); //Calculates chance of attack hitting
		int atval = 1 + (int)(Math.random() * ((5 - 1) + 1)); //Calculates value of attack
		if (chance == 2){
			target.heroDamage(atval); //Damages hero
		}
	}

	
	/**
	 * Method to give Hero exp
	 * @param target Chooses Hero as target
	 * @return Returns EXP value
	 */
	
	public void giveSExp(Hero target){
		int expg = 10 + (int)(Math.random() * ((20 - 10) + 1)); //Calculates amount of exp given
		target.getExp(expg);
	}

}
