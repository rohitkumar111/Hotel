package hms;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class Roomdetail extends JFrame implements ActionListener
{
	JTable table;
	JPanel p1;
	JScrollPane sp;
	JButton b_addRoom,b_deleteRoom,b_updateRoom;
	public static void main(String[] arg)
	{
		Roomdetail ed=new Roomdetail();
		ed.setVisible(true);
		ed.setSize(1300,780);
	}
	public Roomdetail()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		
		b_addRoom=new JButton("ADD ROOM");
		b_deleteRoom=new JButton("DELETE ROOM");
		b_updateRoom=new JButton("UPDATE ROOM");
		

		b_addRoom.setBounds(1000, 100, 120, 30);
		b_deleteRoom.setBounds(1000, 150, 120, 30);
		b_updateRoom.setBounds(1000, 200, 120, 30);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from rooms";
			ResultSet rs=st.executeQuery(sql);
			
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
		p1.add(b_addRoom);
		p1.add(b_deleteRoom);
		p1.add(b_updateRoom);
		
		b_addRoom.addActionListener(this);
		b_deleteRoom.addActionListener(this);
		b_updateRoom.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b_addRoom)
		{
			Room emb=new Room();
			emb.setVisible(true);
			emb.setSize(1300,780);
		}
		else if(ae.getSource()==b_deleteRoom)
		{
			DeleteRoom dr=new DeleteRoom();
			dr.setVisible(true);
			dr.setSize(420,600);
		}
		else if(ae.getSource()==b_updateRoom)
		{
			UpdateRoom ur=new UpdateRoom();
			ur.setVisible(true);
			ur.setSize(420,600);
		}
	}
	
}
