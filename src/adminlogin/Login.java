package adminlogin;

import java.awt.*;
import javax.swing.*;

import mainfame.*;

import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	JLabel l_username,l_password,l_status;
	JTextField t_username,t_password;
	JButton b_login,b_f_pass,b_c_pass,b_signUp;
	JComboBox c_status;
	JPanel p1;

	public static void main(String[] args)
	{
		Login lg=new Login();
		lg.setVisible(true);
		lg.setSize(400,400);
	}
	public Login()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 400, 400);
		l_username=new JLabel("Username");
		l_password=new JLabel("Password");
	//	l_status=new JLabel("status");
		t_username=new JTextField();
		t_password=new JTextField();
		b_login=new JButton("Login");
		b_f_pass=new JButton("forget");
	//	b_c_pass=new JButton("change password");
	//	b_signUp=new JButton("Sign Up");
	/*	c_status=new JComboBox();
		c_status.addItem("admin");
		c_status.addItem("manager");
		c_status.addItem("employee");*/
		
	//	l_status.setBounds(50, 50, 100, 20);
	//	c_status.setBounds(200, 50, 150, 25);
		l_username.setBounds(50, 100, 100, 20);
		l_password.setBounds(50, 150, 100, 20);
		t_username.setBounds(200, 100, 150, 25);
		t_password.setBounds(200, 150, 150, 25);
		b_login.setBounds(50, 210, 70, 30);
		b_f_pass.setBounds(130, 210, 70, 30);
	//	b_c_pass.setBounds(210, 210, 140, 30);
	//	b_signUp.setBounds(1200, 30, 80, 30);
		
		add(p1);
	//	p1.add(l_status);
	//	p1.add(c_status);
		p1.add(l_username);
		p1.add(t_username);
		p1.add(l_password);
		p1.add(t_password);
		p1.add(b_login);
		p1.add(b_f_pass);
	//	p1.add(b_c_pass);
	//	p1.add(b_signUp);
		b_login.addActionListener(this);
		b_f_pass.addActionListener(this);
		//b_c_pass.addActionListener(this);
	//	b_signUp.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b_login)
		{
			String textFound1=t_username.getText();
			String textFound2=t_password.getText();
			if(textFound1.isEmpty()||textFound2.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"are fields are required...");
			}
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
					Statement st=cn.createStatement();
					String sql="select * from admin where username='"+t_username.getText()+"' and password='"+t_password.getText()+"'";
					ResultSet rs=st.executeQuery(sql);         
	
					if(rs.next())
					{
						String sts=rs.getString("status");

						if(sts.equals("Admin"))
						{
							JOptionPane.showMessageDialog(null, "login successfully...");
							AdminPanel ap=new AdminPanel();
							ap.setVisible(true);
							ap.setSize(400,400);
						}
						if(sts.equals("Manager"))
						{
							JOptionPane.showMessageDialog(null, "login successfully...");
							ManagerPanel mp=new ManagerPanel();
							mp.setSize(400, 400);
							mp.setVisible(true);
						}
						if(sts.equals("Employee"))
						{
							JOptionPane.showMessageDialog(null, "login successfully...");
							EmployeePanel ep=new EmployeePanel();
							ep.setSize(400, 400);
							ep.setVisible(true);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "invalid username and password...");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(ae.getSource()==b_f_pass)
		{
			ForgetPassword fp=new ForgetPassword();
			fp.setSize(400, 400);
			fp.setVisible(true);
		}
		/*else if(ae.getSource()==b_c_pass)
		{
			ChangePassword cp=new ChangePassword();
			cp.setVisible(true);
			cp.setSize(400,400);
		}
		else if(ae.getSource()==b_signUp)
		{
			SignUp sp=new SignUp();
			sp.setVisible(true);
			sp.setSize(400,400);
		}*/
	}
}

