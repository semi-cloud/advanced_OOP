package OOP.week05;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class LabelPanel {
	private JLabel label;

    public void updateText(String msg) {
        label.setText(msg);
        label.validate();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel();
        panel.add(label);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

}
