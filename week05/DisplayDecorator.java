package OOP.week05;

public abstract class DisplayDecorator extends Display{     //Decorator 추상 클래스, 기존 형식 유지 + 새로운 확장!

	public DisplayDecorator(int width, int height) {
		super(width, height);
	}

}
