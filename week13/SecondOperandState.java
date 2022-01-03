package OOP.week13;

public class SecondOperandState implements Status {
	
	private CalcV1 calc;
	
	public SecondOperandState(CalcV1 calc) {
		this.calc = calc;
	}

	@Override
	public void processOperator(char ch) {
        if (ch == '=') {
            calc.printOutResult();
            calc.setStatus(calc.startState);
        }
	}

}
