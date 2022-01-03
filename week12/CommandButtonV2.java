package OOP.week12;

import javax.swing.JButton;

public abstract class CommandButtonV2 extends JButton implements Command {

	private Calculator calculator;  
	
	public CommandButtonV2(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public Calculator getCalculator() {
		return this.calculator;
	}
	
	@Override
	public abstract void execute();      

}
