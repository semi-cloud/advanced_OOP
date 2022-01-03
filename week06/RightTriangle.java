package OOP.week06;

import java.awt.Point;

public class RightTriangle extends Shape{
	
	public RightTriangle(String type, Point[] points) {
		super(type, points);
	}

	@Override
	double calcArea() {
		double area = (points[2].x - points[1].x) * (points[0].y - points[2].y) / 2.0d;
	    return area;
	}

}
