package hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Check_in extends JFrame implements ActionListener,ItemListener
{
	JLabel p_heading,l_name,l_age,l_contact,l_address,l_email_id,l_coustmer_id,l_total_member,l_check_in,l_check_out,l_id_proof,l_gender;
	JTextField t_name,t_age,t_contact,t_address,t_email_id,t_coustmer_id,t_total_member,t_check_in,t_check_out,t_id_number;
	JComboBox c_id_proof;
	JRadioButton r_male,r_female;
	String radio;
	
	JPanel p1;
	
	JLabel l_room_no,l_room_type,l_charges;
	JTextField t_room_no,t_charges;
	JComboBox c_room_type,c_room_no;
	
/*	JLabel l_total_bill,l_bill_pay,l_bill_pending;
	JTextField t_total_bill,t_bill_pay,t_bill_pending;*/
	JButton b_submit;
	public static void main(String[] arg)
	{
		Check_in emb=new Check_in();
		emb.setVisible(true);
		emb.setSize(1300,780);
	}
	public Check_in()
	{
		//````````````````````````````````````````personal details````````````````````````````````````````````````````
		
		p1=new JPanel();
		//p1.setBackground(Color.red);
		p1.setLayout(null);
		p1.setBounds(0, 0, 1280, 780);
		p_heading=new JLabel("personal detail.....");
		
		
		c_id_proof=new JComboBox();
		l_name=new JLabel("name");
		l_age=new JLabel("age");
		l_contact=new JLabel("contact");
		l_address=new JLabel("address");
		l_email_id=new JLabel("email_id");
		l_coustmer_id=new JLabel("coustmer_id");
		l_total_member=new JLabel("total_member");
		l_check_in=new JLabel("check_in");
		l_check_out=new JLabel("check_out");
		l_id_proof=new JLabel("Id Proof");
		l_gender=new JLabel("Gender");
		
		
		t_name=new JTextField();
		t_age=new JTextField();
		t_contact=new JTextField();
		t_address=new JTextField();
		t_email_id=new JTextField();
		t_coustmer_id=new JTextField();
		t_total_member=new JTextField();
		t_check_in=new JTextField();
		t_check_out=new JTextField();
		r_male=new JRadioButton("male");
		r_female=new JRadioButton("female");
	
		t_id_number=new JTextField();
		c_id_proof.addItem("aadhar card");
		c_id_proof.addItem("pen card");
		c_id_proof.addItem("voter id");
		c_id_proof.addItem("driving license");
		
		
		
		l_name.setBounds(50, 50, 100, 20);
		l_age.setBounds(310, 50, 100, 20);
		l_contact.setBounds(540, 50, 100, 20);
		l_address.setBounds(50, 80, 100, 20);
		l_email_id.setBounds(310, 80, 100, 20);
		l_coustmer_id.setBounds(540, 80, 100, 20);
		l_total_member.setBounds(50, 110, 100, 20);
		l_check_in.setBounds(310, 110, 100, 20);
		l_check_out.setBounds(540, 110, 100, 20);
		l_id_proof.setBounds(50, 140, 100, 20);
		l_gender.setBounds(540, 140, 100, 20);
	
		t_name.setBounds(160, 50, 100, 20);
		t_age.setBounds(390, 50, 100, 20);
		t_contact.setBounds(630, 50, 100, 20);
		t_address.setBounds(160, 80, 100, 20);
		t_email_id.setBounds(390, 80, 100, 20);
		t_coustmer_id.setBounds(630, 80, 100, 20);
		t_total_member.setBounds(160, 110, 100, 20);
		t_check_in.setBounds(390, 110, 100, 20);
		t_check_out.setBounds(630, 110, 100, 20);
		t_id_number.setBounds(310, 140, 180, 20);
		c_id_proof.setBounds(160, 140, 100, 20);
		r_male.setBounds(620, 140, 70, 20);
		r_female.setBounds(700, 140, 70, 20);
		r_male.setBackground(Color.red);
		r_female.setBackground(Color.red);

		
		
		add(p1);

		p1.add(l_name);
		p1.add(t_name);
		p1.add(l_age);
		p1.add(t_age);
		p1.add(l_contact);
		p1.add(t_contact);
		p1.add(l_address);
		p1.add(t_address);
		p1.add(l_email_id);
		p1.add(t_email_id);
		p1.add(l_coustmer_id);
		p1.add(t_coustmer_id);
		p1.add(l_total_member);
		p1.add(t_total_member);
		p1.add(l_check_in);
		p1.add(t_check_in);
		p1.add(l_check_out);
		p1.add(t_check_out);
		p1.add(t_id_number);
		p1.add(l_id_proof);
		p1.add(c_id_proof);
		p1.add(l_gender);
		p1.add(r_male);
		p1.add(r_female);
		
		
		//```````````````````````````````````````````````Room detail````````````````````````````````````
		
		
		l_room_no=new JLabel("Room_no");
		l_room_type=new JLabel("Room_type");
		l_charges=new JLabel("Charges");
		
		t_room_no=new JTextField();
		t_charges=new JTextField();
		c_room_type=new JComboBox();
		try
		{
			String ava="BOOK";
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
		//	Statement st1=cn.createStatement();
			String sql="select * from room_type";
		//	String sql1="select * from rooms where `Booking`='"+ava+"'";
			ResultSet rs=st.executeQuery(sql);
		//	ResultSet rs1=st1.executeQuery(sql1);
			while(rs.next())
			{
				String sts=rs.getString("room_type");
			//	String sts1=rs1.getString("Room_no");
				c_room_type.addItem(sts);
			//	c_room_no.addItem(sts1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		c_room_type.addItemListener(this);
		
	
		
	
		l_room_no.setBounds(50, 280, 100, 20);
		l_room_type.setBounds(280, 280, 100, 20);
		
		l_charges.setBounds(280, 310, 100, 20);
		
		t_room_no.setBounds(130, 280, 100, 20);
		c_room_type.setBounds(370, 280, 100, 20);
	
		t_charges.setBounds(370, 310, 100, 20);

		p1.add(l_room_no);
		p1.add(t_room_no);
		p1.add(l_room_type);
		p1.add(c_room_type);
		
		p1.add(l_charges);
		p1.add(t_charges);
		
		//`````````````````````````````````````````````````````````bill```````````````````````````````````````````
	
	/*	l_total_bill=new JLabel("total bill");
		l_bill_pay=new JLabel("bill pay");
		l_bill_pending=new JLabel("bill pending");
		b_submit=new JButton("submit");
		
		
		t_total_bill=new JTextField();
		t_bill_pay=new JTextField();
		t_bill_pending=new JTextField();
		
	
		l_total_bill.setBounds(50, 530, 100, 20);
		l_bill_pay.setBounds(310, 530, 100, 20);
		l_bill_pending.setBounds(530, 530, 100, 20);
		
		t_total_bill.setBounds(160, 530, 100, 20);
		t_bill_pay.setBounds(375, 530, 100, 20);
		t_bill_pending.setBounds(620, 530, 100, 20);*/
		b_submit=new JButton("submit");
		b_submit.setBounds(620,600,80,50);

	/*	p1.add(l_total_bill);
		p1.add(t_total_bill);
		p1.add(l_bill_pay);
		p1.add(t_bill_pay);
		p1.add(l_bill_pending);
		p1.add(t_bill_pending);*/
		p1.add(b_submit);
		r_male.addItemListener(this);
		r_female.addItemListener(this);
		b_submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=t_name.getText();
		String s2=t_age.getText();
		String s3=t_contact.getText();
		String s4=t_address.getText();
		String s5=t_email_id.getText();
		String s6=t_coustmer_id.getText();
		String s7=t_total_member.getText();
		String s8=t_check_in.getText();
		String s9=t_check_out.getText();	
		String s10=c_id_proof.getSelectedItem().toString();					
		String s11=t_id_number.getText();								//personal_detail
		
		String s12=t_room_no.getText();									//room_detail
		String s13=c_room_type.getSelectedItem().toString();
		String s15=t_charges.getText();
		
																						//payment_detail
	/*	String s17=t_total_bill.getText();	
		String s18=t_bill_pay.getText();	
		String s19=t_bill_pending.getText();*/
		
		
		if(s1.isEmpty()==true||s2.isEmpty()==true||s3.isEmpty()==true||s4.isEmpty()==true||s6.isEmpty()==true||s8.isEmpty()==true||s9.isEmpty()==true||s10.isEmpty()==true||s11.isEmpty()==true||s12.isEmpty()==true||s13.isEmpty()==true||s15.isEmpty()==true)     //||s17.isEmpty()==true||s18.isEmpty()==true||s19.isEmpty()==true||radio.isEmpty()==true
		{
			JOptionPane.showMessageDialog(null, "all fields are required");
		}
		else
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
		    String sql="INSERT INTO `coustmer`(`name`, `age`, `contact`, `address`, `email_id`, `coustmer_id`,`total_member`, `check_in`, `check_out`,`id_proof`,`id_number`,`gender`) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+radio+"')";
	//	    String sql_cp="INSERT INTO `coustmer_payment`(`name`, `coustmer_id`, `room_no`, `room_type`,`room_charge`, `total_charges`, `bill_pay`,`bill_pending`) VALUES ('"+s1+"','"+s6+"','"+s12+"','"+s13+"','"+s15+"','"+s17+"','"+s18+"','"+s19+"')";
		    PreparedStatement st=cn.prepareStatement(sql);
	//	    PreparedStatement st1=cn.prepareStatement(sql_cp);
			
	
			int a=st.executeUpdate(sql);
	//		int b=st1.executeUpdate(sql_cp);

			if(a>0 )	//&& b>0
			{
				try
				{
					
					String booking="BOOK";
				    String sql2="UPDATE `rooms` SET `Booking`='"+booking+"' WHERE `Room_no`='"+s12+"'";
					PreparedStatement st2=cn.prepareStatement(sql2);
					st2.executeUpdate(sql2);  
					
					int i=1+Integer.parseInt(s6);
					String sql3="INSERT INTO `coustmer_id`(`id`) VALUES ('"+i+"')";
					PreparedStatement st3=cn.prepareStatement(sql3);
					st3.executeUpdate(sql3);  
		
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
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

	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==r_male)
		{
			r_female.setSelected(false);
			radio=r_male.getText();
		
	
		}
		else if(e.getSource()==r_female)
		{
			r_male.setSelected(false);
			radio=r_female.getText();
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_project","root","");
			
			Statement st=cn.createStatement();
			String sql="select * from room_type where room_type='"+c_room_type.getSelectedItem().toString()+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
			double sts=rs.getDouble("charges");
			
			t_charges.setText(""+sts);
		//	t_total_bill.setText(""+sts);
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	
	
}
