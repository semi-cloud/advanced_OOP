package OOP.week13;

public class FirstOperandState implements Status {

	private CalcV1 calc;
	
	public FirstOperandState(CalcV1 calc) {
		this.calc = calc;
	}

	@Override
	public void processOperator(char ch) {
		 calc.setStatus(calc.operatorState);  //calc.getOperatorState()
		 calc.operator = ch;                  //calc.setOperand1(ch.parseInt());
	}

}
