package OOP.week12;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class CalcGUIV1 extends JFrame implements ActionListener {      //Invoker(리모컨과 같은 역할)
    final static int WINDOW_WIDTH = 400;
    final static int WINDOW_HEIGHT = 300;
    final static int COMPONENT_HEIGHT = 40;
    final static int BUTTON_WIDTH = 50;

    String[] buttonText = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=" };
    //JButton[] buttons = new JButton[buttonText.length];
    CommandButton[] buttons = new CommandButton[buttonText.length];
    Calculator calculator;
    NumberButtonCommand numberButtonCommand;
    OperatorButtonCommand operatorButtonCommand;
    EqualButtonCommand equalButtonCommand;
    

    Dimension displayDimension = new Dimension(WINDOW_WIDTH - 20, COMPONENT_HEIGHT);
    Dimension buttonDimension = new Dimension(BUTTON_WIDTH, COMPONENT_HEIGHT);

    JLabel display = new JLabel(); // 숫자 값 및 결과 출력 화면

    CalcGUIV1() {
        super("CalcGUIV1");
        calculator = new Calculator();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Font labelFont = display.getFont();
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font(labelFont.getName(), Font.PLAIN, COMPONENT_HEIGHT - 5));
        display.setPreferredSize(new Dimension(displayDimension));
        setResizable(false);
        setLayout(new BorderLayout());
        add(getDisplayPanel(), BorderLayout.NORTH);
        add(getButtonPanel(), BorderLayout.CENTER);
        clear();
    }

    public JPanel getDisplayPanel() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        displayPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        displayPanel.setPreferredSize(displayDimension);
        displayPanel.add(display);
        return displayPanel;
    }
    
    public JPanel getButtonPanel() {     //버튼이 생성되는 부분
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,3,10,5));
        for (int i = 0; i < 10; i++) {
            buttons[i] = new NumberButtonCommand(display, calculator);
            buttons[i].setButton(buttons, i, this, buttonDimension); 
            /*Version2
            buttons[i] = new NumberButtonCommand(calculator);
            buttons[i].setText(buttonText[i]);
            buttons[i].setPreferredSize(buttonDimension);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
             * 
             */
            buttonPanel.add(buttons[i]); 
        }
        for (int i = 10; i < 14 ; i++) {
            buttons[i] = new OperatorButtonCommand(calculator);
            buttons[i].setButton(buttons, i, this, buttonDimension);        
            buttonPanel.add(buttons[i]);
        }
       
        buttons[14] = new EqualButtonCommand(display, calculator);
        buttons[14].setButton(buttons, 14, this, buttonDimension);
        buttonPanel.add(buttons[14]);
        return buttonPanel;
    }
    
    public void showText(String text) {   //Version2(여기서 setText)
    	display.setText(text);
    }

    public void clear() {
        display.setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent e) { 	    //Invoker
    	if(e.getSource() instanceof Command) {
    		((Command)e.getSource()).execute();       
    	}
    	/* Version 2 
    	 * if(e.getSource() instanceof CommandButton) {
    		((CommandButton)e.getSource()).execute();
    	}
    	 * 
    	 */
    }

    public static void main(String[] args) {
        CalcGUIV1 c = new CalcGUIV1();
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}

