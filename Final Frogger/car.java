import pkg.*;
public class car {
	private Rectangle body;
	private Rectangle box;
	private Polygon bettercar;
	private Ellipse wheel1;
	private Ellipse wheel2;
	private int step;
	private Text label;
	private int[] road_cord;
	private int[] xpts;
	private int[] ypts;
	private int x;
	private int y;
	private static int width;
	private static int height;
	private int radius;

	public car(int x, int y){
		this.x = x;
		this.y = y-20;
		radius = 30;
		xpts = new int[]{x,x+20,x+40,x+80,x+100,x+120,x+120,x};
		ypts = new int[]{y,y,y-20,y-20,y,y,y+20,y+20};
		bettercar = new Polygon(xpts, ypts, 8);
		width = xpts[6]-xpts[0];
		height = ypts[6]-ypts[2]+radius/2;
		box = new Rectangle(x,ypts[2],width,height);

		wheel1 = new Ellipse(x+width/4-10,getY()+height-radius,radius,radius);
		wheel2 = new Ellipse(x+width*3/4-10,getY()+height-radius,radius,radius);

		wheel1.setColor(Color.WHITE);
		wheel2.setColor(Color.WHITE);
	}
	public car(int x, int y, String z){
		this(x,y);
		label = new Text(x + width/2-20, y, z);
		label.setColor(Color.WHITE);

	}
	public car(int x, int y, String z, Color c){
		this(x,y,z);
		bettercar.setColor(c);

	}
	public void draw(){
		wheel1.fill();
		wheel2.fill();
		bettercar.fill();
		label.draw();
	}
	public static void drawroads(){
		Rectangle[] roads = new Rectangle[9];
		int x = 0;
		Rectangle bottom = new Rectangle(0,(height+100)*9,2000,height+200);
		bottom.setColor(Color.GRAY);
		bottom.fill();
		for(int count = 0; count<roads.length; count++){
			roads[count] = new Rectangle(0,(height+100)*x,2000,height+100);
			x++;
			if(count%2 == 0){
				roads[count].setColor(Color.GREEN);
				roads[count].fill();
			}
			else{
				roads[count].setColor(Color.BLACK);
				roads[count].fill();
			}
		}
	}
	public void drive(){
		translate(getStep(),0);
		Canvas.pause(5);
	}
	public void driveNotRandom(){
		if(getX()>=2000){
			translate(-getX(),0);
		}
	}
	public void driveRandom(){
		if(getX()>=2000){
			translate(-getX(),-getY()+ 70 + 110*Canvas.rand(8));
		}
		if(getX()<=-130){
			translate(-getX()+2000,-getY()+ 70 + 110*Canvas.rand(8));
		}
		if(getY()<70|| getY()>840){
			translate(0, -getY()+ 10);
		}
	}
	public void translate(double x, double y){
		wheel1.translate(x,y);
		wheel2.translate(x,y);
		label.translate(x,y);
		box.translate(x,y);
		bettercar.translate(x,y);
	}

	public int getStep(){
		return step;
	}
	public void setStep(int st){
		step = st;
	}
	public int getX(){
		int xpos = box.getX();
		return xpos;
	}
	public int getY(){
		int ypos = box.getY();
		return ypos;
	}
	public Rectangle boundingBox(){
		return box;
	}
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
}


