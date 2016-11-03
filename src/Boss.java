import java.io.Serializable;

public class Boss implements Serializable{
	private String name;
	private int HP;
	
	public Boss(){
		name = "Maximus Fatrippius Vaperius the LXIXth, 7th BoyArtsy of the Andy Salad Brotherhood of Fat Rippers";
		HP = 100;
	}
	
	/**
	 * Method to display Boss' Health
	 */

	public void dispBossHealth(){
		System.out.println("Boss HP is:"+HP);
	}
	
	/**
	 * Method to get Boss Health value
	 * @return Returns Boss' Health value
	 */
	
	public int getBossHealth(){
		return HP;
	}
	
	/**
	 * Method to Attack Hero
	 * @param target Targets Hero with Attack
	 */

	public void bossAttack(Hero target){
		int chance = 1 + (int)(Math.random() * ((3 - 1) + 1)); //Calculates chance of attack hitting
		int atval = 15 + (int)(Math.random() * ((22 - 15) + 1)); //Calculates value of attack
		if (chance == 2){
			target.heroDamage(atval); //Damages hero
		}
	}
	
	/**
	 * Method to Block Hero Attacks
	 */

	public void bossBlock(){

	}
	
	/**
	 * Method for Boss to take damage
	 * @param heroDamage value of damage received from Hero
	 */

	public void bossDamage(int heroDamage){
		HP = HP- heroDamage;
		System.out.println(name+" took "+heroDamage+" damage!");
	}
	




}
