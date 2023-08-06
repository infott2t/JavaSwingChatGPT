package gptcode;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class UsageScreen extends JFrame{

    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel label;
    JPanel labelPanel;

    public UsageScreen(){

        textArea = new JTextArea(10,20);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setText(Utilv1.contents);

        label = new JLabel("--");
        labelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        labelPanel.add(label);

        add(labelPanel, BorderLayout.SOUTH);

        setTitle("Usage Token Screen");
        setSize(200,250);
        setBounds(600,200,400,250);
        add(scrollPane);
        setVisible(true);

        
        Utilv1.addPropertyChangeListener(new PropertyChangeListener() {
         @Override
        public void propertyChange(PropertyChangeEvent evt) {
        if ("contents".equals(evt.getPropertyName())) {
            textArea.setText((String) evt.getNewValue());
            }
            }
        });

        Utilv1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("totalAll".equals(evt.getPropertyName())) {
                    // Update your UI with the new value of totalAll
                    // For example, if you have a label for totalAll:
                    label.setText("Usage total: " + Integer.toString(Utilv1.totalAll));
                }
            }
        });
    
    }

}
