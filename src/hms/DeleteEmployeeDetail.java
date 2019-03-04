package hms;

import java.awt.*;
import javax.swing.*;

import mainfame.AdminPanel;
import mainfame.EmployeePanel;
import mainfame.ManagerPanel;
import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class DeleteEmployeeDetail extends JFrame implements ActionListener
{
	JLabel l_employeeId;
	JTextField t_employeeId;
	JButton b_view,b_delete;
	JTable table;
	JScrollPane sp;
	JPanel p1;
	public static void main(String[] arg)
	{
		DeleteEmployeeDetail ded=new DeleteEmployeeDetail();
		ded.setVisible(true);
		ded.setSize(420,600);
	}
	public DeleteEmployeeDetail()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		table=new JTable();
		l_employeeId=new JLabel("Emoployee Id");
		t_employeeId=new JTextField();
		b_view=new JButton("View");
		b_delete=new JButton("Delete");
		
	//	table.setBounds(100,100,800,500);
		l_employeeId.setBounds(1000,100,100,20);
		t_employeeId.setBounds(1100, 100, 150, 25);
		b_view.setBounds(1040, 150, 80, 30);
		b_delete.setBounds(1140, 150, 80, 30);
		
		add(p1);
		p1.add(l_employeeId);
		p1.add(t_employeeId);
		p1.add(b_view);
		p1.add(b_delete);
	//	p1.add(table);

		b_view.addActionListener(this);
		b_delete.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=t_employeeId.getText();
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
					String sql="select * from employees where employee_id='"+s1+"'";
					ResultSet rs=st.executeQuery(sql);         
	
					if(rs.next())
					{
						
						String sql1="DELETE FROM `employees` WHERE `employee_id`='"+s1+"'";
						PreparedStatement st1=cn.prepareStatement(sql1);
						st1.executeUpdate(sql1);
						JOptionPane.showMessageDialog(null, "Delete");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "invalid employee id");
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
					String sql="select * from employees where employee_id='"+s1+"'";
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
