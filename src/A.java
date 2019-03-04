import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A {
  public static void main(final String args[]) {
    JFrame frame = new JFrame("Formatted Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel datePanel = new JPanel(new BorderLayout());
    DateFormat format = new SimpleDateFormat("yyyy--MMMM--dd");
    JFormattedTextField dateTextField = new JFormattedTextField(format);
    datePanel.add(dateTextField, BorderLayout.CENTER);
    frame.add(datePanel, BorderLayout.NORTH);

    frame.add(new JTextField(), BorderLayout.SOUTH);
    frame.setSize(250, 100);
    frame.setVisible(true);
  }
}
