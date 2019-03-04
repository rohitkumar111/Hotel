package hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CheckOut extends JFrame implements ActionListener
{
	    JLabel l_room_no,l_coustmer_id,l_date,l_name;
		JTextField t_room_no,t_coustmer_id,t_date,t_name;
		JButton b_submit;
		JPanel p1;
		public static void main(String[] arg)
		{
	
			CheckOut co=new CheckOut();
			co.setVisible(true);
			co.setSize(220,600);
		}
		public CheckOut()
		{
			p1=new JPanel();
		//	p1.setBackground(Color.);
			p1.setLayout(null);
			p1.setBounds(0, 0, 300, 200);
			l_room_no=new JLabel("Room no");
			l_coustmer_id=new JLabel("Coustmer Id");
			l_date=new JLabel("Date");
			l_name=new JLabel("Name");
			b_submit=new JButton("Check Out");
			
			t_room_no=new JTextField();
			t_coustmer_id=new JTextField();
			t_date=new JTextField();
			t_name=new JTextField();
			
		
			l_name.setBounds(50, 50, 100, 20);
			l_coustmer_id.setBounds(50, 100, 100, 20);
			l_room_no.setBounds(50, 150, 100, 20);
			l_date.setBounds(50, 200, 100, 20);
			b_submit.setBounds(155, 280, 100, 30);
			
			t_name.setBounds(200, 50, 150, 25);
			t_coustmer_id.setBounds(200, 100, 150, 25);
			t_room_no.setBounds(200, 150, 150, 25);
			t_date.setBounds(200, 200, 150, 25);
			
			add(p1);
			p1.add(l_room_no);
			p1.add(t_room_no);
			p1.add(l_date);
			p1.add(t_date);
			p1.add(l_coustmer_id);
			p1.add(t_coustmer_id);
			p1.add(l_name);
			p1.add(t_name);
			
			p1.add(b_submit);
			b_submit.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			String s1=t_name.getText();
			String s2=t_coustmer_id.getText();
			String s3=t_room_no.getText();
			String s4=t_date.getText();
		
			if(s1.isEmpty()==true||s2.isEmpty()==true||s3.isEmpty()==true||s4.isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "all fields are required");
			}
			else
			{ 
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
					
					String sql="INSERT INTO `check_out`(`name`, `coustmer_id`, `room_no`,`check_out`) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
					PreparedStatement st=cn.prepareStatement(sql);
					int a=st.executeUpdate(sql);   
	
					if(a>0)
					{
						try
						{
							
							String booking="AVAILABLE";
						    String sql2="UPDATE `rooms` SET `Booking`='"+booking+"' WHERE `Room_no`='"+s3+"'";
							PreparedStatement st2=cn.prepareStatement(sql2);
							st2.executeUpdate(sql2);
				
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "room added sucessfully...");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "failed");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
}
		