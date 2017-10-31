import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class InstructorProfile implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel name,userid,pass,addr,phone;
	JTextField namef,useridf,passf,addrf,phonef;
	Font font1,font2;
	JButton submit,cancel;
	String name1,pass1,addr1,phone1;
	String iid;
	public InstructorProfile(String Inst)
	{
		iid=Inst;
		try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select i.Inst_id,i.name,i.Password,i.address,i.PhoneNumber from Instructor as i where Inst_id="+iid;
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	//System.out.println(rs.getInt(0));
            if(rs.next())
            {
            	
            	name1=rs.getString(2);
            	
            	addr1=rs.getString(4);
            	phone1=rs.getString(5);
            	pass1=rs.getString(3);
            	frame = new JFrame("Update Profile");
        		panel = new JPanel();
        		name = new JLabel("Name");
        		userid = new JLabel("Instructor ID");
        		pass = new JLabel("Password");
        		addr = new JLabel("Address");
        		phone = new JLabel("Phone Number");
        		namef = new JTextField(name1,30);
        		useridf = new JTextField(iid,30);
        		passf = new JTextField(30);
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
		pass.setBounds(700,400,200,30);
		addr.setBounds(700,450,200,30);
		phone.setBounds(700,550-50,200,30);
		namef.setBounds(900,350-50,200,30);
		useridf.setBounds(900,400-50,200,30);
		passf.setBounds(900,400,200,30);
		addrf.setBounds(900,450,200,30);
		phonef.setBounds(900,500,200,30);
		submit.setBounds(700,600-50,150,30);
		cancel.setBounds(900,600-50,150,30);
		
		name.setFont(font1);
		userid.setFont(font1);
		pass.setFont(font1);
		addr.setFont(font1);
		phone.setFont(font1);
		
		panel.add(name);
		panel.add(namef);
		panel.add(userid);
		panel.add(useridf);
		panel.add(pass);
		panel.add(passf);
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
		new InstructorProfile("101");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit)
		{
		
			name1=namef.getText();
			
			addr1=addrf.getText();
			phone1=phonef.getText();
			if(passf.getText().equals(""))
			{
				
			}
			else
			{
				pass1=passf.getText();
			}
			try {
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
		            
				Statement stmt = con.createStatement();
     	      
     	      String sql = "update Instructor set name=\""+name1+"\" ,address=\""+addr1+"\", PhoneNumber="+phone1+", Password=\""+pass1+"\" where Inst_id="+iid;
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


