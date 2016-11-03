import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable{
	private int limit;
	private int limach = 0;
	private int weiach = 0;
	private int weightlimit;
	ArrayList<Item> inventory = new ArrayList<Item>();  //Creates arraylist to contain items


	public Inventory(int sizelim, int weightlim){
		limit = sizelim;
		weightlimit = weightlim;
	}

	/**
	 * Adds item to inventory
	 */

	public void addItem(){
		if (limach <= limit && weiach <= weightlimit){
			int foodoritem = 1 + (int)(Math.random() * ((2 - 1) + 1)); //Chooses between Food or Item object
			if (foodoritem == 1){
				inventory.add(new Item()); //Adds item
			} else if (foodoritem == 2){
				inventory.add(new Food()); //Adds food
			}
			limach++; //Adds to size limit
			weiach = weiach + inventory.get(limach-1).getWeight();	//Adds to weight limit
		} else if (limach >= limit || weiach >= weightlimit){
			System.out.println("Inventory full! Item could not be added");
		}
	}

	/**
	 * Prints out inventory 
	 */

	public String printInventorySize(){
		//int itno = 1;
		return "SIZE LIMIT: "+limach+"/"+limit+"\n"+"WEIGHT LIMIT: "+weiach+"/"+weightlimit;
		//for (Item i: inventory){
		//	System.out.println(itno+")"+i);
		//	itno++;
		//}
	}

	public String printInventory(int itno){
		String invenreturn = " ";
		for (Item i: inventory){
			invenreturn = invenreturn+itno+")"+i+"\n";
			itno++;
		}
		return invenreturn;

		/*System.out.println(itno);
		if (itno == 1){
			return itno+")"+inventory.get(itno);
		} else if (itno == 0){
			return itno+")"+inventory.get(0);
		} else{
			return inventory.get(itno)+"/n"+printInventory(itno-1);
		}*/
		//return "List end";
	}
	/**
	 * Drops item
	 * @param itemnum Item index
	 */

	public void dropItem(int itemnum){
		limach--; //Decreases size limit
		weiach = weiach - inventory.get(itemnum-1).getWeight(); //Decreases weight limit
		System.out.println(inventory.get(itemnum-1)+" has been removed!");
		inventory.remove(itemnum-1); //Removes item from Arraylist
	}

	/**
	 * Uses item
	 * @param itemnum Item index
	 * @param target Chooses hero as target
	 */

	public void useItem(int itemnum, Hero target){
		String effectchoose;
		effectchoose = inventory.get(itemnum-1).getTitle();
		if (effectchoose.equals("Potion")){
			target.heroHeal(20);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);	
		} else if (effectchoose.equals("Big Potion")){
			target.heroHeal(60);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Stick")){
			System.out.println("Stick was used!  Sadly, it had no effect, as this hasn't been implemented yet.  This makes you sad.");
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Ye Olde stick of the ancients")){
			System.out.println("Ye Olde stick of the ancients was used!  Despite its awesome name, it had no effect.  This makes you sad.");
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Pyrite Ring")){
			System.out.println("Pyrite Ring was used!  As it is made of Pyrite, it's basically useless.  Damn those Ringmakers.  This makes you sad.");
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Apple")){
			target.heroEat(10);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Potato")){
			target.heroEat(25);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Ambrosia")){
			target.heroEat(50);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Orange")){
			target.heroEat(15);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		} else if (effectchoose.equals("Unsuspicious Meat")){
			target.heroEat(45);
			limach--;
			weiach = weiach - inventory.get(itemnum-1).getWeight();
			inventory.remove(itemnum-1);
		}
	}

}
