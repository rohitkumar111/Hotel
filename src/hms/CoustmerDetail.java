package hms;

import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class CoustmerDetail extends JFrame implements ActionListener
{
	JTable table;
	JPanel p1;
	JScrollPane sp;
	JLabel l_coustmer_Id;
	JTextField t_coustmer_Id;
	JButton b_search;
	public static void main(String[] arg)
	{
		CoustmerDetail cd=new CoustmerDetail();
		cd.setVisible(true);
		cd.setSize(1300,780);
	}
	public CoustmerDetail()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		
		table=new JTable();
		l_coustmer_Id=new JLabel("Coustmer Id");
		t_coustmer_Id=new JTextField();
		b_search=new JButton("search");
		
	//	table.setBounds(100,100,800,500);
		l_coustmer_Id.setBounds(1000,100,100,20);
		t_coustmer_Id.setBounds(1100, 100, 150, 25);
		b_search.setBounds(1040, 150, 80, 30);
		
		add(p1);
		p1.add(table);
		p1.add(l_coustmer_Id);
		p1.add(t_coustmer_Id);
		p1.add(b_search);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from coustmer_payment";
			ResultSet rs=st.executeQuery(sql);
		//	table.setModel(DbUtils.resultSetToTableModel(rs));
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
		p1.add(l_coustmer_Id);
		p1.add(t_coustmer_Id);
		p1.add(b_search);
		
	
		b_search.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=t_coustmer_Id.getText();
		if(s1.isEmpty()==true)
		{
			JOptionPane.showMessageDialog(null, "all fields are required");
		}
		else
		{
			CoustmerFullDetail cfd=new CoustmerFullDetail();
			cfd.setVisible(true);
			cfd.setSize(1300,720);
			cfd.text=s1;
		}
	}
	
}
