package OOP.week06;

import java.awt.Point;

public interface ShapeFactory {   //Creator
	
	Shape create(String type, Point[] points);   //factory method(실제 객체 생성)
}
