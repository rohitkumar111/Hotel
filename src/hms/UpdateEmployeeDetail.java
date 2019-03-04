package hms;

import java.awt.*;
import javax.swing.*;

import mainfame.AdminPanel;
import mainfame.EmployeePanel;
import mainfame.ManagerPanel;
import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class UpdateEmployeeDetail extends JFrame implements ActionListener
{
	JLabel l_employeeId;
	JTextField t_employeeId;
	JButton b_view;
	JPanel p1;							//``````````````````````````````````````
	
	JLabel l_employee_id,l_name,l_age,l_mobile_no,l_email_id,l_joining_date,l_salary,l_status;
	JTextField t_employee_id,t_name,t_age,t_mobile_no,t_email_id,t_joining_date,t_salary,t_status;
	JButton b_update;
	public static void main(String[] arg)
	{
		UpdateEmployeeDetail ued=new UpdateEmployeeDetail();
		ued.setVisible(true);
		ued.setSize(420,600);
	}
	public UpdateEmployeeDetail()
	{
		p1=new JPanel();
		//p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		l_employeeId=new JLabel("Emoployee Id");
		t_employeeId=new JTextField();
		b_view=new JButton("View");
		
		
		
		l_employeeId.setBounds(1000,100,100,20);
		t_employeeId.setBounds(1100, 100, 150, 25);
		b_view.setBounds(1040, 150, 80, 30);
		
		
		add(p1);
		p1.add(l_employeeId);
		p1.add(t_employeeId);
		p1.add(b_view);
		
		
		
		//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
		
		
	//	b_update.addActionListener(this);
		b_view.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b_view)
		{
			
			String s1=t_employeeId.getText();
			if(s1.isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "all fields are required");
			}
			else
			{
					l_employee_id=new JLabel("employee_id");
					l_name=new JLabel("name");
					l_status=new JLabel("Status");
					l_age=new JLabel("age");
					l_mobile_no=new JLabel("mobile_no");
					l_email_id=new JLabel("email_id");
					l_joining_date=new JLabel("joining_date");
					l_salary=new JLabel("salary");
					b_update=new JButton("Update");
					
					t_status=new JTextField();
					t_employee_id=new JTextField();
					t_name=new JTextField();
					t_age=new JTextField();
					t_mobile_no=new JTextField();
					t_email_id=new JTextField();
					t_joining_date=new JTextField();
					t_salary=new JTextField();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
						
						Statement st=cn.createStatement();
						String sql="SELECT * FROM `employees` WHERE `employee_id`='"+s1+"'";
						ResultSet rs=st.executeQuery(sql);
						while(rs.next())
						{
						String sts1=rs.getString("employee_id");
						String sts2=rs.getString("name");
						String sts3=rs.getString("age");
						String sts4=rs.getString("mobile_no");
						String sts5=rs.getString("email_id");
						String sts6=rs.getString("status");
						String sts7=rs.getString("joining_date");
						String sts8=rs.getString("salary");
				
						t_employee_id.setText(sts1);
						t_name.setText(sts2);
						t_age.setText(sts3);
						t_mobile_no.setText(sts4);
						t_email_id.setText(sts5);
						t_status.setText(sts6);
						t_joining_date.setText(sts7);
						t_salary.setText(sts8);
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					l_name.setBounds(50, 50, 100, 20);
					l_status.setBounds(50, 100, 100, 20);
					l_employee_id.setBounds(50, 150, 100, 20);
					l_age.setBounds(50, 200, 100, 20);
					l_mobile_no.setBounds(50, 250, 100, 20);
					l_email_id.setBounds(50, 300, 100, 20);
					l_joining_date.setBounds(50, 350, 100, 20);
					l_salary.setBounds(50,400,100,20);
					b_update.setBounds(140, 480, 100, 30);
					
					
					t_name.setBounds(200, 50, 150, 25);
					t_status.setBounds(200, 100, 150, 25);
					t_employee_id.setBounds(200, 150, 150, 25);
					t_age.setBounds(200, 200, 150, 25);
					t_mobile_no.setBounds(200, 250, 150, 25);
					t_email_id.setBounds(200, 300, 150, 25);;
					t_joining_date.setBounds(200, 350, 150, 25);
					t_salary.setBounds(200, 400, 150, 25);
				
					
					
					p1.add(l_name);
					p1.add(t_name);
					p1.add(l_status);
					p1.add(t_status);
					p1.add(l_employee_id);
					p1.add(t_employee_id);
					p1.add(l_age);
					p1.add(t_age);
					p1.add(l_mobile_no);
					p1.add(t_mobile_no);
					p1.add(l_email_id);
					p1.add(t_email_id);
					
					p1.add(l_joining_date);
					p1.add(t_joining_date);
					p1.add(l_salary);
					p1.add(t_salary);
					p1.add(b_update);
					b_update.addActionListener(this);
			}
		}
		//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
		else if(ae.getSource()==b_update)
		{
			String s1=t_employee_id.getText();
			String s2=t_name.getText();
			String s3=t_age.getText();
			String s4=t_mobile_no.getText();
			String s5=t_email_id.getText();
			String s6=t_status.getText();
			String s7=t_joining_date.getText();
			String s8=t_salary.getText();
			
			if(s1.isEmpty()==true||s2.isEmpty()==true||s3.isEmpty()==true||s4.isEmpty()==true||s5.isEmpty()==true||s6.isEmpty()==true||s7.isEmpty()==true||s8.isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "all fields are required");
			}
			else
			{
				if(s1.length()==10)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
					
					    String sql="UPDATE `employees` SET `employee_id`='"+s1+"',`name`='"+s2+"',`age`='"+s3+"',`mobile_no`='"+s4+"',`email_id`='"+s5+"',`status`='"+s6+"',`joining_date`='"+s7+"',`salary`='"+s8+"' WHERE `employee_id`='"+s1+"'";
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
				else
				{
					JOptionPane.showMessageDialog(null, "invalid emoloyee id");
				}
			}
		}
	}
}





