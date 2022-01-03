package OOP.week13;

public class OperatorState implements Status {

	private CalcV1 calc;
	
	public OperatorState(CalcV1 calc) {
		this.calc = calc;
	}

	@Override
	public void processNumber(String ch) {
		  calc.operand2 = Integer.parseInt(ch);
          calc.setStatus(calc.secondOperandState);
	}

}
