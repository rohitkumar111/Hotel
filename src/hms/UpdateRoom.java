package hms;

import java.awt.*;
import javax.swing.*;

import mainfame.AdminPanel;
import mainfame.EmployeePanel;
import mainfame.ManagerPanel;
import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener,ItemListener
{
	JLabel l_room_num;
	JTextField t_room_num;
	JButton b_view;
	JTable table;
	JPanel p1;						//``````````````````````````````````````
	
	 JLabel l_room_no,l_room_type,l_charges;
	 JComboBox c_room_type;
	 JTextField t_room_no,t_charges;
	 JButton b_update;
	public static void main(String[] arg)
	{
		UpdateRoom ur=new UpdateRoom();
		ur.setVisible(true);
		ur.setSize(420,600);
	}
	public UpdateRoom()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		l_room_num=new JLabel("Room Number");
		t_room_num=new JTextField();
		b_view=new JButton("View");
		
		
		
		l_room_num.setBounds(1000,100,100,20);
		t_room_num.setBounds(1100, 100, 150, 25);
		b_view.setBounds(1040, 150, 80, 30);
		
		
		add(p1);
		p1.add(l_room_num);
		p1.add(t_room_num);
		p1.add(b_view);
		
		
		
		//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
		
		b_view.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b_view)
		{
			
			String s1=t_room_num.getText();
			if(s1.isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "all fields are required");
			}
			else
			{
				l_room_no=new JLabel("Room_no");
				l_room_type=new JLabel("Room_type");
				l_charges=new JLabel("Charges");
				b_update=new JButton("Update");
				
				t_room_no=new JTextField();
				c_room_type=new JComboBox();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
					
					Statement st=cn.createStatement();
					String sql="select * from room_type";
					ResultSet rs=st.executeQuery(sql);
					while(rs.next())
					{
					String sts=rs.getString("room_type");
					c_room_type.addItem(sts);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				c_room_type.addItemListener(this);
				
				t_charges=new JTextField();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
					
					Statement st=cn.createStatement();
					String sql="SELECT * FROM `rooms` WHERE `Room_no`='"+s1+"'";
					ResultSet rs=st.executeQuery(sql);
					while(rs.next())
					{
					String sts1=rs.getString("Room_no");
					String sts2=rs.getString("charges");

					t_room_no.setText(sts1);
					t_charges.setText(sts2);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			
				l_room_no.setBounds(50, 50, 100, 20);
				l_room_type.setBounds(50, 100, 100, 20);
				l_charges.setBounds(50, 200, 100, 20);
				b_update.setBounds(155, 280, 100, 30);
				
				t_room_no.setBounds(200, 50, 150, 25);
				c_room_type.setBounds(200, 100, 150, 25);

				t_charges.setBounds(200, 200, 150, 25);
				
				add(p1);
				p1.add(l_room_no);
				p1.add(t_room_no);
				p1.add(l_room_type);
				p1.add(c_room_type);
				p1.add(l_charges);
				p1.add(t_charges);
				
				//add(p1);
				p1.add(b_update);
				
				b_update.addActionListener(this);
			}
		}
		//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
		else if(ae.getSource()==b_update)
		{
			String s1=t_room_no.getText();
			String s2=c_room_type.getSelectedItem().toString();
			String s3=t_charges.getText();
			
			if(s1.isEmpty()==true||s2.isEmpty()==true||s3.isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "all fields are required");
			}
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
				    String sql="UPDATE `rooms` SET `Room_no`='"+s1+"',`Room_type`='"+s2+"',`charges`='"+s3+"' WHERE `Room_no`='"+s1+"'";
					PreparedStatement st=cn.prepareStatement(sql);
					int a=st.executeUpdate(sql);       
		
					if(a>0)
					{
						JOptionPane.showMessageDialog(null, "data sucessfully updated...");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "failed...");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void itemStateChanged(ItemEvent e) 
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from room_type where room_type='"+c_room_type.getSelectedItem().toString()+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
			double sts=rs.getDouble("charges");
			t_charges.setText(""+sts);
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
}


