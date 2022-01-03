package OOP.week06;

import java.awt.Point;

public abstract class Shape {    //Product
	
	protected Point[] points;
	private String type;
	
	public Shape(String type, Point[] points) {
		this.type = type;
		this.points = points;
	}
	
	abstract double calcArea();

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(type + "\n");
		
		for(int i = 0; i < points.length ; i++) {
			sb.append("p"+ i + ":" + points[i].toString() + "\n");
		}
		
		sb.append("area:" + calcArea() + "\n");  
		return sb.toString();
	}

}
