package OOP.week12;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EqualButtonCommand extends CommandButton implements Command{
	
	private JLabel display;
	private Calculator calculator;
	
	public EqualButtonCommand(JLabel display, Calculator calculator) {
		super();      
		this.display = display;
		this.calculator = calculator;	
	}
	

	@Override
	public void execute() {
		  int result = 0;
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
          display.setText("" + result);
          calculator.clearFlags();		
	}
	
}
