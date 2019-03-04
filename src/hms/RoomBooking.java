package hms;

import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class RoomBooking extends JFrame implements ActionListener
{
	JTable table;
	JPanel p1;
	
	JLabel l_room_no;
	JScrollPane sp;
	JTextField t_room_no;
	JButton b_book;
	public static void main(String[] arg)
	{
		RoomBooking rb=new RoomBooking();
		rb.setVisible(true);
		rb.setSize(1300,780);
	}
	public RoomBooking()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		
		table=new JTable();
		l_room_no=new JLabel("Room number");
		t_room_no=new JTextField();
		b_book=new JButton("BOOK");
		
	//	table.setBounds(100,100,800,500);
		l_room_no.setBounds(1000,100,100,20);
		t_room_no.setBounds(1100, 100, 150, 25);
		b_book.setBounds(1040, 150, 80, 30);
		
	
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from rooms";
			ResultSet rs=st.executeQuery(sql);
	//		table.setModel(DbUtils.resultSetToTableModel(rs));
			table=new JTable(DbUtils.resultSetToTableModel(rs));

			sp=new JScrollPane(table);
			sp.setBounds(100,100,800,500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		add(p1);
		p1.add(sp);
		p1.add(l_room_no);
		p1.add(t_room_no);
		p1.add(b_book);
		
		b_book.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=t_room_no.getText();
		if(s1.isEmpty()==true)
		{
			JOptionPane.showMessageDialog(null, "all fields are required");
		}
		else
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
				Statement st=cn.createStatement();
				String sql="SELECT MAX(ID) AS largestprice FROM `coustmer_id`";
				ResultSet rs=st.executeQuery(sql);
			
				if(rs.next())
				{
					String unique_id=rs.getString("largestprice");
					Check_in ch=new Check_in();
					ch.setVisible(true);
					ch.setSize(1300,780);
					ch.t_room_no.setText(t_room_no.getText());
					ch.t_coustmer_id.setText(unique_id);

				}
				
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
