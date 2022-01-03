package OOP.week04;

import javax.swing.*;
import java.awt.*;


public class TextFieldWindow extends FrameWindow implements Observer {  
	
    private JTextField textField;

    public TextFieldWindow(String title, int x, int y, int width, int height) {
        super(title, x, y, width, height);
    }
    
    public void updateText(String msg) {    //실제 업데이트된게 적용되는 부분
        textField.setText(msg); 
        textField.validate();
    }
   

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        panel.add(textField);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

	@Override
	public void update(int num) {    //정보가 들어오고, 업데이트해주기
		updateText("" + num);		
	}
}
