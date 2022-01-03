package OOP.week13;
import java.util.Scanner;


public class CalcV1 {
    StartState startState;
    FirstOperandState firstOperandState;
    SecondOperandState secondOperandState;
    OperatorState operatorState;
    Status state;   //현재 상태 지정
   
    Scanner scanner;
    String inputStr;
    int operand1; // 첫 번째 피 연산자값 저장
    int operand2; // 두 번째 피 연산자값 저장
    char operator; // 사칙 연산자 저장

    CalcV1() {
        scanner = new Scanner(System.in);  // Create a Scanner object
        this.startState = new StartState(this);
        this.firstOperandState = new FirstOperandState(this);
        this.secondOperandState = new SecondOperandState(this);
        this.operatorState = new OperatorState(this);
        this.state = startState;
    }

    String getInput(String s) {
        System.out.println(s);
        return scanner.next();
    }
    
    void setStatus(Status status) {
    	this.state = status;
    }

    //교수님 추가 부분(get/set)
    void setOperand1(int num1) {
    	operand1 = num1;
    }

    void setOperand2(int num2) {
    	operand2 = num2;
    }

    void setOperator(char ch) {
    	operator = ch;
    }
    
    Status getStartState() {
    	return startState;
    }
    
    Status getFirstOperandState() {
    	return firstOperandState;
    }
    Status getSecondOperandState() {
    	return secondOperandState;
    }
    Status getOperatorState() {
    	return operatorState;
    }
    
    void printOutResult() {
        switch (operator) {
            case '+':
                System.out.printf("%d + %d = %d\n", operand1, operand2, operand1 + operand2);
                break;

            case '-':
                System.out.printf("%d - %d = %d\n", operand1, operand2, operand1 - operand2);
                break;

            case '*':
                System.out.printf("%d * %d = %d\n", operand1, operand2, operand1 * operand2);
                break;

            case '/':
                System.out.printf("%d / %d = %d\n", operand1, operand2, operand1 / operand2);
                break;
        }
    }

    /* 정수가 입력되었을 때 처리 */
    void processNumber(String ch) {
    	state.processNumber(ch);     
    }

    /* 사칙 연산자 혹은 = 연산자 처리 */
    void processOperator(char ch) {
    	state.processOperator(ch);
    }

    /* 프로그램의 주 로직을 담당하는 함수
       사용자 입력을 기다렸다가 q 또는 Q가 입력되면 종료
       그렇지 않으면 정수가 입력되었는지 혹은 연산자가 입력되었는지에 따라 processNumber 또는 processOperator 함수를 호출
     */
    boolean run() {
        inputStr = getInput("정수 또는 +,-,*,/,= 기호 중 한 개를 입력하세요");
        char ch = inputStr.charAt(0);
        if (ch == 'q' || ch == 'Q') { // q를 입력하면 프로그램 종료
            return false;
        }
        else if (ch >= '0' && ch <= '9') { // 정수가 입력되면
            state.processNumber(inputStr);
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') { // 연산자 처리
            state.processOperator(ch);
        }
        return true;
    }
}
