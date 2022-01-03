package OOP.week06;

import java.awt.Point;

public class RectangularShapeFactory implements ShapeFactory{

	@Override
	public Shape create(String type, Point[] points) {
		
		if(type == "Rectangle") {
			return new Rectangle(type, points);
		}else if(type == "Trapezoid") {
			return new Trapezoid(type, points);
		}else if(type == "Parallelogram") {
			return new Parallelogram(type, points);
		}		
		return null;
	}

}
