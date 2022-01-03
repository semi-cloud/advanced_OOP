package OOP.week06;

import java.awt.Point;

public class Triangle extends Shape{
	
	public Triangle(String type, Point[] points) {
		super(type, points);
	}

	@Override
	double calcArea() {
		double a,b,c,s,area;
        a = (distance(points[0], points[1]));
        b = (distance(points[2], points[1]));
        c = (distance(points[2], points[0]));
        s = (a + b + c) / 2.0d;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
	
	}
	
	private double distance(Point p1, Point p2) {
	    double distance;
	    distance = Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
	    return distance;
	}

}
