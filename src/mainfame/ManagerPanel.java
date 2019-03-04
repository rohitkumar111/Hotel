package mainfame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import adminlogin.SignUp1;
public class ManagerPanel extends JFrame implements ActionListener
{
	JButton b_signUp;
	JPanel p1;
			public static void main(String[] args) 
			{
				ManagerPanel mp=new ManagerPanel();
				mp.setSize(400, 400);
				mp.setVisible(true);

			}
			public ManagerPanel()
			{
			    p1=new JPanel();
				p1.setLayout(null);
				p1.setBounds(0, 0, 400, 400);
				b_signUp=new JButton("Sign Up");
				
				b_signUp.setBounds(120, 30, 80, 30);
				
				add(p1);
				p1.add(b_signUp);
				b_signUp.addActionListener(this);
				
			}
			public void actionPerformed(ActionEvent ae)
			{
			    if(ae.getSource()==b_signUp)
				{
					SignUp1 sp1=new SignUp1();
					sp1.setVisible(true);
					sp1.setSize(400,400);
				}
			}
}
