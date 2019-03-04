package adminlogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ChangePassword extends JFrame implements ActionListener
{
	JLabel l_currentPassword,l_newPassword,l_confirmPassword;
	JTextField t_currentPassword,t_newPassword,t_confirmPassword;	
	
	JButton b_reset;
	
	JPanel p1;
	public static void main(String[] arg)
	{
		ChangePassword cp=new ChangePassword();
		cp.setVisible(true);
		cp.setSize(400,400);
	}
	public ChangePassword()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 400, 400);
		l_currentPassword=new JLabel("current password");
		l_newPassword=new JLabel("new password");
		l_confirmPassword=new JLabel("confirm password");
		
		t_currentPassword=new JTextField();
		t_newPassword=new JTextField();
		t_confirmPassword=new JTextField();
		
		b_reset=new JButton("Reset");
		
		l_currentPassword.setBounds(50, 50, 120, 20);
		l_newPassword.setBounds(50, 100, 100, 20);
		l_confirmPassword.setBounds(50, 150, 120, 20);
		
		t_currentPassword.setBounds(200, 50, 150, 25);
		t_newPassword.setBounds(200, 100, 150, 25);
		t_confirmPassword.setBounds(200, 150, 150, 25);
		
		b_reset.setBounds(160,210, 70, 30);
		
		add(p1);
		p1.add(l_currentPassword);
		p1.add(l_newPassword);
		p1.add(l_confirmPassword);
		
		p1.add(t_currentPassword);
		p1.add(t_newPassword);
		p1.add(t_confirmPassword);
		p1.add(b_reset);
		b_reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from admin where password='"+t_currentPassword.getText()+"'";
			ResultSet rs=st.executeQuery(sql);         

			if(rs.next())
			{
				if(t_newPassword.getText()==t_confirmPassword.getText())
				{
					String sql1="UPDATE `admin` SET `password`="+t_currentPassword.getText()+"";
					JOptionPane.showMessageDialog(null, " password changed...");
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
