import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class UserProfile implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JLabel name,userid,inst,age,dob,addr,phone;
	JTextField namef,useridf,instf,passwdf,dobf,addrf,phonef;
	Font font1,font2;
	//JLabel headingLabel;
	JButton submit,cancel;
	//BorderLayout bl;
	String uid;
	String inst1,name1,dob1,addr1,phone1,passwd;
	public UserProfile(String user)
	{
		uid=user;
		try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select u.User_id,u.name,u.Password,u.address,u.PhoneNumber,dob,I.name from User as u,Instructor as I where User_id="+uid+" and u.Inst_id=I.Inst_id";
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	//System.out.println(rs.getInt(0));
            if(rs.next())
            {
            	inst1=rs.getString(7);
            	name1=rs.getString(2);
            	dob1=rs.getString(6);
            	addr1=rs.getString(4);
            	phone1=rs.getString(5);
            	passwd=rs.getString(3);
		frame = new JFrame("Update Profile");
		panel = new JPanel();
		name = new JLabel("Name");
		userid = new JLabel("User ID");
		inst = new JLabel("Instructor");
		age = new JLabel("Password");
		dob = new JLabel("Date Of Birth");
		addr = new JLabel("Address");
		phone = new JLabel("Phone Number");
		namef = new JTextField(name1,30);
		useridf = new JTextField(uid,30);
		instf = new JTextField(inst1,30);
		passwdf = new JTextField(30);
		 if(dob1=="")
		 {
			 dob1="yyyy-mm-dd";
		 }
		dobf = new JTextField(dob1,30);
		addrf = new JTextField(addr1,30);
		phonef = new JTextField(phone1,30);
		font2 = new Font("Georgia",Font.BOLD,50);
		font1=new Font("Georgia",Font.BOLD,20);
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		con.close();
            }
		}catch(Exception ee)
		{
			System.out.println(ee);
		}
            
		panel.setLayout(null);
		name.setBounds(700,350-50,200,30);
		userid.setBounds(700,400-50,200,30);
		inst.setBounds(700,450-50,200,30);
		age.setBounds(700,500-50,200,30);
		dob.setBounds(700,550-50,200,30);
		addr.setBounds(700,600-50,200,30);
		phone.setBounds(700,650-50,200,30);
		namef.setBounds(900,350-50,200,30);
		useridf.setBounds(900,400-50,200,30);
		instf.setBounds(900,450-50,200,30);
		passwdf.setBounds(900,500-50,200,30);
		dobf.setBounds(900,550-50,200,30);
		addrf.setBounds(900,600-50,200,30);
		phonef.setBounds(900,650-50,200,30);
		submit.setBounds(700,700-50,150,30);
		cancel.setBounds(900,700-50,150,30);
		
		name.setFont(font1);
		userid.setFont(font1);
		inst.setFont(font1);
		age.setFont(font1);
		dob.setFont(font1);
		addr.setFont(font1);
		phone.setFont(font1);
		
		panel.add(name);
		panel.add(namef);
		panel.add(userid);
		panel.add(useridf);
		panel.add(inst);
		panel.add(instf);
		panel.add(age);
		panel.add(passwdf);
		panel.add(dob);
		panel.add(dobf);
		panel.add(addr);
		panel.add(addrf);
		panel.add(phone);
		panel.add(phonef);
		panel.add(submit);
		panel.add(cancel);
		
		frame.add(panel);
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new UserProfile("1");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit)
		{
			inst1=instf.getText();
			name1=namef.getText();
			dob1=dobf.getText();
			addr1=addrf.getText();
			phone1=phonef.getText();
			if(dob1=="yyyy-mm-dd")
			{
				dob1=" ";
			}
			if(passwdf.getText().equals(""))
			{
				
			}
			else
			{
				passwd=passwdf.getText();
			}
				try {
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
		            
				Statement stmt = con.createStatement();
      	      
      	      String sql = "update User set name=\""+name1+"\" ,dob=\""+dob1+"\",address=\""+addr1+"\", PhoneNumber="+phone1+", password=\""+passwd+"\" where User_id="+uid;
      	      System.out.println(sql);
      	      JOptionPane.showMessageDialog(null, "Data updated successfully");
      	    frame.dispose();
      	      stmt.executeUpdate(sql);
      	    con.close();
				}catch(Exception ee)
				{
					System.out.println(ee);
				}
				
			
		}
		if(e.getSource()==cancel)
		{
			frame.dispose();
		}
		
	}

}
