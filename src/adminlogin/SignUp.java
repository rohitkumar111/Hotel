package adminlogin;

import java.awt.*;
import javax.swing.*;

import mainfame.ControlPanel;

import java.awt.event.*;
import java.sql.*;

public class SignUp	extends JFrame implements ActionListener
{
	JLabel l_name,l_contact,l_username,l_password,l_securityQuestion,l_securityAnswer,l_emailId,l_status;
	JTextField t_name,t_contact,t_username,t_password,t_securityAnswer,t_emailId;
	JComboBox c_securityQuestion;
	JButton b_login;
	JComboBox c_status;
	JPanel p1;

	public static void main(String[] args)
	{
		SignUp siup=new SignUp();
		siup.setVisible(true);
		siup.setSize(400,500);
	}
	public SignUp()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 400, 500);
		l_name=new JLabel("name");
		l_contact=new JLabel("contact");
		l_emailId=new JLabel("email id");
		l_username=new JLabel("Username");
		l_password=new JLabel("Password");
		l_securityQuestion=new JLabel("Question :- ");
		l_securityAnswer=new JLabel("Answer");
		l_status=new JLabel("Status");
		t_name=new JTextField();
		t_contact=new JTextField();
		t_emailId=new JTextField();
		t_username=new JTextField();
		t_password=new JTextField();
		t_securityAnswer=new JTextField();
		b_login=new JButton("Login");
		
		c_status=new JComboBox();
		c_status.addItem("Admin");
		c_status.addItem("Manager");
		c_status.addItem("Employee");
		
		c_securityQuestion=new JComboBox();
		c_securityQuestion.addItem("your nick name");
		c_securityQuestion.addItem("your pet name");
		
		l_name.setBounds(50, 50, 100, 20);
		l_contact.setBounds(50, 100, 100, 20);
		l_emailId.setBounds(50, 150, 100, 20);
		l_status.setBounds(50, 200, 100, 20);
		l_username.setBounds(50, 250, 100, 20);
		l_password.setBounds(50, 300, 100, 20);
		l_securityQuestion.setBounds(50, 350, 100, 20);
		l_securityAnswer.setBounds(50, 400, 100, 20);
		
		t_name.setBounds(200, 50, 150, 25);
		t_contact.setBounds(200, 100, 150, 25);
		t_emailId.setBounds(200, 150, 150, 25);
		c_status.setBounds(200, 200, 150, 25);
		t_username.setBounds(200, 250, 150, 25);
		t_password.setBounds(200, 300, 150, 25);
		c_securityQuestion.setBounds(200, 350, 150, 25);
		t_securityAnswer.setBounds(200, 400, 150, 25);
		b_login.setBounds(170, 450, 80, 35);
		
		add(p1);
		p1.add(l_name);
		p1.add(t_name);
		p1.add(l_contact);
		p1.add(t_contact);
		p1.add(l_emailId);
		p1.add(t_emailId);
		p1.add(l_username);
		p1.add(t_username);
		p1.add(l_password);
		p1.add(t_password);
		p1.add(l_securityQuestion);
		p1.add(c_securityQuestion);
		p1.add(l_securityAnswer);
		p1.add(t_securityAnswer);
		p1.add(b_login);
		p1.add(l_status);
		p1.add(c_status);
		b_login.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String textFound1=t_name.getText();
		String textFound2=t_contact.getText();
		String textFound3=t_emailId.getText();
		String textFound4=t_username.getText();
		String textFound5=t_password.getText();
		String textFound6=c_securityQuestion.getSelectedItem().toString();
		String textFound7=t_securityAnswer.getText();
		String textFound8=c_status.getSelectedItem().toString();
		
		if(textFound1.isEmpty()||textFound2.isEmpty()||textFound3.isEmpty()||textFound4.isEmpty()||textFound5.isEmpty()||textFound6.isEmpty()||textFound7.isEmpty()||textFound8.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"are fields are required...");
		}
		else
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
	
			    String sql="INSERT INTO admin(name,contact,email_id,username,password,security_question,security_answer,status) VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement st=cn.prepareStatement(sql);
				
				
				st.setString(1, t_name.getText());
				st.setString(2, t_contact.getText());
				st.setString(3, t_emailId.getText());
				st.setString(4, t_username.getText());
				st.setString(5, t_password.getText());
				st.setString(6, c_securityQuestion.getSelectedItem().toString());
				st.setString(7, t_securityAnswer.getText());
				st.setString(8, c_status.getSelectedItem().toString());
				int a=st.executeUpdate();      
	
				if(a>0)
				{
					JOptionPane.showMessageDialog(null, "data inserted sucessfully...");
					/*ControlPanel cpl=new ControlPanel();
					cpl.setSize(400, 400);
					cpl.setVisible(true);*/
				}
				else
				{
					JOptionPane.showMessageDialog(null, "data failed");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	
}
