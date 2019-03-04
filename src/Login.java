import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	JLabel l_username,l_password;
	JTextField t_username,t_password;
	JButton b_login;

	public static void main(String[] args)
	{
		Login lg=new Login();
		lg.setVisible(true);
		lg.setSize(200,200);
	}
	public Login()
	{
		setLayout(new FlowLayout());
		l_username=new JLabel("Username");
		l_password=new JLabel("Password");
		t_username=new JTextField(10);
		t_password=new JTextField(10);
		b_login=new JButton("Login");
		
		add(l_username);
		add(t_username);
		add(l_password);
		add(t_password);
		add(b_login);
		b_login.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from admin where username='"+t_username.getText()+"' and password='"+t_password.getText()+"'";
			ResultSet rs=st.executeQuery(sql);         

			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "login sucessfully....");
			//	Employee em=new Employee();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "invalid username and password...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

//--------------------------------------employees_data-------------------------------------------

class Employee extends JFrame implements ActionListener
{
	JLabel l_employee_id,l_name,l_age,l_mobile_no,l_email_id,l_position,l_joining_date,l_salary;
	JTextField t_employee_id,t_name,t_age,t_mobile_no,t_email_id,t_position,t_joining_date,t_salary;
	JButton b_submit;
	public static void main(String[] arg)
	{
		Employee emb=new Employee();
		emb.setVisible(true);
		emb.setSize(220,600);
	}
	public Employee()
	{
		setLayout(new FlowLayout());
		
		l_employee_id=new JLabel("employee_id");
		l_name=new JLabel("name");
		l_age=new JLabel("age");
		l_mobile_no=new JLabel("mobile_no");
		l_email_id=new JLabel("email_id");
		l_position=new JLabel("postion");
		l_joining_date=new JLabel("joining_date");
		l_salary=new JLabel("salary");
		b_submit=new JButton("submit");
		
		t_employee_id=new JTextField(10);
		t_name=new JTextField(10);
		t_age=new JTextField(10);
		t_mobile_no=new JTextField(10);
		t_email_id=new JTextField(10);
		t_position=new JTextField(10);
		t_joining_date=new JTextField(10);
		t_salary=new JTextField(10);
		
		add(l_name);
		add(t_name);
		add(l_employee_id);
		add(t_employee_id);
		add(l_age);
		add(t_age);
		add(l_mobile_no);
		add(t_mobile_no);
		add(l_email_id);
		add(t_email_id);
		add(l_position);
		add(t_position);
		add(l_joining_date);
		add(t_joining_date);
		add(l_salary);
		add(t_salary);
		add(b_submit);
		b_submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=t_employee_id.getText();
		String s2=t_name.getText();
		String s3=t_age.getText();
		String s4=t_mobile_no.getText();
		String s5=t_email_id.getText();
		String s6=t_position.getText();
		String s7=t_joining_date.getText();
		String s8=t_salary.getText();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			//String sql="INSERT INTO `employees`(`employee_id`, `name`, `age`, `mobile_no`, `email_id`, `position`, `joining_date`, `salary`) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
		    	String sql="INSERT INTO `employees`(`employee_id`, `name`, `age`, `mobile_no`, `email_id`, `position`, `joining_date`, `salary`) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
			PreparedStatement st=cn.prepareStatement(sql);
			
			//st.setString(1, t_employee_id.getText());
		//	st.setString(2, t_name.getText());
		/*	st.setString(3, t_age.getText());
			st.setString(4, t_mobile_no.getText());
			st.setString(5, t_email_id.getText());
			st.setString(6, t_position.getText());
			st.setString(7, t_joining_date.getText());
			st.setString(8, t_salary.getText());*/
			int a=st.executeUpdate(sql);  System.out.println(a);       

			if(a>0)
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

}


//-------------------------------------------rooms--------------------------------------------

 class Room extends JFrame implements ActionListener
 {
	    JLabel l_room_no,l_room_type,l_bed,l_charges;
		JTextField t_room_no,c_room_type,c_bed,t_charges;
		JButton b_add_room;
	//	Choice c_room_type,c_bed;
		public static void main(String[] arg)
		{
			String ob;
	
			Room emb=new Room();
			emb.setVisible(true);
			emb.setSize(220,600);
		}
		public Room()
		{
			setLayout(new FlowLayout());
			
			l_room_no=new JLabel("Room_no");
			l_room_type=new JLabel("Room_type");
			l_bed=new JLabel("Bed");
			l_charges=new JLabel("Charges");
			b_add_room=new JButton("ADD");
			
			t_room_no=new JTextField(10);
			c_room_type=new JTextField(10);
			c_bed=new JTextField(10);
			t_charges=new JTextField(10);
		
		//	c_room_type.add("AC");
		//	c_room_type.add("NON-AC");
		//	c_bed.add("Single");
		//	c_bed.add("Double");
			add(l_room_no);
			add(t_room_no);
			add(l_room_type);
			add(c_room_type);
			add(l_bed);
			add(c_bed);
			add(l_charges);
			add(t_charges);
			add(b_add_room);
			b_add_room.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			String s1=t_room_no.getText();
			String s2=c_room_type.getText();
			String s3=c_bed.getText();
			String s4=t_charges.getText();
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
				
				String sql="INSERT INTO `rooms`(`room_no`, `room_type`, `bed`, `charges`) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
			
				PreparedStatement st=cn.prepareStatement(sql);
				
				//st.setString(1, t_employee_id.getText());
			//	st.setString(2, t_name.getText());
			/*	st.setString(3, t_age.getText());
				st.setString(4, t_mobile_no.getText());
				st.setString(5, t_email_id.getText());
				st.setString(6, t_position.getText());
				st.setString(7, t_joining_date.getText());
				st.setString(8, t_salary.getText());*/
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