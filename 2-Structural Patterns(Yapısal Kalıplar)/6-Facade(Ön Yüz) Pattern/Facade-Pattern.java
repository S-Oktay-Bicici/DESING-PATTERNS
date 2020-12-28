public interface Shape {
	void draw();
}

public class Rectangle implements Shape{
	
	@Override 
	public void draw(){
		System.out.println("Inside Rectangle::draw() method.");
	}
}

public class Square implements Shape{
	
	@Override 
	public void draw(){
		System.out.println("Inside Square::draw() method.");
	}
}

public class Circle implements Shape{
	
	@Override 
	public void draw(){
		System.out.println("Inside Circle::draw() method.");
	}
}

public class ShapeMaker{
	private Shape circle;
	private Shape rectangle;
	private Shape square;
	
	public ShapeMaker(){
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}
	
	public void drawCircle(){
		circle.draw();
	}
	
	public void drawRectangle(){
		rectangle.draw();
	}
	
	public void drawSquare(){
		square.draw();
	}
}

public class FacedePatternDemo{
	public static void main(String[] srgs){
		ShapeMaker shapeMaker = new ShapeMaker();
		
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}