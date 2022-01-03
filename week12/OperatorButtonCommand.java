package OOP.week12;

import javax.swing.JButton;
import javax.swing.JLabel;

public class OperatorButtonCommand extends CommandButton implements Command {
	
	private Calculator calculator;
	
	public OperatorButtonCommand(Calculator calculator) {
		super();      
		this.calculator = calculator;	
	}
	

	@Override
	public void execute() {
		   if (calculator.isOperand1Set()) {  // 첫 번째 피연산자 값이 지정되어야만 연산자 처리 가능
		       calculator.setOperator(getText().charAt(0));
               calculator.setOperatorSet(true);
           }
	}

}
