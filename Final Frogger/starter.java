import pkg.*;

public class starter implements InputKeyControl {
	static car[] cars;
	static int[] speed;
	static Rectangle[] boxes;
	static happyFace player;
	public static void main(String args[])
	{
		KeyController mC = new KeyController(Canvas.getInstance(),new starter());
		System.out.println("PRESS G TO START");
		cars = new car[20];
		speed = new int[cars.length];
		boxes = new Rectangle[cars.length];
		player = new happyFace(1000,825);
		int[] ystart = new int[4];
		int [] xstart = new int[cars.length];
		car.drawroads();
		player.fill();
		for(int count = 0; count<ystart.length;count++){
			ystart[count] = 155+200*count;
		}
		for(int count = 0; count<xstart.length; count++){
			xstart[count] = -150-150*count;
		}
		int temporary = 0;
		int rando= 0;
		for(int count = 0; count<cars.length; count++){
			temporary = rando;
			for(rando = Canvas.rand(15); rando==temporary;rando = Canvas.rand(15)){
			}
			Color carcol = new Color(Canvas.rand(255),Canvas.rand(255),Canvas.rand(255));
			cars[count] = new car(xstart[rando], ystart[Canvas.rand(4)] , "beep beep" , carcol);
			cars[count].draw();
		}
		int ypos;
		while(true){
			for(int count = 0; count<cars.length; count++){
				cars[count].drive();
				cars[count].driveNotRandom();
				ypos = player.getY();
				if(ypos == 0){
					Text victory = new Text(800,400,"YOU CROSSED!");
					victory.setColor(Color.RED);
					victory.grow(100,100);
					victory.draw();
					for(int count3 = 0; count3<cars.length; count3++){
						cars[count3].setStep(0);
					}
					player.setStep(0);
					break;
				}
				while(player.crash(cars[count])){
					for(int count3 = 0; count3<cars.length; count3++){
						cars[count3].setStep(0);
					}
					player.setStep(0);
					Text crash = new Text(800,400,"CRASH!");
					crash.setColor(Color.RED);
					crash.grow(100,100);
					crash.draw();
					break;
				}
			}
		}
	}
		public void keyPress(String s){
			if (s.equals("g")){
				for(int count=0; count<cars.length; count++){
					cars[count].setStep(20);
				}
				player.setStep(3);
			}
			if(s.equals("w")){
				player.translate(0,-player.getStep());
			}
			if(s.equals("d")){
				player.translate(player.getStep(),0);
			}
			if(s.equals("a")){
				player.translate(-player.getStep(),0);
			}
			if(s.equals("s")){
				player.translate(0,player.getStep());
			}
		}
		
	}
