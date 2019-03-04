package hms;

import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class EmployeeDetail extends JFrame implements ActionListener
{
	JTable table;
	JScrollPane sp;
	JPanel p1;
	JButton b_addEmployee,b_deleteEmployee,b_updateEmployee;
	public static void main(String[] arg)
	{
		EmployeeDetail ed=new EmployeeDetail();
		ed.setVisible(true);
		ed.setSize(1300,780);
	}
	public EmployeeDetail()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		
		table=new JTable();
		b_addEmployee=new JButton("ADD Employee");
		b_deleteEmployee=new JButton("DELETE Employee");
		b_updateEmployee=new JButton("UPDATE Employee");
		
	//	table.setBounds(100,100,800,500);
		b_addEmployee.setBounds(1000, 100, 120, 30);
		b_deleteEmployee.setBounds(1000, 150, 120, 30);
		b_updateEmployee.setBounds(1000, 200, 120, 30);
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from employees";
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
		p1.add(b_addEmployee);
		p1.add(b_deleteEmployee);
		p1.add(b_updateEmployee);
		
		b_addEmployee.addActionListener(this);
		b_deleteEmployee.addActionListener(this);
		b_updateEmployee.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b_addEmployee)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
				Statement st=cn.createStatement();
				String sql="SELECT MAX(ID) AS employeeId FROM `coustmer_id`";
				ResultSet rs=st.executeQuery(sql);
			
				if(rs.next())
				{
					String unique_id=rs.getString("employeeId");
					Employee emb=new Employee();
					emb.setVisible(true);
					emb.setSize(420,600);
					emb.t_employee_id.setText(unique_id);

				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b_deleteEmployee)
		{
			DeleteEmployeeDetail ded=new DeleteEmployeeDetail();
			ded.setVisible(true);
			ded.setSize(1300,780);
		}
		else if(ae.getSource()==b_updateEmployee)
		{
			UpdateEmployeeDetail ued=new UpdateEmployeeDetail();
			ued.setVisible(true);
			ued.setSize(420,600);
		}
	}
	
}
