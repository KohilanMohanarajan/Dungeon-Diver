import java.io.Serializable;

public class Hero implements Serializable{
	private int HP;
	private String name;
	private int hunger;
	private int exp;
	private int attack;
	private int defense;
	private int speed;

	public Hero(String iname){
		name = iname;
		HP = 100;
		hunger = 100;
	}

	/**
	 * Sets Attack value
	 * @param Attval Value of Attack
	 */

	public void setAtt(int Attval){
		attack = Attval;
	}

	/**
	 * Sets Defense value
	 * @param Defval Defense value of Attack
	 */

	public void setDef(int Defval){
		defense = Defval;
	}

	/**
	 * Sets Speed value
	 * @param Spdval Speed Value of Speed 
	 */

	public void setSpeed(int Spdval){
		speed = Spdval;
	}

	/**
	 * Method to display Health and Hunger value from Hero Class
	 */

	public void dispHealth(){
		System.out.println("HP:"+HP+"  Hunger:"+hunger);
	}

	/**
	 * Method to increase Hunger
	 */

	public void incHunger(){
		if (hunger <= 15){
			System.out.println("__________________________");
			System.out.println("//////////////////////////");
			System.out.println("WARNING!  HUNGER LEVEL LOW");
			System.out.println("//////////////////////////");
			System.out.println("__________________________");
		}
		System.out.println();
		int hungchance = 1 + (int)(Math.random() * ((3 - 1) + 1));

		if(hungchance == 2){
			int hunglev = 1 + (int)(Math.random() * ((3 - 1) + 1));
			hunger = hunger - hunglev;
		}
	}

	/**
	 * Method to get hero health 
	 * @return Returns hero health value
	 */
	public int getHealth(){
		return HP;
	}

	/**
	 * Method to get hero hunger 
	 * @return Returns hero health value
	 */
	public int getHunger(){
		return hunger;
	}

	public void setHunger(int hunset){
		hunger = hunset;
	}

	/**
	 * Method for hero attack
	 * @param target Chooses hero attack target
	 * @param enetype Chooses subclass of enemy
	 */
	public void heroAttack(Enemy target, int enetype){
		int chance = 1 + (int)(Math.random() * ((2 - 1) + 1)); //Calculates chance of attack hitting
		int atval;
		if (attack == 20){
			atval = 3 + (int)(Math.random() * ((7 - 3) + 1)); //Calculates value of attack
		} else if (attack == 30){
			atval = 5 + (int)(Math.random() * ((10 - 5) + 1)); //Calculates value of attack
		} else{
			atval = 7 + (int)(Math.random() * ((13 - 7) + 1)); //Calculates value of attack
		}
		if (chance == 2){
			target.enemDamage(atval); //Damages enemy
		} else{
			System.out.println("Attack Missed!");
		}
	}

	/**
	 * Method for hero to take damage
	 * @param eneDamage Value of damage
	 */

	public void heroDamage(int eneDamage){
		HP = HP- eneDamage;
		System.out.println("Hero "+name+" took "+eneDamage+" damage!");
	}

	/**
	 * Method to heal hero
	 * @param healval Value of healing factor
	 */

	public void heroHeal(int healval){
		HP = HP + healval;
		if (HP > 100){
			HP = 100;
		}
		System.out.println("Hero "+name+" regained "+healval+" HP!");
	}

	/**
	 * Method for hero to eat
	 * @param nourval Nourishment value of food
	 */

	public void heroEat(int nourval){
		hunger = hunger + nourval;
		if (hunger > 100){
			hunger = 100;
		}
		System.out.println("Hero "+name+" replenished "+nourval+" Hunger!");
	}

	/**
	 * Method to get exp
	 * @param enegive EXP value
	 */

	public void getExp(int enegive){
		exp = exp + enegive;
	}

}
