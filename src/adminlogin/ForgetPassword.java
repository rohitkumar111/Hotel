package adminlogin;

import java.awt.*;
import javax.swing.*;

import mainfame.AdminPanel;

import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener
{
	JLabel l_username,l_secqurityQuestion,l_secqurityAnswer;
	JTextField t_username,t_secqurityAnswer;
	JComboBox c_secqurityQuestion;
	
	JButton b_submit;
	
	JPanel p1;
	public static void main(String[] arg)
	{
		ForgetPassword fp=new ForgetPassword();
		fp.setVisible(true);
		fp.setSize(400,400);
	}
	public ForgetPassword()
	{
		c_secqurityQuestion=new JComboBox();
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 400, 400);

		l_username=new JLabel("Username");
		l_secqurityQuestion=new JLabel("Question :- ");
		l_secqurityAnswer=new JLabel("Answer :- ");
		
		c_secqurityQuestion.addItem("your nick name");
		c_secqurityQuestion.addItem("your pet name");
		t_username=new JTextField();
		t_secqurityAnswer=new JTextField();
		
		b_submit=new JButton("submit");
		
		l_username.setBounds(50, 50, 120, 20);
		l_secqurityQuestion.setBounds(50, 100, 120, 20);
		l_secqurityAnswer.setBounds(50, 150, 100, 20);
		
		t_username.setBounds(180, 50, 200, 25);
		c_secqurityQuestion.setBounds(180, 100, 200, 25);
		t_secqurityAnswer.setBounds(180, 150, 200, 25);
	
		
		b_submit.setBounds(180,200, 80, 30);
		
		add(p1);
		p1.add(l_secqurityQuestion);
		p1.add(l_secqurityAnswer);
		p1.add(l_username);
		p1.add(t_username);
		p1.add(c_secqurityQuestion);
		p1.add(t_secqurityAnswer);
		p1.add(b_submit);
		b_submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String textFound1=c_secqurityQuestion.getSelectedItem().toString();
		String textFound2=t_secqurityAnswer.getText();
		String textFound3=t_username.getText();
		if(textFound1.isEmpty()||textFound2.isEmpty()||textFound3.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"all fields are required...");
		}
		else
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
				Statement st=cn.createStatement();
				String sql="select * from admin where security_question='"+c_secqurityQuestion.getSelectedItem().toString()+"' and security_answer='"+t_secqurityAnswer.getText()+"' and username='"+t_username.getText()+"'";
				ResultSet rs=st.executeQuery(sql);         

				if(rs.next())
				{
					JOptionPane.showMessageDialog(null, "password forget...");
					String sts=rs.getString("password");
					
					Login lg=new Login();
					lg.setVisible(true);
					lg.setSize(400,400);
					lg.t_password.setText(sts);
					

					/*if(sts.equals(""))
					{
						JOptionPane.showMessageDialog(null, "login successfully...");
						AdminPanel ap=new AdminPanel();
						ap.setVisible(true);
						ap.setSize(400,400);
					}*/
				}
				else
				{
					JOptionPane.showMessageDialog(null, "pleas fill correct answer...");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
