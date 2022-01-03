package OOP.week06;

import java.awt.Point;

public class TriangularShapeFactory implements ShapeFactory {

	@Override
	public Shape create(String type, Point[] points) {
		
		if(type == "Triangle") {
			return new Triangle(type, points);
		}else if(type == "RightTriangle") {
			return new RightTriangle(type, points);
		}
		
		return null;
		
	}

	
}
