package OOP.week06;

import java.awt.Point;

public class Parallelogram extends Shape{   //평행사변형	

	public Parallelogram(String type, Point[] points) {
		super(type, points);
	}

	@Override
	double calcArea() {	
	    double area;	
	    area = (points[3].x - points[0].x) * (points[3].y - points[1].y);
        return area;
	}

	/* 
	@Override 
	public String toString() {
		//super.toString();
		return super.toString() + "area:" + area + "\n";
	}
	*/
	
}
