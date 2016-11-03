import processing.core.PApplet;
		/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		else if (titlechoose == 1){  //Instructions screen
			background(forest);
			cursor(ARROW);
			//System.out.println(mouseX);
			//System.out.println(mouseY);
			rectMode(CENTER);
			noStroke();
			fill(0,66,37);
			rect((width/2)+(width/4), (height/2)+(height/4)+50, 120, 50);
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
			rect(width/2, (height/2)-(height/8), 130, 40);

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
			//rect(width/2, (height/2), 330, 40);
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
			//System.out.println(mouseY);
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
			//System.out.println(heromapx+"+"+heromapy);
			background(0);
			cursor(ARROW);
			//System.out.println(mouseX);
			//System.out.println(mouseY);
			rectMode(CENTER);
			stroke(0);
			strokeWeight(5);
			/*--------------------------------------------------*/
			fill(0,66,37);
			rect(width/2, (height/2)+(height/4)+(height/8)+30, width+10, (height/4));
			fill(0);
			rectMode(CORNER);
			imageMode(CORNER);
				image(Map1,5,0);
			//rect(5,0, 630, 390);//Centerpiece for gameboard
			if (rogueyes == true){
				image(Rogue, heroposx,heroposy);

			rectMode(CORNER);
			fill(255, 0, 0);
			//rect(10, 405, 100, 10);
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
			fill(187);
			fill(187);
			textFont(f, 11);
			textAlign(CENTER);
			//text("(W) = UP   (A) = Left   (S) = Down   (D) = Right   \n(I) = Inventory   (U) = Save   (T) = Toggle Grid", 345, 415);
		}

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
		}
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
			hero.setSpeed(20); //Sets Speed value for hero
			gameMap.getMap(mapchoose); //Chooses map #
			titlechoose = 5;
		}
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (220) && mouseY <= (260) && titlechoose == 4) { //Mage clicked on Class Choose screen
			System.out.println("CLICK!");
			hero = new Mage(heroname); //Casts to Mage class
			hero.setAtt(30);
			hero.setDef(20);
			hero.setSpeed(30);
			gameMap.getMap(mapchoose); //Chooses map #
			titlechoose = 5;
		}
		if (mouseX >= (255) && mouseX <= (385) && mouseY >= (280) && mouseY <= (320) && titlechoose == 4) { //Thief clicked on Class Choose screen
			System.out.println("CLICK!");
			hero = new Thief(heroname); //Casts to Thief class
			hero.setAtt(20);
			hero.setDef(30);
			hero.setSpeed(40);
			gameMap.getMap(mapchoose); //Chooses map #
			titlechoose = 5;
		}
		if (mouseX >= (420) && mouseX <= (540) && mouseY >= (385) && mouseY <= (435) && titlechoose == 4) { //Back on Class Choose screen clicked
			System.out.println("CLICK!");
			titlechoose = 3;
		}
		/*--------------------------------------------------*/
		if (mouseX >= (500) && mouseX <= (620) && mouseY >= (400) && mouseY <= (470) && titlechoose == 5) { //Pause on game screen clicked
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
		}

	}

	public void keyReleased() {
		if (keyCode == 'W' && titlechoose == 5) {
			heroMove("W");
		} else if (keyCode == 'A' && titlechoose == 5) {
			heroMove("A");
		} else if (keyCode == 'S' && titlechoose == 5) {
			heroMove("S");;
		}
		else if (keyCode == 'D' && titlechoose == 5) {
			heroMove("D");
		}
		if (keyCode == 'X' && titlechoose == 7){
	}

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
	}

}