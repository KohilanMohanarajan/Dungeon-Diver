import processing.core.PApplet;import processing.core.PFont;import processing.core.PImage;import java.io.FileNotFoundException;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.IOException;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.io.Serializable;import java.util.Scanner;public class Main extends PApplet {	String heroname; //hero's name	String nameInput = new String();//Name Input String	String itemdisp = new String();//Displays item name	String userinput; //User string input during init sequence	String dirinp; //User string input during game	String bossinp = "i"; //Direction value of Boss	String herochoose; //Chooses hero type	String notifstring; //Text for notification	Scanner initscan = new Scanner(System.in); //Scanner for init sequence	Scanner intscan = new Scanner(System.in); //Inventory int-based scanner	Scanner namescan = new Scanner(System.in); //Scanner for name	Scanner Strscan = new Scanner(System.in); //String scanner	int enemencount = 20; //Determines whether an enemy encounter occurs or not	int titlechoose = 0; //Chooses screens	int mapchoose = 1; //Chooses map	int invenchoice; //Chooses item in list	int itemencount = 5; //Determines whether an item is picked up or not	int itenmin = 1; //Item encounter chance minimum	int itenmax = 3; //Item encounter chance maximum	int encmin = 1; //Enemy encounter chance minimum	int encmax = 5; //Enemy encounter chance maximum	int enemin = 1; //Enemy type choice minimum	int enemax = 3; //Enemy type choice maximum	int enechoose; //Chooses the type of enemy	int bossinpchoose; //Chooses which direction the boss goes	int heroposx = 335; //Hero's x position on screen	int heroposy = 330; //Hero's y position on screen	int heromapx = 11; //Hero's x position on map	int heromapy = 11 ; //Hero's y position on map	int notiftimer = 60; //Timer for notifications	int msgtimer = 300; //Timer for the hidden message	int lvltimer = 720; //Timer for level switches	int movetimer = 600; //Timer for before the movement on titlechoose 11 begins	int expltimer = 60; //Timer for explosion	int mapmove = 0; //Map movement	int backmove = 0; //Background movement	int tempbackmove;// Temporary background movement	int bossx = 320; //Boss' x position	int bossy = 108; //Boss' y position	int BossHP = 10000; //Boss' HP	int beamy = 108; //Position of the beam	double mx; //Calculates ship position	boolean gridtoggle = false; //Toggles grid	boolean startonoff = false; //Determines if the player exits the initsequence	boolean invencheck = false; //Initializes/Finishes inventory loop	boolean itempu = false; //Checks items	boolean useask = false; //Use Item toggle	boolean dropask = false;//Drop Item toggle	boolean notifyes= false; //Notification toggle	boolean treastrig = false; //Treasure toggle	boolean cluetrig = false; //Clue trigger	boolean keycheck = false; //Checks if hero has key	boolean bossmovey = true; //Changes boss y movement	boolean bossmovex = true; //Changes boss x movement	static boolean rogueyes = false; //checks if hero is a rogue	static boolean mageyes = false; //checks if hero is a mage	static boolean thiefyes = false; //checks if hero is a thief	PFont f; //Comic sans font	PFont f2; //Arial(?) font	PImage forest;	PImage forest2;	PImage forest3;	PImage forest4;	PImage textbox;	PImage textboxhv;	PImage namebox;	PImage gametitle;	PImage play;	PImage playhv;	PImage Map1;	PImage Map2;	PImage Map3;	PImage Map4a;	PImage Map4broken;	PImage Map4b;	PImage Rogue;	PImage Mage;	PImage Thief;	PImage mapgrid;	PImage Instructions;	PImage Gamsel;	PImage Namsel;	PImage Clasel;	PImage Pause;	PImage Run;	PImage HUD;	PImage Treasure;	PImage veil;	PImage invenback;	PImage Scrub;	PImage Grunt;	PImage Warlock;	PImage bscreen;	PImage HellYeah;	PImage NMD;	PImage BattHUD;	PImage MSG;	PImage Clue;	PImage spacback;	PImage Boss;	PImage bosshit;	PImage explosion;	PImage ship;	PImage beam;	String[][] MapArray = {{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," ","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," "," "," ","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," "," "," "," ","X","X"," "," "," ","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," ","X","X"," ","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X","X","X","X","X"," ","X","X"," ","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X"," "," ","X","X"," ","X","X","X","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X"," "," ","X","X"," ","X","X","X","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X"," "," "," "," "," "," "," "," "," "," "," "," "," ","X","X"},			{"X","X"," "," ","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X"," "," ","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X"," "," "," "," "," "," ","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"}	};	String[][] MapArray1 = {{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," ","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," "," "," ","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," "," "," "," ","X","X"," "," "," ","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," ","X","X"," ","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X","X","X","X","X"," ","X","X"," ","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X"," "," ","X","X"," ","X","X","X","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X"," "," ","X","X"," ","X","X","X","X","X","X"," "," ","X","X"},			{"X","X"," "," ","X","X"," "," "," "," "," "," "," "," "," "," "," "," "," ","X","X"},			{"X","X"," "," ","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X"," "," ","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X"," "," "," "," "," "," ","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}	};	String[][] MapArray2 = {{"X","X","X","X","X","X"," ","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X"," "," "," "," "," ","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," "," ","X","X"," "," "," "," "," ","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," "," ","X","X"," "," "," "," "," ","X","X"},			{"X","X"," "," "," ","X","X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X"},			{"X","X"," "," "," ","X","X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X"},			{"X","X"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," "," "," "," "," "," "," "," "," ","X","X"},			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," "," "," ","X","X"},			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"," ","X","X","X"}	};	String[][] MapArray3a = {{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," "," "," "," ","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," ","X","X"," "," "," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X"," "," ","X","X"," ","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X","X","X","X"," ","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," "," "," "," ","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," ","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," "," "," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X","X","X"," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X","X","X"," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," "," "," "," "," "," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"}	};	String[][] MapArray3b = {{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," "," "," "," ","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," ","X","X"," "," "," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X"," "," ","X","X"," ","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X","X","X","X"," ","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," "," "," "," ","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," ","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X"," "," "," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X","X","X"," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," ","X","X","X","X"," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X"," "," "," "," "," "," ","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"}	};	String[][] MapArray4a = {{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," ","X"," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}	};	String[][] MapArray4b = {{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"}, 			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," "," "," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X"," "," "," "," "," ","X"," "," "," "," "," ","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X"," "," "," ","X","X","X","X","X","X","X","X","X"},			{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}	};	Hero hero = new Hero("generic"); //Creates Hero object	Inventory inventory = new Inventory(15,40); //Creates inventory object	Map gameMap = new Map(); //Creates map object	Boss boss = new Boss(); //Creates boss object	Enemy enemy;	public static void main(String[] args) {		PApplet.main("Main");	}	public void settings(){		size(640,480);	}	public void setup(){		fill(12,50,40);		smooth();		frameRate(60); //Sets framerate		f = createFont("Comic Sans MS", 30, true);		f2 = createFont("Nevis", 30, true);		forest = loadImage("forest.jpg");		forest2 = loadImage("forest2.jpg");		forest3 = loadImage("forest3.jpg");		forest4 = loadImage("forest4.jpg");		textbox = loadImage("textbox.png");		textbox.resize(165, 100);		namebox = loadImage("namebox.png");		gametitle = loadImage("gametitle.png");		namebox.resize(330, 40);		textboxhv = loadImage("textboxselect.png");		textboxhv.resize(165, 100);		play = loadImage("Play.png");		play.resize(150, 90);		playhv = loadImage("Playhv.png");		playhv.resize(150, 90);		Pause = loadImage("Pause.png");		Run = loadImage("Run.png");		Run.resize(640, 480);		Instructions = loadImage("Instructions.png");		Gamsel = loadImage("Gamsel.png");		Namsel = loadImage("Namsel.png");		Clasel = loadImage("Clasel.png");		Treasure = loadImage("treasure.png");		Treasure.resize(30, 30);		HUD = loadImage("HUD.png");		HUD.resize(640, 480);		BattHUD = loadImage("BattHUD.png");		BattHUD.resize(640, 480);		Map1 = loadImage("Map1.jpg");		Map2 = loadImage("Map2.jpg");		Map3 = loadImage("Map3.jpg");		Map4a = loadImage("Map4a.jpg");		Map4b = loadImage("Map4b.jpg");		Map4broken = loadImage("map4broken.png");		mapgrid = loadImage("mapgrid.png");		Rogue = loadImage("Screenshot_3.png");		Rogue.resize(30,30);		Mage = loadImage("Mattwut.jpg");		Mage.resize(30,30);		Thief = loadImage("MattYes.jpg");		Thief.resize(30,30);		veil = loadImage("Veil.png");		invenback = loadImage("Invenback.png");		Grunt = loadImage("Grunt.png");		//Grunt.resize(160, 298);		Warlock = loadImage("Warlock.png");		bscreen = loadImage("bscreen.png");		HellYeah = loadImage("Hell Yeah.png");		NMD = loadImage("NMD.png");		MSG = loadImage("Msgnotif.png");		Clue = loadImage("Clue.png");		spacback = loadImage("spacback.jpg");		Boss = loadImage("EBoss.png");		bosshit = loadImage("bosshit.png");		explosion = loadImage("explosion.png");		explosion.resize(1080,720);		ship = loadImage("baseship.png");		beam = loadImage("beam.gif");		beam.resize(70,200);	}	public void draw(){		if (titlechoose == 0){ //initial start screen			background(forest);			cursor(ARROW);			//System.out.println(mouseX);			//System.out.println(mouseY);			image(gametitle, width/2, height/4);			rectMode(CENTER);			noStroke();			//stroke(0);			//strokeWeight(5);			if (mouseX >= (260) && mouseX <= (380) && mouseY >= (210) && mouseY <= (270)){				fill(189, 195, 199);				//stroke(0);				//strokeWeight(5);				//rect(width/2, height/2, 130, 70);				imageMode(CENTER);				//textbox.filter(INVERT);				image(textboxhv, width/2, height/2);				//fill(0);				//textFont(f, 30);				//textAlign(CENTER);				//text("Play!", width/2, (height/2)+10);				imageMode(CENTER);				image(playhv, width/2, height/2);			} else{				//fill(22, 160, 133);				//rect(width/2, height/2, 120, 60);				imageMode(CENTER);				image(textbox, width/2, height/2);				//fill(187);				//textFont(f, 30);				//textAlign(CENTER);				//text("Play!", width/2, (height/2)+10);				imageMode(CENTER);				image(play, width/2, height/2);			}			//image(image, width/2, height/2);		}
		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		else if (titlechoose == 1){  //Instructions screen
			background(forest);
			cursor(ARROW);
			//System.out.println(mouseX);
			//System.out.println(mouseY);
			rectMode(CENTER);
			noStroke();
			fill(0,66,37);
			rect((width/2)+(width/4), (height/2)+(height/4)+50, 120, 50);			imageMode(CORNER);			image(Instructions, 0,0);
			fill(187);
			textFont(f, 30);
			textAlign(CENTER);
			text("Play!", (width/2)+(width/4), (height/2)+(height/4)+60);

			if (mouseX >= (420) && mouseX <= (540) && mouseY >= (385) && mouseY <= (435)){
				fill(0,123,167);
				//stroke(0);
				//strokeWeight(5);
				rect((width/2)+(width/4), (height/2)+(height/4)+50, 130, 60);

				fill(0);
				textFont(f, 30);
				textAlign(CENTER);
				text("Play!", (width/2)+(width/4), (height/2)+(height/4)+60);
			}

		}
		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		else if (titlechoose == 2){  //New/Load Game Screen
			background(forest2);
			cursor(ARROW);
			//System.out.println("X:"+mouseX);
			//System.out.println("Y:"+mouseY);
			rectMode(CENTER);
			noStroke();
			fill(0,66,37);
			rect(width/2, (height/2)-(height/8), 130, 40);			imageMode(CORNER);			image(Gamsel, 0,0);

			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text("New Game", width/2, (height/2)-(height/8)+5);

			if (mouseX >= (255) && mouseX <= (385) && mouseY >= (160) && mouseY <= (200)){
				fill(0,123,167);
				//stroke(0);
				//strokeWeight(5);
				rect(width/2, (height/2)-(height/8), 140, 50);

				fill(0);
				textFont(f, 20);
				textAlign(CENTER);
				text("New Game", width/2, (height/2)-(height/8)+5);
			}
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2), 130, 40);

			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text("Load Game", width/2, (height/2)+5);
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2)+(height/8), 130, 40);

			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text("Back", width/2, (height/2)+(height/8)+5);

		}
		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		else if (titlechoose == 3){ //name Select Screen
			background(forest3);
			cursor(ARROW);
			//System.out.println("X:"+mouseX);
			//System.out.println("Y:"+mouseY);
			//fill(0,66,37);
			//rect(width/2, (height/2), 330, 40);			imageMode(CORNER);			image(Namsel, 0,0);
			imageMode(CENTER);
			image(namebox, width/2, height/2);
			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text(nameInput, width/2, (height/2)+5);
			System.out.println(nameInput);
			/*--------------------------------------------------*/
			rectMode(CENTER);
			noStroke();
			fill(0,66,37);
			rect((width/2)+(width/4), (height/2)+(height/4)-40, 120, 50);

			fill(187);
			textFont(f, 30);
			textAlign(CENTER);
			text("Back", (width/2)+(width/4), (height/2)+(height/4)-30);


		}
		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		else if (titlechoose == 4){ //class Select Screen
			background(forest4);
			cursor(ARROW);
			//System.out.println(mouseX);
			//System.out.println(mouseY);						imageMode(CORNER);			image(Clasel, 0,0);			
			rectMode(CENTER);
			noStroke();
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2)-(height/8), 130, 40);

			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text("Rogue", width/2, (height/2)-(height/8)+5);
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2), 130, 40);

			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text("Mage", width/2, (height/2)+5);
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2)+(height/8), 130, 40);

			fill(187);
			textFont(f, 20);
			textAlign(CENTER);
			text("Thief", width/2, (height/2)+(height/8)+5);
			/*--------------------------------------------------*/
			rectMode(CENTER);
			noStroke();
			fill(0,66,37);
			rect((width/2)+(width/4), (height/2)+(height/4)+50, 120, 50);

			fill(187);
			textFont(f, 30);
			textAlign(CENTER);
			text("Back", (width/2)+(width/4), (height/2)+(height/4)+60);

		}
		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		else if (titlechoose == 5){ //Game Screen
			//System.out.println(heromapx+"+"+heromapy);			//if (enemencount == 1){			//	titlechoose = 6;			//}			if (hero.getHealth() <= 0){				titlechoose = 9;			}
			background(0);
			cursor(ARROW);
			//System.out.println(mouseX);
			//System.out.println(mouseY);
			rectMode(CENTER);
			stroke(0);
			strokeWeight(5);			if (mapchoose == 1){				MapArray = MapArray1;			}			else if (mapchoose == 2){				MapArray = MapArray2;			}			else if (mapchoose == 3){				MapArray = MapArray3a;			}			else if (mapchoose == 4){				MapArray = MapArray3b;			}			else if (mapchoose == 5){				MapArray = MapArray4a;				if(lvltimer >=0){					lvltimer--;				} else{					titlechoose = 11;				}			}			else if (mapchoose == 6){				MapArray = MapArray4b;			}
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2)+(height/4)+(height/8)+30, width+10, (height/4));
			fill(0);
			rectMode(CORNER);
			imageMode(CORNER);			if (mapchoose == 1){
				image(Map1,5,0);			} 			else if (mapchoose ==2){				image(Map2,5,0);				if (treastrig == false){					image(Treasure,485, 60);				}			} 			else if (mapchoose ==3 || mapchoose == 4){				image(Map3,5,0);			} else if (mapchoose ==5){				image(Map4a,5,0);				if(lvltimer >=0){					lvltimer--;					System.out.println(lvltimer);				} else{					titlechoose = 11;				}			}			else if (mapchoose ==6){				image(Map4b,5,0);			}
			//rect(5,0, 630, 390);//Centerpiece for gameboard
			if (rogueyes == true){
				image(Rogue, heroposx,heroposy);			} else if (mageyes == true){				image(Mage, heroposx,heroposy);			} else if (thiefyes == true){				image(Thief, heroposx,heroposy);			}			if (gridtoggle == true){				System.out.println("ZAP!");				image(mapgrid,5,0);			}			if (mapchoose == 2){				imageMode(CENTER);				tint(255, 254.9f);				image(veil,heroposx, heroposy);			}			if (invencheck == true){				imageMode(CORNER);				image(invenback,0,0);				if (keycheck == true){					image(HellYeah,0,0);				} else if (keycheck == false){					image(NMD,0,0);				}				if (useask == true && dropask == false){					fill(0,0,255);				} else if (dropask == true && useask == false){					fill(255,0,0);				} else{					fill(0);				}				textFont(f, 14);				textAlign(CORNER);				text(inventory.printInventorySize(), 120, 24);				textFont(f, 12);				text(inventory.printInventory(1), 120, 80);				text("[U] to use, [X] to drop", 350, 46);				if (useask == true && dropask == false){					text("Click the item you want to use", 350, 24);				}				if (dropask == true && useask == false){					text("Click the item you want to drop", 350, 24);				}			}			if (mapchoose == 2 &&treastrig == true && msgtimer >=0){				imageMode(CORNER);				image(MSG,0,0);				image(Clue,0,0);				msgtimer--;			} else{				treastrig = false;				msgtimer = 300;			}

			rectMode(CORNER);
			fill(255, 0, 0);
			//rect(10, 405, 100, 10);			imageMode(CORNER);			image(HUD,0,0);			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 410, 100, 10);
			fill(0, 255, 0);
			rect(10, 410, hero.getHealth(), 10); 
			rectMode(CENTER);

			fill(187);
			textFont(f, 12);
			textAlign(CORNER);
			text("HP: "+hero.getHealth(), 115, 420);

			/*--------------------------------------------------*/
			rectMode(CORNER);
			fill(255, 0, 0);
			rect(10, 430, 100, 10);
			fill(0, 255, 0);
			rect(10, 430, hero.getHunger(), 10); 
			rectMode(CENTER);

			fill(187);
			textFont(f, 12);
			textAlign(CORNER);
			text("Hunger: "+hero.getHunger(), 115, 440);
			/*--------------------------------------------------*/
			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("NAME: "+heroname, 10, 460);
			fill(187);
			textFont(f, 11);
			textAlign(CENTER);
			//text("(W) = UP   (A) = Left   (S) = Down   (D) = Right   \n(I) = Inventory   (U) = Save   (T) = Toggle Grid", 345, 415);			/*--------------------------------------------------*/			imageMode(CORNER);			fill(55, 30, 100);			image(textbox, (width/2)+(width/4), (height/2)+(height/4)+(height/16)-7);			image(Pause,0,-2);			//if (notifyes == true){			//text(notifstring, 380, 380);			if (itempu == true && notiftimer >=0){				fill(255);				textFont(f, 12);				textAlign(CORNER);				text("GOT AN ITEM",240,455);				notiftimer--;			}			else if (notiftimer < 0){				itempu = false;				notiftimer = 60;			}			//}
		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 6){ //Scrub encounter Screen			if (enemy.getEnemHealth() <= 0){				titlechoose = 5;			}			if (hero.getHealth() <= 0){				titlechoose = 9;			}			background(4,235,43);		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 7){ //Grunt encounter Screen			if (enemy.getEnemHealth() <= 0){				titlechoose = 5;			}			if (hero.getHealth() <= 0){				titlechoose = 9;			}			background(bscreen);			imageMode(CORNER);			image(Grunt,400,0);			fill(0);			textFont(f, 14);			text("HP: "+enemy.getEnemHealth(), 200,45);			text("Grunt "+enemy.getName(), 100, 45);			/*----------------------------------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			rect(75, 55, 35, 10);			fill(0, 255, 0);			rect(75, 55, enemy.getEnemHealth(), 10); 			rectMode(CENTER);			/*----------------------------------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			//rect(10, 405, 100, 10);			imageMode(CORNER);			image(BattHUD,0,0);			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 410, 100, 10);			fill(0, 255, 0);			rect(10, 410, hero.getHealth(), 10); 			rectMode(CENTER);			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("HP: "+hero.getHealth(), 115, 420);			/*--------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 430, 100, 10);			fill(0, 255, 0);			rect(10, 430, hero.getHunger(), 10); 			rectMode(CENTER);			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("Hunger: "+hero.getHunger(), 115, 440);			/*--------------------------------------------------*/			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("NAME: "+heroname, 10, 460);			fill(187);			textFont(f, 11);			textAlign(CENTER);			//text("(W) = UP   (A) = Left   (S) = Down   (D) = Right   \n(I) = Inventory   (U) = Save   (T) = Toggle Grid", 345, 415);			/*--------------------------------------------------*/			imageMode(CORNER);			fill(55, 30, 100);			image(textbox, (width/2)+(width/4), (height/2)+(height/4)+(height/16)-7);			image(Run,-2,0);		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 8){ //Warlock encounter Screen			if (enemy.getEnemHealth() <= 0){				titlechoose = 5;			}			if (hero.getHealth() <= 0){				titlechoose = 9;			}			background(bscreen);			imageMode(CORNER);			image(Warlock,400,0);			fill(0);			textFont(f, 14);			text("HP: "+enemy.getEnemHealth(), 200,45);			text("Warlock "+enemy.getName(), 100, 45);			/*----------------------------------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			rect(75, 55, 50, 10);			fill(0, 255, 0);			rect(75, 55, enemy.getEnemHealth(), 10); 			rectMode(CENTER);			/*----------------------------------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			//rect(10, 405, 100, 10);			imageMode(CORNER);			image(BattHUD,0,0);			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 410, 100, 10);			fill(0, 255, 0);			rect(10, 410, hero.getHealth(), 10); 			rectMode(CENTER);			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("HP: "+hero.getHealth(), 115, 420);			/*--------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 430, 100, 10);			fill(0, 255, 0);			rect(10, 430, hero.getHunger(), 10); 			rectMode(CENTER);			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("Hunger: "+hero.getHunger(), 115, 440);			/*--------------------------------------------------*/			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("NAME: "+heroname, 10, 460);			fill(187);			textFont(f, 11);			textAlign(CENTER);			//text("(W) = UP   (A) = Left   (S) = Down   (D) = Right   \n(I) = Inventory   (U) = Save   (T) = Toggle Grid", 345, 415);			/*--------------------------------------------------*/			imageMode(CORNER);			fill(55, 30, 100);			image(textbox, (width/2)+(width/4), (height/2)+(height/4)+(height/16)-7);			image(Run,-2,0);		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 9){ //Game Over Screen			background(255,0,0);			text("GAME OVER", width/2, height/2);		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 10){ //Pause Screen			fill(0, 0, 0, 5);			rect(0, 0, width*2, height*2);			rectMode(CENTER);			fill(255);			rect(width/2, 150, 200, 60);			rectMode(CENTER);			fill(255);			rect(width/2, 450, 200, 60);			textFont(f2, 18);			fill(0);			text("Return to Main Menu", (width/2)-90, 150);			text("Exit to Main Menu", (width/2)-80, 450);			textFont(f2, 12);			fill(0);			text("Resets Game", (width/2)-40, 470);			imageMode(CENTER);			fill(255);			textFont(f2, 16);			text("[P] to Unpause", 330, 20);		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 11){ //Pause Screen			background(0);			//System.out.println("BLART");			//System.out.println("BossX:"+bossx+" BossY:"+bossy);			imageMode(CORNER);			image(spacback,0,backmove);			if(backmove == 960){				backmove = 0;			}			if(backmove == 0){				tempbackmove = backmove-960;			}			image(spacback,0,tempbackmove);			image(Map4broken,5,mapmove);						imageMode(CENTER);			image(Boss,bossx,bossy);			if (abs((float) (mouseX - mx)) > 0.1) {				mx = mx + (mouseX - mx) * 0.2;			}			float shipx = (float)mx;			imageMode(CENTER);			image(ship,shipx, 300);			if (movetimer >=0){				movetimer--;			} else{				backmove = backmove+1;				tempbackmove++;				mapmove = mapmove+1;				if (bossy <=133 && bossy > 83 && bossmovey == true){					bossy--;				} else if (bossy <133 && bossy >= 83 && bossmovey == false){					bossy++;				} 				if (bossy == 83){					bossmovey = false;				} else if (bossy == 133){					bossmovey = true;				}				/*---------------------------------------------------------------*/				if (bossx <=480 && bossx > 0 && bossmovex == true){					bossx--;				} else if (bossx < 480 && bossx >= 0 && bossmovex == false){					bossx++;				} 				if (bossx == 0){					bossmovex = false;				} else if (bossx == 480){					bossmovex = true;				}								if (mousePressed){					image(beam,shipx,beamy+60);					if (shipx > bossx-80 && shipx < bossx+80 && beamy > bossy-83 && beamy < bossy + 83) {						BossHP = BossHP-5;						image(bosshit,bossx,bossy);						if (BossHP <= 0)						{							titlechoose = 12;						}					}				}				fill(255);				textFont(f,14);				text(BossHP,35,35);			}						if (expltimer >=0){				imageMode(CENTER);				image(explosion, width/2,height/2);				expltimer--;			}						/*---------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			//rect(10, 405, 100, 10);			imageMode(CORNER);			image(HUD,0,0);			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 410, 100, 10);			fill(0, 255, 0);			rect(10, 410, hero.getHealth(), 10); 			rectMode(CENTER);			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("HP: "+hero.getHealth(), 115, 420);			/*--------------------------------------------------*/			rectMode(CORNER);			fill(255, 0, 0);			rect(10, 430, 100, 10);			fill(0, 255, 0);			rect(10, 430, hero.getHunger(), 10); 			rectMode(CENTER);			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("Hunger: "+hero.getHunger(), 115, 440);			/*--------------------------------------------------*/			fill(187);			textFont(f, 12);			textAlign(CORNER);			text("NAME: "+heroname, 10, 460);			fill(187);			textFont(f, 11);			textAlign(CENTER);			//text("(W) = UP   (A) = Left   (S) = Down   (D) = Right   \n(I) = Inventory   (U) = Save   (T) = Toggle Grid", 345, 415);			/*--------------------------------------------------*/			imageMode(CORNER);			fill(55, 30, 100);			image(textbox, (width/2)+(width/4), (height/2)+(height/4)+(height/16)-7);			image(Pause,0,-2);			//if (notifyes == true){			//text(notifstring, 380, 380);			if (itempu == true && notiftimer >=0){				fill(255);				textFont(f, 12);				textAlign(CORNER);				text("GOT AN ITEM",240,455);				notiftimer--;			}			else if (notiftimer < 0){				itempu = false;				notiftimer = 60;			}		}		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		else if (titlechoose == 12){ //Pause Screen			background(0,0,255);			fill(0);			textFont(f,25);			text("Congrats, you beat the game.  Now close this window.",width/2,height/2);		}

	}

	public void mouseClicked() {

		if (mouseX >= (260) && mouseX <= (380) && mouseY >= (210) && mouseY <= (270) && titlechoose == 0) { //Play on main screen clicked
			System.out.println("CLICK!");
			titlechoose = 1;
			forest.filter(BLUR, 8);
		} 
		if (mouseX >= (420) && mouseX <= (540) && mouseY >= (385) && mouseY <= (435) && titlechoose == 1) { //Play on instruction screen clicked
			System.out.println("CLICK!");
			titlechoose = 2;
			forest2.filter(BLUR, 4);
		}
		/*--------------------------------------------------*/
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (160) && mouseY <= (200) && titlechoose == 2) { //New game clicked
			System.out.println("CLICK!");
			titlechoose = 3;
			forest3.filter(BLUR, 4);
		}		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (220) && mouseY <= (260) && titlechoose == 2) { //Mage clicked on Class Choose screen			try {				hero = loadHero();			} catch (ClassNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			} catch (IOException e) {				// TODO Auto-generated catch block				e.printStackTrace();			} //Loads hero from serializable file			try {				inventory = loadInventory();			} catch (ClassNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			} catch (IOException e) {				// TODO Auto-generated catch block				e.printStackTrace();			} //Loads inventory from serializable file						titlechoose = 5;		}
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (280) && mouseY <= (320) && titlechoose == 2) { //Back on New Game screen clicked
			System.out.println("CLICK!");
			titlechoose = 1;
		}
		/*--------------------------------------------------*/
		if (mouseX >= (420) && mouseX <= (540) && mouseY >= (295) && mouseY <= (345) && titlechoose == 3) { //Back on Name choose screen clicked
			System.out.println("CLICK!");
			titlechoose = 2;
		}
		/*--------------------------------------------------*/
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (160) && mouseY <= (200) && titlechoose == 4) { //Rogue clicked on Class Choose screen
			System.out.println("CLICK!");
			hero = new Rogue(heroname); //Casts to Rogue class
			hero.setAtt(40); //Sets attack value for hero
			hero.setDef(30); //Sets Defense value for hero
			hero.setSpeed(20); //Sets Speed value for hero			rogueyes = true;
			gameMap.getMap(mapchoose); //Chooses map #
			titlechoose = 5;
		}
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (220) && mouseY <= (260) && titlechoose == 4) { //Mage clicked on Class Choose screen
			System.out.println("CLICK!");
			hero = new Mage(heroname); //Casts to Mage class
			hero.setAtt(30);
			hero.setDef(20);
			hero.setSpeed(30);			mageyes = true;
			gameMap.getMap(mapchoose); //Chooses map #
			titlechoose = 5;
		}
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (280) && mouseY <= (320) && titlechoose == 4) { //Thief clicked on Class Choose screen
			System.out.println("CLICK!");
			hero = new Thief(heroname); //Casts to Thief class
			hero.setAtt(20);
			hero.setDef(30);
			hero.setSpeed(40);			thiefyes = true;
			gameMap.getMap(mapchoose); //Chooses map #
			titlechoose = 5;
		}
		if (mouseX >= (420) && mouseX <= (540) && mouseY >= (385) && mouseY <= (435) && titlechoose == 4) { //Back on Class Choose screen clicked
			System.out.println("CLICK!");
			titlechoose = 3;
		}
		/*--------------------------------------------------*/
		if (mouseX >= (500) && mouseX <= (620) && mouseY >= (400) && mouseY <= (470) && titlechoose == 5) { //Pause on game screen clicked			System.out.println("CLICK!");			titlechoose = 10;		}		if (mouseX >= (500) && mouseX <= (620) && mouseY >= (400) && mouseY <= (470) && (titlechoose == 6 || titlechoose == 7 || titlechoose == 8)) { //Pause on game screen clicked			System.out.println("CLICK!");			titlechoose = 5;		}		if(titlechoose == 5 && invencheck == true && useask == true){			//invenchoice = Integer.parseInt(itemInput);			if (mouseY >= 65 && mouseY <=85){				invenchoice = 1;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 90 && mouseY <=115){				invenchoice = 2;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 117 && mouseY <=140){				invenchoice = 3;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 145 && mouseY <=165){				invenchoice = 4;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 172 && mouseY <=190){				invenchoice = 5;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 195 && mouseY <=215){				invenchoice = 6;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 225 && mouseY <=245){				invenchoice = 7;				inventory.useItem(invenchoice, hero);				useask = false;			}			else if (mouseY >= 250 && mouseY <=270){				invenchoice = 8;				inventory.useItem(invenchoice, hero);				useask = false;			}			else{				System.out.println("Potat");			}		}		if(titlechoose == 5 && invencheck == true && dropask == true){			//invenchoice = Integer.parseInt(itemInput);			if (mouseY >= 65 && mouseY <=85){				invenchoice = 1;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 90 && mouseY <=115){				invenchoice = 2;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 117 && mouseY <=140){				invenchoice = 3;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 145 && mouseY <=165){				invenchoice = 4;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 172 && mouseY <=190){				invenchoice = 5;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 195 && mouseY <=215){				invenchoice = 6;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 225 && mouseY <=245){				invenchoice = 7;				inventory.dropItem(invenchoice);				dropask = false;			}			else if (mouseY >= 250 && mouseY <=270){				invenchoice = 8;				inventory.dropItem(invenchoice);				dropask = false;			}			else{				System.out.println("Potat");			}		}
	}

	public void keyPressed() {
		if(titlechoose == 3){
			nameInput = nameInput + key;
		} 
		if(key == BACKSPACE && titlechoose == 3){
			System.out.println("BACK");
			if (nameInput.length() > 1){
				nameInput = nameInput.substring(0, nameInput.length() - 2);
			}
		} 
		if(key == ENTER && titlechoose == 3){
			heroname = nameInput;
			titlechoose = 4;
		}
		if(keyCode == 'T' && titlechoose == 5){
			System.out.println("BOP!");
			if (gridtoggle == false){
				gridtoggle = true;
			} else{
				gridtoggle = false;
			}
		}		if(keyCode == 'I' && titlechoose == 5){			System.out.println("BLIP!");			if (invencheck == false){				invencheck = true;			} else{				invencheck = false;			}		}		if(keyCode == 'P' && titlechoose == 10){			titlechoose = 5;		}		if(keyCode == 'U' && titlechoose == 5 && invencheck == true){			if (useask == false){				useask = true;			} else if (useask = true){				useask = false;			}		}  		if(keyCode == 'X' && titlechoose == 5 && invencheck == true){			if (dropask == false){				dropask = true;			} else if (dropask = true){				dropask = false;			}		} 		if(keyCode == 'K' && titlechoose == 5){			FileOutputStream sendout;			try {				sendout = new FileOutputStream("save.ser");				ObjectOutputStream objsend;				try {					objsend = new ObjectOutputStream(sendout);					try {						objsend.writeObject(hero);						System.out.println("Hero Data saved!");						try {							objsend.close();						} catch (IOException e) {							// TODO Auto-generated catch block							e.printStackTrace();						}  //Writes hero class to serializable file					} catch (IOException e) {						// TODO Auto-generated catch block						e.printStackTrace();					}				} catch (IOException e) {					// TODO Auto-generated catch block					e.printStackTrace();				}			} catch (FileNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			}									FileOutputStream possendout;			try {				possendout = new FileOutputStream("mapsave.ser");				ObjectOutputStream posobjsend;				try {					posobjsend = new ObjectOutputStream(possendout);					try {						posobjsend.writeObject(heroposx);						posobjsend.writeObject(heroposy);						posobjsend.writeObject(heromapx);						posobjsend.writeObject(heromapy);						posobjsend.writeObject(mapchoose);						try {							posobjsend.close();						} catch (IOException e) {							// TODO Auto-generated catch block							e.printStackTrace();						}  //Writes hero class to serializable file					} catch (IOException e) {						// TODO Auto-generated catch block						e.printStackTrace();					}				} catch (IOException e) {					// TODO Auto-generated catch block					e.printStackTrace();				}			} catch (FileNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			}						FileOutputStream invensendout;			try {				invensendout = new FileOutputStream("invensave.ser");				ObjectOutputStream invenobjsend;				try {					invenobjsend = new ObjectOutputStream(invensendout);					try {						invenobjsend.writeObject(inventory);						System.out.println("Hero Data saved!");						try {							invenobjsend.close();						} catch (IOException e) {							// TODO Auto-generated catch block							e.printStackTrace();						} //Writes inventory class to serializable file					} catch (IOException e) {						// TODO Auto-generated catch block						e.printStackTrace();					}				} catch (IOException e) {					// TODO Auto-generated catch block					e.printStackTrace();				}			} catch (FileNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			}		} 		//if(keyCode == 'X' && titlechoose == 7){		//	titlechoose = 5;		//} 

	}

	public void keyReleased() {
		if (keyCode == 'W' && titlechoose == 5) {
			heroMove("W");			if (heromapy == 0 & mapchoose <= 6){ //Changes maps				heroposy = 330;				heromapy = 11;				mapchoose++; //Changes map				System.out.println("Map is now "+mapchoose);			} 			if (heromapy == 2 & heromapx == 16 && mapchoose ==2){ //Changes maps				cluetrig = true;				treastrig = true;			}			if (heromapy == 12 & mapchoose <= 6){ //Changes maps				heroposy = 30;				heromapy = 1;				mapchoose--; //Changes map				System.out.println("Map is now "+mapchoose);			} 			if (mapchoose <= 4){ //Does enemy encounter check while map isn't Map 5				enemencount = encmin + (int)(Math.random() * ((encmax - encmin) + 1));				if (enemencount == 1){					enemy = new Enemy(); //Creates enemy					enechoose = enemin + (int)(Math.random() * ((enemax - enemin) + 1)); //Chooses enemy type					if (enechoose == 1){ //Casts to Scrub						enemy = new Scrub();						enemy.setHP(20);						System.out.println("You have encountered the Scrub "+enemy.getName()+"! Fight!");						//titlechoose = 6;					} else if (enechoose == 2){ //Casts to Grunt						enemy = new Grunt(35);						enemy.setHP(35);						System.out.println("HP has been set!");						System.out.println("You have encountered the Grunt "+enemy.getName()+"! Fight!");						titlechoose = 7;					} else if (enechoose == 3){ //Casts to Warlock						enemy = new Warlock();						enemy.setHP(50);						System.out.println("You have encountered the Warlock "+enemy.getName()+"! Fight!");						titlechoose = 8;					}				}			}			itemencount = itenmin + (int)(Math.random() * ((itenmax - itenmin) + 1)); //Does item pickup check 			if (itemencount == 1){				inventory.addItem();				itempu = true;			}			if (hero.getHunger() > 0){				hero.incHunger(); //Decreases Hero's hunger level				if (hero.getHunger() < 0){					hero.setHunger(0);				}			} else{				hero.heroDamage(2);			}
		} else if (keyCode == 'A' && titlechoose == 5) {
			heroMove("A");			if (heromapy == 0 & mapchoose <= 6){ //Changes maps				heroposy = 330;				heromapy = 11;				mapchoose++; //Changes map				System.out.println("Map is now "+mapchoose);			}			if (heromapy == 2 & heromapx == 16 && mapchoose ==2){ //Changes maps				cluetrig = true;				treastrig = true;			}			if (heromapy == 12 & mapchoose <= 6){ //Changes maps				heroposy = 30;				heromapy = 1;				mapchoose--; //Changes map				System.out.println("Map is now "+mapchoose);			}			if (heromapy == 4 & heromapx == 3 && mapchoose == 3){ //Changes maps				mapchoose++; //Changes map				keycheck = true;				System.out.println("Map is now "+mapchoose);			}			if (mapchoose <= 6){ //Does enemy encounter check while map isn't Map 4				enemencount = encmin + (int)(Math.random() * ((encmax - encmin) + 1));				if (enemencount == 1){					enemy = new Enemy(); //Creates enemy					enechoose = enemin + (int)(Math.random() * ((enemax - enemin) + 1)); //Chooses enemy type					if (enechoose == 1){ //Casts to Scrub						enemy = new Scrub();						enemy.setHP(20);						System.out.println("You have encountered the Scrub "+enemy.getName()+"! Fight!");						//titlechoose = 6;					} else if (enechoose == 2){ //Casts to Grunt						enemy = new Grunt(35);						enemy.setHP(35);						System.out.println("You have encountered the Grunt "+enemy.getName()+"! Fight!");						titlechoose = 7;					} else if (enechoose == 3){ //Casts to Warlock						enemy = new Warlock();						enemy.setHP(50);						System.out.println("You have encountered the Warlock "+enemy.getName()+"! Fight!");						titlechoose = 8;					}				}			}			itemencount = itenmin + (int)(Math.random() * ((itenmax - itenmin) + 1)); //Does item pickup check 			if (itemencount == 1){				inventory.addItem();				itempu = true;			}			if (hero.getHunger() > 0){				hero.incHunger(); //Decreases Hero's hunger level				if (hero.getHunger() < 0){					hero.setHunger(0);				}			} else{				hero.heroDamage(2);			}
		} else if (keyCode == 'S' && titlechoose == 5) {
			heroMove("S");;			if (heromapy == 0 & mapchoose <= 6){ //Changes maps				heroposy = 330;				heromapy = 11;				mapchoose++; //Changes map				System.out.println("Map is now "+mapchoose);			}			if (heromapy == 2 & heromapx == 16 && mapchoose ==2){ //Changes maps				cluetrig = true;				treastrig = true;			}			if (heromapy == 12 & mapchoose <= 6){ //Changes maps				heroposy = 30;				heromapy = 1;				mapchoose--; //Changes map				System.out.println("Map is now "+mapchoose);			}			if (mapchoose <= 6){ //Does enemy encounter check while map isn't Map 4				enemencount = encmin + (int)(Math.random() * ((encmax - encmin) + 1));				if (enemencount == 1){					enemy = new Enemy(); //Creates enemy					enechoose = enemin + (int)(Math.random() * ((enemax - enemin) + 1)); //Chooses enemy type					if (enechoose == 1){ //Casts to Scrub						enemy = new Scrub();						enemy.setHP(20);						System.out.println("You have encountered the Scrub "+enemy.getName()+"! Fight!");						//titlechoose = 6;					} else if (enechoose == 2){ //Casts to Grunt						enemy = new Grunt(35);						enemy.setHP(35);						System.out.println("You have encountered the Grunt "+enemy.getName()+"! Fight!");						titlechoose = 7;					} else if (enechoose == 3){ //Casts to Warlock						enemy = new Warlock();						enemy.setHP(50);						System.out.println("You have encountered the Warlock "+enemy.getName()+"! Fight!");						titlechoose = 8;					}				}			}			itemencount = itenmin + (int)(Math.random() * ((itenmax - itenmin) + 1)); //Does item pickup check 			if (itemencount == 1){				inventory.addItem();				itempu = true;			}			if (hero.getHunger() > 0){				hero.incHunger(); //Decreases Hero's hunger level				if (hero.getHunger() < 0){					hero.setHunger(0);				}			} else{				hero.heroDamage(2);			}
		}
		else if (keyCode == 'D' && titlechoose == 5) {
			heroMove("D");			if (heromapy == 0 & mapchoose <= 6){ //Changes maps				heroposy = 330;				heromapy = 11;				mapchoose++; //Changes map				System.out.println("Map is now "+mapchoose);			}			if (heromapy == 2 & heromapx == 16 && mapchoose ==2){ //Changes maps				cluetrig = true;				treastrig = true;			}			if (heromapy == 12 & mapchoose <= 6){ //Changes maps				heroposy = 30;				heromapy = 1;				mapchoose--; //Changes map				System.out.println("Map is now "+mapchoose);			}			if (mapchoose <= 6){ //Does enemy encounter check while map isn't Map 4				enemencount = encmin + (int)(Math.random() * ((encmax - encmin) + 1));				if (enemencount == 1){					enemy = new Enemy(); //Creates enemy					enechoose = enemin + (int)(Math.random() * ((enemax - enemin) + 1)); //Chooses enemy type					if (enechoose == 1){ //Casts to Scrub						enemy = new Scrub();						enemy.setHP(20);						System.out.println("You have encountered the Scrub "+enemy.getName()+"! Fight!");						//titlechoose = 6;					} else if (enechoose == 2){ //Casts to Grunt						enemy = new Grunt(35);						enemy.setHP(35);						System.out.println("You have encountered the Grunt "+enemy.getName()+"! Fight!");						titlechoose = 7;					} else if (enechoose == 3){ //Casts to Warlock						enemy = new Warlock();						enemy.setHP(50);						System.out.println("You have encountered the Warlock "+enemy.getName()+"! Fight!");						titlechoose = 8;					}				}			}			itemencount = itenmin + (int)(Math.random() * ((itenmax - itenmin) + 1)); //Does item pickup check 			if (itemencount == 1){				inventory.addItem();				itempu = true;				System.out.println("ZooBop!");			}			if (hero.getHunger() > 0){				hero.incHunger(); //Decreases Hero's hunger level				if (hero.getHunger() < 0){					hero.setHunger(0);				}			} else{				hero.heroDamage(2);			}
		}
		if (keyCode == 'X' && titlechoose == 7){			hero.heroAttack(enemy, 1); //Hero attacks enemy			((Grunt) enemy).gruntAttack(hero); //Grunt attacks hero		}		if (keyCode == 'X' && titlechoose == 8){			hero.heroAttack(enemy, 1); //Hero attacks enemy			((Warlock) enemy).warlockAttack(hero); //Warlock attacks hero		}
	}		/**	 * Moves the hero on the map and the grid	 * @param input The input given by the player	 */

	public void heroMove(String input){
		String inmove = input;
		if (inmove.equals("W") ||inmove.equals("w")){
			if (MapArray[heromapy-1][heromapx].equals(" ")){ //Checks for collision
				System.out.println(MapArray[heromapy-1][heromapx]);
				heromapy--;
				heroposy=heroposy-30; //sets new hero y-position
			} else{
				//System.out.println("Invalid entry, try again.");
			} 
		} else if(inmove.equals("S") ||inmove.equals("s")){
			if (MapArray[heromapy+1][heromapx].equals(" ")){ //Checks for collision
				System.out.println(MapArray[heromapy+1][heromapx]);
				heromapy++;
				heroposy=heroposy+30; //sets new hero y-position
			} else{
				System.out.println("Invalid entry, try again.");
			} 
		} 

		if(inmove.equals("A") ||inmove.equals("a")){
			if (MapArray[heromapy][heromapx-1].equals(" ")){
				System.out.println(MapArray[heromapy][heromapx-1]);
				heromapx--;
				heroposx=heroposx-30; //sets new hero x-position
			} else{
				System.out.println("Invalid entry, try again.");
			} 
		} else if(inmove.equals("D") ||inmove.equals("d")){
			if (MapArray[heromapy][heromapx+1].equals(" ")){
				System.out.println(MapArray[heromapy][heromapx+1]);
				heromapx++;
				heroposx=heroposx+30; //sets new hero x-position
			} else{
				System.out.println("Invalid entry, try again.");
			} 
		}
	}			/**	 * 	 * @return Returns hero object	 * @throws IOException	 * @throws ClassNotFoundException	 */	public static Hero loadHero() throws IOException, ClassNotFoundException{ //Loads Hero from serializable file		FileInputStream sendin = new FileInputStream("save.ser");		ObjectInputStream objin = new ObjectInputStream(sendin);		Hero hero;		Object o = objin.readObject();		if (o.getClass() == Rogue.class){			hero = (Rogue) o; //Casts to Rogue			rogueyes = true;		} else if (o.getClass() == Thief.class){			hero = (Thief) o; //Casts to thief			thiefyes = true;		} else {			hero = (Mage) o; //Casts to mage			mageyes = true;		}		objin.close(); 		return hero;	}		/**	 * 	 * @return Returns inventory	 * @throws IOException	 * @throws ClassNotFoundException	 */	public static Inventory loadInventory() throws IOException, ClassNotFoundException{ //Loads Inventory from serializable file		FileInputStream sendin = new FileInputStream("invensave.ser");		ObjectInputStream objin = new ObjectInputStream(sendin);		Inventory inventory = (Inventory) objin.readObject();		objin.close(); 		return inventory;	}

}
