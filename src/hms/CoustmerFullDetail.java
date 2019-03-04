package hms;

import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class CoustmerFullDetail extends JFrame implements ActionListener
{
	String text;
	JTable table;
	JPanel p1;
	JButton b_search;
	public static void main(String[] arg)
	{
		CoustmerFullDetail cfd=new CoustmerFullDetail();
		cfd.setVisible(true);
		cfd.setSize(1300,780);
	}
	public CoustmerFullDetail()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		
		table=new JTable();
		
		b_search=new JButton("search");
		
		table.setBounds(20,100,1240,500);
		b_search.setBounds(1040, 150, 80, 30);
		
		add(p1);
		p1.add(table);
		p1.add(b_search);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from 'coustmer' where `coustmer_id`='"+text+"'";
			ResultSet rs=st.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		b_search.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
	}
	
}
