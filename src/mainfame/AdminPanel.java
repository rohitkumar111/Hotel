package mainfame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import adminlogin.SignUp;
import hms.*;
public class AdminPanel extends JFrame implements ActionListener
{

//	JComboBox c_room,c_employee;
	JButton b_signUp,b_checkStatus,b_availableRoom,b_room,b_employee,b_coustmerDetail,b_check_in,b_check_out;
	
	JPanel p1;
	public static void main(String[] args) 
	{
		AdminPanel cpl=new AdminPanel();
		cpl.setSize(400, 400);
		cpl.setVisible(true);

	}
	public AdminPanel()
	{
	    p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 400, 400);
		
		b_room=new JButton("Rooms Detail");
		b_employee=new JButton("Employees Detail");
		b_checkStatus=new JButton("Check Status");
		b_availableRoom=new JButton("Room Booking");
		b_coustmerDetail=new JButton("COUSTMER DETAIL");
		b_check_in=new JButton("CHECK IN");
		b_check_out=new JButton("CHECK OUT");
		b_signUp=new JButton("Sign Up");
		
		b_checkStatus.setBounds(50, 200, 150, 25);
		b_availableRoom.setBounds(50, 250, 150, 25);
		b_coustmerDetail.setBounds(50, 150, 150, 25);
		b_room.setBounds(50, 50, 150, 25);
		b_employee.setBounds(50, 100, 150, 25);
		b_check_in.setBounds(50, 300, 150, 25);
		b_check_out.setBounds(50, 350, 150, 25);
		b_signUp.setBounds(1200, 30, 80, 30);
		
		add(p1);
		p1.add(b_room);
		p1.add(b_employee);
		p1.add(b_checkStatus);
		p1.add(b_availableRoom);
		p1.add(b_signUp);
		p1.add(b_coustmerDetail);
		p1.add(b_check_in);
		p1.add(b_check_out);
		b_signUp.addActionListener(this);
		b_availableRoom.addActionListener(this);
		b_checkStatus.addActionListener(this);
		b_employee.addActionListener(this);
		b_room.addActionListener(this);
		b_coustmerDetail.addActionListener(this);
		b_check_in.addActionListener(this);
		b_check_out.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
	    if(ae.getSource()==b_signUp)
		{
			SignUp sp=new SignUp();
			sp.setVisible(true);
			sp.setSize(400,400);
		}
	    else if(ae.getSource()==b_availableRoom)
	  	{
	    	RoomBooking rb=new RoomBooking();
	    	rb.setVisible(true);
	    	rb.setSize(1300,780);
	  	}
	    else if(ae.getSource()==b_checkStatus)
	  	{
	  			/*SignUp sp=new SignUp();
	  			sp.setVisible(true);
	  			sp.setSize(400,400);*/
	  	}
	    else if(ae.getSource()==b_room)
	  	{
	  			Roomdetail rd=new Roomdetail();
	  			rd.setVisible(true);
	  			rd.setSize(400,400);
	  	}
	    else if(ae.getSource()==b_employee)
	  	{
	  			EmployeeDetail sp=new EmployeeDetail();
	  			sp.setVisible(true);
	  			sp.setSize(400,400);
	  	}
	    else if(ae.getSource()==b_coustmerDetail)
	  	{
	    		CoustmerDetail cd=new CoustmerDetail();
	  			cd.setVisible(true);
	  			cd.setSize(400,400);
	  	}
	    else if(ae.getSource()==b_check_in)
	  	{
	  			/*EmployeeDetail sp=new EmployeeDetail();
	  			sp.setVisible(true);
	  			sp.setSize(400,400);*/
	  	}
	    else if(ae.getSource()==b_check_out)
	  	{
	    	CheckOut co=new CheckOut();
			co.setVisible(true);
			co.setSize(220,600);
	  	}
	}

}
