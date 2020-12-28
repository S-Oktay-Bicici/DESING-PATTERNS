import java.awt.*;

public interface Shape{
    void draw();
}

public class Rectangle implements Shape{

    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method");
    }
}

public class Square implements Shape{

    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method");
    }
}

public class Circle implements Shape{

    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method");
    }
}

public interface Color{
	void fill();
}

public class Red implements Color{
	@Override 
	public void fill(){
		System.out.println("Inside Red::fill() method.");
	}
}

public class Green implements Color{
	@Override
	public void fill(){
		System.out.println("Inside Green::fill() method.");
	}
}

public class Blue implements Color{
	@Override
	public void fill(){
		System.out.println("Inside Blue::fill() method.");
	}
}

public class ShapeFactory extends AbstractFactory{

	@Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
	
	@Override
	Color getColor(String color){
		return nullİ
	}
}

public class ColorFactory extends AbstractFactory{
	@Override
	public Shape getShape(String shapeType){
		return null;
	}
	
	@Override
	Color getColor(String Color){
		if(color == null){
			return null;
		}
		if(color.equalsIgnoreCase("RED")){
			return new Red();
		}
		else if(color.equalsIgnoreCase("GREEN")){
			return new Green();
		}
		else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}
		
		return null;
	}
}

public class FactoryProducer{
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		}
		else if(choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}
		
		return null;
	}
}

public class AbstractFactoryPatternDemo{
	public static void manin(String[] args){
		//get shape factory
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		
		// get an object of  Shape Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Shape Circle
        shape1.draw();

        // get an object of  Shape Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Shape Rectangle
        shape2.draw();

        // get an object of Shape Square
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of Shape Square
        shape3.draw();
		
		//get color factory
		AbstractFActory colorFactory = FactoryProducer.getFactory("COLOR");
		
		//get an object of Color Red 
		Color color1 = colorFactory.getColor("RED");
		
		//call fill method of Red 
		color1.fill();
		
		//get an object of Color Green 
		Color color2 = colorFactory.getColor("GREEN");
		
		//call fill method of Green
		color2.fill();
		
		//get an object of Color Blue 
		Color color3 = colorFactory.getColor("BLUE");
		
		//call fill method of Color Blue
		color3.fill();
	}
}
