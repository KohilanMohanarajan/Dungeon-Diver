

import java.io.Serializable;
import java.util.Arrays;

public class Map implements Serializable{
	private int heroposx = 21; //Current hero X-position
	private int oldherox = 21; //Old hero X-position
	private int heroposy = 16; //Current hero Y-position
	private int oldheroy = 16; //Old hero Y-position
	
	private int bossposx = 20; //Current boss X-position
	private int oldbossx = 20; //Old boss X-position
	private int bossposy = 6; //Current boss Y-position
	private int oldbossy = 6; //Old boss Y-position
	
	private String[][] MapArray = {{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," ","X","X","X"}, 
			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," "," "," ","X","X"},
			{"X","X"," "," "," "," "," "," "," "," "," "," "," "," ","X","X"," "," "," ","X","X"},
			{"X","X"," "," ","X","X","X","X","|"," "," ","X","X"," ","X","X","X"," "," ","X","X"},
			{"X","X"," "," ","X","X","X","X","|"," "," ","X","X"," ","X","X","X"," "," ","X","X"},
			{"X","X"," "," ","X","X"," "," ","X","X"," ","X","X","X","X","X","X"," "," ","X","X"},
			{"X","X"," "," ","X","X"," "," ","X","X"," ","X","X","X","X","X","X"," "," ","X","X"},
			{"X","X"," "," ","X","X"," "," "," "," "," "," "," "," "," "," "," "," "," ","X","X"},
			{"X","X"," "," ","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},
			{"X","X"," "," ","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},
			{"X","X"," "," "," "," "," "," ","X","X"," "," ","X","X","X","X","X","X","X","X","X"},
			{"X","X","X","X","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},
			{"X","X","X","X","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"}
	};

	public Map(){

	}
	
	/**
	 * Method to choose Map Style
	 * @param mapchoose choice number
	 */

	public void getMap(int mapchoose){
		int mapno = mapchoose;
		if (mapno == 1){
			String [][] MapArray1 = {{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","|"," "," ","|","-","-","-","-","-","-","-","-","-","-","+"}, 
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","+","-","-","-","-","-","-","-","+","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","|"," "," "," "," "," "," "," ","|","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","|","X","+","-","-","-","-","+"," "," "," "," "," "," "," ","|","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","|","X","|"," "," "," "," "," "," "," "," "," "," "," "," ","|","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","|","X","|"," "," ","+","-","-","-","-","-","-","-","-","-","+","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","+","-","-","-","-","-","-","+"," "," ","|","X","|"," "," ","+","-","-","-","-","-","-","-","-","-","-","-","+"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","|"," "," "," "," "," "," "," "," "," ","|","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","|"," "," "," "," "," "," "," "," "," ","|","X","+","-","-","-","-","+"," "," "," ","+","-","-","-","-","-","-","-","-","+","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","+","-","-","-","-","-","-","-","-","-","+","X","X","X","X","X","X","|"," "," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"," "," "," ","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"},
					{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","H"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
					{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","|","-","-","-","|","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"}
			};
			MapArray = MapArray1;
		} else if (mapno == 2){
			heroposx = 30;
			oldherox = 30;
			heroposy = 17;
			oldheroy = 17;
			String [][] MapArray2 = {{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","|"," "," ","|","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","+","-","-","-","-","-","-","+"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," ","|","X","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","+","-","-","-","-","-","-","+","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","|"},
					{"|","X","X","+","-","-","-","-","-","-","-","-","+"," "," ","+","-","-","+","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","|"},
					{"|","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","|"},
					{"|","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","|"},
					{"|","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","|"},
					{"|","X","X","+","-","-","-","-","-","+"," "," ","+","-","-","-","-","-","+","X","X","X","X","X","+","-","-","-","-","+"," "," ","+","-","-","-","-","-","-","-","+","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," ","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","+","-","-","-","-","-","-","-","-","+"," "," ","+","-","-","-","-","-","-","-","-","-","-","+","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","+","-","-","-","-","-","-","-","-","-","-","+","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," "," "," "," "," "," "," "," "," "," "," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","+","-","-","-","-","-","-","-","-","-","-","+"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","|"},
					{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","|","H"," ","|","-","-","-","-","-","-","-","-","-","-","+"}
		};
			MapArray = MapArray2;
		} else if (mapno == 3){
			heroposx = 20;
			oldherox = 20;
			heroposy = 17;
			oldheroy = 17;
			String [][] MapArray3 = {{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","|","H"," ","|","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"}
		};
			MapArray = MapArray3;
		} else if (mapno == 4){
			heroposx = 20;
			oldherox = 20;
			heroposy = 17;
			oldheroy = 17;
			
			bossposx = 20;
			oldbossx = 20;
			bossposy = 6;
			oldbossy = 6;
			String [][] MapArray4 = {{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," "," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," "," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","\\"," "," ","/","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+","X","X","X","X","|"},
					{"|","X","X","X","X","|","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," ","B"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","|","@","@","@","@","@","@","@","@","@","@","@","@","@","@"," "," ","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","@","|","X","X","X","X","|"},
					{"|","X","X","X","X","+","-","-","-","-","-","-","-","-","-","-","-","-","-","-"," "," ","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"," "," ","|","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","|"},
					{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","|","H"," ","|","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"}
		};
			MapArray = MapArray4;
		}
		
		}
	
	/**
	 * Causes the Hero's position to change in accordance with the user's input
	 * @param input User's inputed String, W, A, S, or D
	 * @return Returns hero's coordinates as a 1-dimensional array
	 */

	public void heroMove(String input){
		String inmove = input;
		oldheroy = heroposy; //sets old hero y-position to current y-position
		oldherox = heroposx; //sets old hero x-position to current x-position
		//System.out.println("OLD:"+oldherox+" "+oldheroy);
			if (inmove.equals("W") ||inmove.equals("w")){
				if (MapArray[heroposy-1][heroposx].equals(" ")){ //Checks for collision
					heroposy--; //sets new hero y-position
					//System.out.println(MapArray[heroposy][heroposx]+"!");
					MapArray[heroposy][heroposx] = "H"; //Draws hero position
					MapArray[oldheroy][oldherox] = " "; //Replaces old hero position
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(heroposx+" "+heroposy);
			} else if(inmove.equals("S") ||inmove.equals("s")){
				if (MapArray[heroposy+1][heroposx].equals(" ")){
					heroposy++; //sets new hero y-position
					//System.out.println(MapArray[heroposy][heroposx]+"!");
					MapArray[heroposy][heroposx] = "H";
					MapArray[oldheroy][oldherox] = " ";
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(heroposx+" "+heroposy);
			} 
			
			if(inmove.equals("A") ||inmove.equals("a")){
				if (MapArray[heroposy][heroposx-1].equals(" ")){
					heroposx--; //sets new hero x-position
					//System.out.println(MapArray[heroposy][heroposx]+"!");
					MapArray[heroposy][heroposx] = "H";
					MapArray[oldheroy][oldherox] = " ";
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(heroposx+" "+heroposy);
			} else if(inmove.equals("D") ||inmove.equals("d")){
				if (MapArray[heroposy][heroposx+1].equals(" ")){
					heroposx++; //sets new hero x-position
					//System.out.println(MapArray[heroposy][heroposx]+"!");
					MapArray[heroposy][heroposx] = "H";
					MapArray[oldheroy][oldherox] = " ";
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(heroposx+" "+heroposy);
			}
	}
	
	/**
	 * Gets hero Y position
	 * @return Returns hero y position value
	 */
	public int getPosy(){
		return heroposy;
	}
	
	/**
	 * Method to obtain Hero Position Values
	 */

	public void getHeroPos(){
		System.out.println(heroposx+" "+heroposy);
	}
	
	/**
	 * Method to Move Boss Object
	 */
	
	public void bossMove(String input){
		String inmove = input;
		oldbossy = bossposy; //sets old boss y-position to current y-position
		oldbossx = bossposx; //sets old boss x-position to current x-position
		//System.out.println("OLD:"+oldbossx+" "+oldbossy);
			if (inmove.equals("w")){
				if (MapArray[bossposy-1][bossposx].equals(" ")){ //Checks for collision
					bossposy--; //sets new boss y-position
					//System.out.println(MapArray[bossposy][bossposx]+"?");
					MapArray[bossposy][bossposx] = "B"; //Draws boss position
					MapArray[oldbossy][oldbossx] = " "; //Replaces old boss position
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(bossposx+" "+bossposy);
			} else if(inmove.equals("s")){
				if (MapArray[bossposy+1][bossposx].equals(" ")){
					bossposy++; //sets new boss y-position
					//System.out.println(MapArray[bossposy][bossposx]+"?");
					MapArray[bossposy][bossposx] = "B";
					MapArray[oldbossy][oldbossx] = " ";
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(bossposx+" "+bossposy);
			} 
			
			if(inmove.equals("a")){
				if (MapArray[bossposy][bossposx-1].equals(" ")){
					bossposx--; //sets new hero x-position
					//System.out.println(MapArray[bossposy][bossposx]+"?");
					MapArray[bossposy][bossposx] = "B";
					MapArray[oldbossy][oldbossx] = " ";
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(bossposx+" "+bossposy);
			} else if(inmove.equals("d")){
				if (MapArray[bossposy][bossposx+1].equals(" ")){
					bossposx++; //sets new hero x-position
					//System.out.println(MapArray[bossposy][bossposx]+"?");
					MapArray[bossposy][bossposx] = "B";
					MapArray[oldbossy][oldbossx] = " ";
				} else{
					System.out.println("Invalid entry, try again.");
				} 
				//System.out.println(bossposx+" "+bossposy);
			}
	}
	
	/**
	 * Method to Draw Map
	 */

	public void drawMap(){
		for(int j = 0; j < MapArray.length; j++){
			for(int i = 0; i < MapArray[0].length; i++){
				System.out.print(MapArray[j][i]);
			}
			System.out.println();
		}
	}

}
