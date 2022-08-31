import pkg.*;
public class happyFace {
	private Ellipse eye1;
	private Ellipse eye2;
	private Ellipse face;
	private Ellipse mouth;
	private Ellipse tongue;
	private int radiusofface;
	private int xpos;
	private int ypos;
	private Rectangle box;
	private int step;
	public happyFace(int x, int y){
		xpos = x;
		ypos = y;
		radiusofface = 70;
		int radiusofeyes = 10;
		face = new Ellipse(x,y,radiusofface,radiusofface);
		eye1 = new Ellipse(x+radiusofface*1/4-radiusofeyes,y+radiusofface*1/4,radiusofeyes,radiusofeyes);
		eye2 = new Ellipse(x+radiusofface*3/4-radiusofeyes,y+radiusofface*1/4,radiusofeyes,radiusofeyes);
		mouth = new Ellipse(x+radiusofface*1/3,y+radiusofface*1/2,radiusofeyes+20,radiusofeyes+5);
		tongue = new Ellipse(mouth.getX()+radiusofeyes+5, mouth.getY()+5, radiusofeyes+5, radiusofeyes);
		face.setColor(Color.YELLOW);
		eye1.setColor(Color.BLACK);
		eye2.setColor(Color.BLACK);
		tongue.setColor(Color.RED);
		box = new Rectangle(xpos,ypos,radiusofface,radiusofface);
	}
	public void fill(){
		face.fill();
		eye1.fill();
		eye2.fill();
		mouth.fill();
		tongue.fill();
	}
	public void translate(int x, int y){
		face.translate(x,y);
		eye1.translate(x,y);
		eye2.translate(x,y);
		mouth.translate(x,y);
		tongue.translate(x,y);
		box.translate(x,y);
	}
	public boolean crash(car c){
		boolean check = true;
		Rectangle carbox = c.boundingBox();
		if(box.contains(carbox)){
			return check;
		}
		else{
			check = false;
			return check;
		}
	}

	public Rectangle boundingBox(){
		return box;
	}
	public int getX(){
		return box.getX();
	}
	public int getY(){
		return box.getY();
	}
	public int getWidth(){
		return box.getWidth();
	}
	public int getHeight(){
		return box.getHeight();
	}
	public int getStep(){
		return step;
	}
	public void setStep(int st){
		step = st;
	}
}
