package OOP.week12;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommandButton extends JButton {
	String[] buttonText = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=" };
	 
	public CommandButton() {
		super();
	}

	public void setButton(CommandButton buttons[], int i, ActionListener listener, Dimension buttonDimension) {
        buttons[i].setText(buttonText[i]);
        buttons[i].setPreferredSize(buttonDimension);
        buttons[i].addActionListener(listener);
	}
	
}
