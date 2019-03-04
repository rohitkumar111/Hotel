package hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Employee extends JFrame implements ActionListener
{
	JLabel l_employee_id,l_name,l_age,l_mobile_no,l_email_id,l_joining_date,l_salary,l_status;
	JTextField t_employee_id,t_name,t_age,t_mobile_no,t_email_id,t_joining_date,t_salary,t_status;
	JButton b_submit;
	
	JPanel p1;
	public static void main(String[] arg)
	{
		Employee emb=new Employee();
		emb.setVisible(true);
		emb.setSize(420,600);
	}
	public Employee()
	{
		//setLayout(new FlowLayout());
		p1=new JPanel();
		p1.setBackground(Color.red);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		
		l_employee_id=new JLabel("employee_id");
		l_name=new JLabel("name");
		l_status=new JLabel("Status");
		l_age=new JLabel("age");
		l_mobile_no=new JLabel("mobile_no");
		l_email_id=new JLabel("email_id");
		l_joining_date=new JLabel("joining_date");
		l_salary=new JLabel("salary");
		b_submit=new JButton("submit");
		
		t_status=new JTextField();
		t_employee_id=new JTextField();
		t_name=new JTextField();
		t_age=new JTextField();
		t_mobile_no=new JTextField();
		t_email_id=new JTextField();
		t_joining_date=new JTextField();
		t_salary=new JTextField();
		
		l_name.setBounds(50, 50, 100, 20);
		l_status.setBounds(50, 100, 100, 20);
		l_employee_id.setBounds(50, 150, 100, 20);
		l_age.setBounds(50, 200, 100, 20);
		l_mobile_no.setBounds(50, 250, 100, 20);
		l_email_id.setBounds(50, 300, 100, 20);
		l_joining_date.setBounds(50, 350, 100, 20);
		l_salary.setBounds(50,400,100,20);
		b_submit.setBounds(140, 480, 100, 30);
		
		
		t_name.setBounds(200, 50, 150, 25);
		t_status.setBounds(200, 100, 150, 25);
		t_employee_id.setBounds(200, 150, 150, 25);
		t_age.setBounds(200, 200, 150, 25);
		t_mobile_no.setBounds(200, 250, 150, 25);
		t_email_id.setBounds(200, 300, 150, 25);;
		t_joining_date.setBounds(200, 350, 150, 25);
		t_salary.setBounds(200, 400, 150, 25);
	
		
		add(p1);
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
		p1.add(b_submit);
		b_submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
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
			if(s1.length()<=10)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
				    String sql="INSERT INTO `employees`(`employee_id`, `name`, `age`, `mobile_no`, `email_id`, `status`, `joining_date`, `salary`) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
					PreparedStatement st=cn.prepareStatement(sql);
					
					int i=1+Integer.parseInt(s1);
					String sql2="INSERT INTO `coustmer_id`(`id`) VALUES ('"+i+"')";
					PreparedStatement st2=cn.prepareStatement(sql2);
					
					int b=st2.executeUpdate(sql2); 
					int a=st.executeUpdate(sql);       
		
					if(a>0 && b>0)
					{
						JOptionPane.showMessageDialog(null, "data inserted sucessfully...");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "data failed");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "invalid employee id");
			}
		}
		
	}

}

