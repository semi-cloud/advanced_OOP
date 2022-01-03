package OOP.week06;

import java.awt.Point;

public class Rectangle extends Shape{

	public Rectangle(String type, Point[] points) {
		super(type, points);
		this.points = points;
	}

	@Override
	double calcArea() {		
		double area;
		area = (points[1].x - points[0].x) * (points[0].y - points[1].y);
        return area;       
	}

}
