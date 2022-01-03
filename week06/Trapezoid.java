package OOP.week06;

import java.awt.Point;

public class Trapezoid extends Shape {

	public Trapezoid(String type, Point[] points) {
		super(type, points);
	}

	// (윗변 + 아랫변) * 높이 / 2
	@Override
	double calcArea() {
		double topWidth,bottomWidth, height, area;
	    topWidth = points[3].x - points[0].x;
	    bottomWidth = points[1].x - points[2].x;
	    height = points[3].y - points[1].y;
	    area = (topWidth + bottomWidth) * height / 2.0d;
	    return area;
	}
	
}
