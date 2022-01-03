package OOP.week13;


public class StartState implements Status {
	
	private CalcV1 calc;
	
	public StartState(CalcV1 calc) {
		this.calc = calc;
	}

	@Override
	public void processNumber(String ch) {
		//setOperand1(Integer.parseInt(ch));
	     calc.operand1 = Integer.parseInt(ch);    //operand1로 설정하고
	     calc.setStatus(calc.firstOperandState);     //그 다음 상태로 이동
	}
}
