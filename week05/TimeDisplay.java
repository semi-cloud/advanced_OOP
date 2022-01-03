package OOP.week05;

import java.awt.Dimension;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TimeDisplay extends DisplayDecorator {
	
	private Display display;       // HudDisplay
	private LabelPanel labelPanel;

	public TimeDisplay(Display display, int width, int height) {
		super( width, height);
		this.display = display;		
		labelPanel = new LabelPanel();
	}

	@Override
	public JPanel create() {
		JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setMinimumSize(new Dimension(getWidth(), getHeight()));
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
       
        //1.기존에 있던거 붙이기
        panel.add(display.create());
        //2.새로운 label 붙이기
		panel.add(labelPanel.createPanel(getWidth(), getHeight()));
		
		return panel;
	}

	@Override
	public void show() {
		display.show();
		labelPanel.updateText(LocalDate.now().toString());			
	}
	
	public int getHeight() {
		return display.getHeight() + super.getHeight();
	}

}
