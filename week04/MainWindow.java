package OOP.week04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainWindow extends FrameWindow implements ActionListener {  
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE = "TextField Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_TITLE = "Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;

    private JButton stopButton;
    private JButton removeTextFieldObserverButton;
    private JButton removeLabelObserverButton;
    private PrimeObservableThread primeThread;
    private TextFieldWindow textFieldWindow;
    private LabelWindow labelWindow;
  

    private boolean isTextBtClicked;
    private boolean isLabelBtClicked;
    
    public MainWindow(String title) {
        super(title, X, Y, WIDTH, HEIGHT);   //Frame Window 상속중!!!
        textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {   	
            @Override
            public void windowClosing(WindowEvent e) {   
                primeThread.stopRunning();
                textFieldWindow.closeWindow();
                labelWindow.closeWindow();
                System.exit(0);
            }	
        });
   
     	primeThread = new PrimeObservableThread(); 
     	primeThread.addObserver(textFieldWindow);
     	primeThread.addObserver(labelWindow);
  		primeThread.run();           // �Ҽ� ���� ����. �� �Լ��� ����� �Ŀ��� stopButton�� ������ ������ ���� �ݺ���
    }

    public JPanel createPanel(int width, int height) {     //abstract 메소드 구현
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        removeTextFieldObserverButton = createButton("remove " + TEXTFIELD_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(removeTextFieldObserverButton);
        removeLabelObserverButton = createButton("remove" + LABEL_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(removeLabelObserverButton);
        stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
        panel.add(stopButton);
        return panel;
    }


    //remove => add => remove �� �Ǿ��ϴϱ� flag ���� �ʿ�
    @Override
    public void actionPerformed(ActionEvent e) {   //Invoker   
        if (e.getSource() == removeTextFieldObserverButton) {
        	if(!isTextBtClicked) {  
        		primeThread.removeObserver(textFieldWindow);
        		isTextBtClicked = true;
                removeTextFieldObserverButton.setText("add " + TEXTFIELD_OBSERVER_BUTTON_TITLE);   
        	}else {
        		primeThread.addObserver(textFieldWindow);
        		isTextBtClicked = false;
                removeTextFieldObserverButton.setText("remove " + TEXTFIELD_OBSERVER_BUTTON_TITLE);    		
        	}
        }
        else if (e.getSource() == removeLabelObserverButton) {
        	if(!isLabelBtClicked) {
        		primeThread.removeObserver(labelWindow);
        	    isLabelBtClicked = true;
                removeLabelObserverButton.setText("add " + LABEL_OBSERVER_BUTTON_TITLE);    	
        	}else {
        		primeThread.addObserver(labelWindow);
        		isLabelBtClicked = false;
        		removeLabelObserverButton.setText("remove " + LABEL_OBSERVER_BUTTON_TITLE);
        	}     
        }
        else if (e.getSource() == stopButton) {
            primeThread.stopRunning();
        }
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / 3);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}
