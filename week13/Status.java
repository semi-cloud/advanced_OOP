package OOP.week13;

//상태를 캡슐화
//인터페이스가 변경이 되면, 인터페이스를 구현하는 모든 클래스들이 해당 메소드를 구현해야 하는 문제 => 인터페이스에 메소드를 구현해 놓을 수 있도록 함(default 이용)
//재 정의를 안하면 그냥 여기에 구현되있는 메소드가 실행
public interface Status {

	default void processNumber(String ch) { 
		System.out.println("processNumber : Invaild operation");
	};     //숫자 처리
	
	default void processOperator(char ch) {
		System.out.println("processOperator : Invaild operation");
		
	};    //연산 처리
	
	//void processNumber(int num);
}
