package hms;

import java.awt.*;
import javax.swing.*;

import mainfame.AdminPanel;
import mainfame.EmployeePanel;
import mainfame.ManagerPanel;
import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class DeleteRoom extends JFrame implements ActionListener
{
	JLabel l_room_no;
	JTextField t_room_no;
	JButton b_view,b_delete;
	JTable table;
	JScrollPane sp;
	JPanel p1;
	public static void main(String[] arg)
	{
		DeleteRoom dr=new DeleteRoom();
		dr.setVisible(true);
		dr.setSize(420,600);
	}
	public DeleteRoom()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		table=new JTable();
		l_room_no=new JLabel("Room number");
		t_room_no=new JTextField();
		b_view=new JButton("View");
		b_delete=new JButton("Delete");
	//	sp=new JScrollPane(table);
	//	table.setBounds(100,100,800,500);
	//	sp.setBounds(100,100,800,500);
		l_room_no.setBounds(1000,100,100,20);
		t_room_no.setBounds(1100, 100, 150, 25);
		b_view.setBounds(1040, 150, 80, 30);
		b_delete.setBounds(1140, 150, 80, 30);
		
		add(p1);
		p1.add(l_room_no);
		p1.add(t_room_no);
		p1.add(b_view);
		p1.add(b_delete);
	//	p1.add(sp);
		

		b_view.addActionListener(this);
		b_delete.addActionListener(this);
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
			if(ae.getSource()==b_delete)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
					Statement st=cn.createStatement();
					String sql="select * from rooms where Room_no='"+s1+"'";
					ResultSet rs=st.executeQuery(sql);         
	
					if(rs.next())
					{
						
						String sql1="DELETE FROM `rooms` WHERE `Room_no`='"+s1+"'";
						PreparedStatement st1=cn.prepareStatement(sql1);
						st1.executeUpdate(sql1);
						JOptionPane.showMessageDialog(null, "Delete");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "invalid room number");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else if(ae.getSource()==b_view)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
					
					Statement st=cn.createStatement();
					String sql="select * from rooms where Room_no='"+s1+"'";
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
				p1.add(sp);

			}
		}
	}
}
