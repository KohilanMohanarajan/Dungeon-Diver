

import java.io.IOException;

public class Grunt extends Enemy{
	
	public Grunt(int HPval){

	}

	/**
	 * Move to Attack Hero during fight sequence
	 * @param target Hero is designated as target
	 * @return Returns Attack Strength value
	 */

	public void gruntAttack(Hero target){
		int chance = 1 + (int)(Math.random() * ((4 - 1) + 1)); //Calculates chance of attack hitting
		int atval = 1 + (int)(Math.random() * ((12 - 5) + 1)); //Calculates value of attack
		if (chance == 2){
			target.heroDamage(atval); //Damages hero
		}
	}
	
	/**
	 * Method to give Hero exp
	 * @param target Chooses Hero as target
	 * @return Returns EXP value
	 */
	
	public void giveGExp(Hero target){
		int expg = 20 + (int)(Math.random() * ((35 - 20) + 1)); //Calculates amount of exp given
		target.getExp(expg);
	}

}
