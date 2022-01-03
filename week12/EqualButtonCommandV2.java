package OOP.week12;

public class EqualButtonCommandV2 extends CommandButtonV2{

	CalcGUIV1 display;  //JLABEL만 가지고 오는게 아니라, 전체를 가지고 와야 맞음
	
	public EqualButtonCommandV2(CalcGUIV1 display, Calculator calculator) {
		super(calculator);
		this.display = display;
	}

	@Override
	public void execute() {
	
		  Calculator calculator = getCalculator();
		  int result = 0;
		  //int op1 = calculator.getOperator();
          if (calculator.isOperand1Set() && calculator.isOperand2Set() && calculator.isOperatorSet()) { // 두 개 피 연산자값과 연산자가 지정되었다면
              if (calculator.getOperator() == '+') {
                  result = calculator.getOperand1() + calculator.getOperand2();
              }
              else if (calculator.getOperator() == '-') {
                  result = calculator.getOperand1() - calculator.getOperand2();
              }
              else if (calculator.getOperator() == '*') {
                  result = calculator.getOperand1() * calculator.getOperand2();
              }
              else if (calculator.getOperator() == '/') {
                  result = calculator.getOperand1() / calculator.getOperand2();
              }
          }
          display.showText("" + result);  
          calculator.clearFlags();			
	}
}
