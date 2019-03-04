package hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener,ItemListener
{
	    JLabel l_room_no,l_room_type,l_charges;
	    JComboBox c_room_type;
		JTextField t_room_no,t_charges;
		JButton b_submit;
		JPanel p1;
		public static void main(String[] arg)
		{
	
			Room emb=new Room();
			emb.setVisible(true);
			emb.setSize(220,600);
		}
		public Room()
		{
			p1=new JPanel();
		//	p1.setBackground(Color.);
			p1.setLayout(null);
			p1.setBounds(0, 0, 300, 200);
			l_room_no=new JLabel("Room_no");
			l_room_type=new JLabel("Room_type");
			l_charges=new JLabel("Charges");
			b_submit=new JButton("submit");
			
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
		
			l_room_no.setBounds(50, 50, 100, 20);
			l_room_type.setBounds(50, 100, 100, 20);
			l_charges.setBounds(50, 200, 100, 20);
			b_submit.setBounds(155, 280, 100, 30);
			
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
			
			add(p1);
			p1.add(b_submit);
			b_submit.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			String s1=t_room_no.getText();
			String s2=c_room_type.getSelectedItem().toString();
		
			String s4=t_charges.getText();
			String s5="AVAILABLE";
			if(s1.isEmpty()==true||s2.isEmpty()==true||s4.isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "all fields are required");
			}
			else
			{ 
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
					
					String sql="INSERT INTO `rooms`(`room_no`, `room_type`, `charges`,`Booking`) VALUES ('"+s1+"','"+s2+"','"+s4+"','"+s5+"')";
				
					PreparedStatement st=cn.prepareStatement(sql);
					
					int a=st.executeUpdate(sql);  System.out.println(a);       
	
					if(a>0)
					{
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
