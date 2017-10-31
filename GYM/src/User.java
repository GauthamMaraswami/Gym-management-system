import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class User implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JButton drpt,mrpt,atts,attm,fee,pro,logout;
	Font font1,font2;
	JLabel headingLabel;
	String uid;
	public User(String userid) 
	{
		uid=userid;
		frame = new JFrame("User");
		panel = new JPanel();
		drpt = new JButton("Generate Daily Report");
		mrpt = new JButton(" Monthly Report");
		atts = new JButton("Check Attendence Status");
		attm = new JButton("Mark Today's Attendence");
		fee = new JButton("Check Fee Status");
		pro = new JButton("Update Profile");
		logout = new JButton("Log Out");
		headingLabel = new JLabel("Welcome USER ");
		
		font2 = new Font("Georgia",Font.BOLD,50);
		font1=new Font("Georgia",Font.BOLD,20);
		
		panel.setLayout(null);
		
		drpt.setFont(font1);
		mrpt.setFont(font1);
		atts.setFont(font1);
		attm.setFont(font1);
		fee.setFont(font1);
		pro.setFont(font1);
		logout.setFont(font1);
		
		pro.setBounds(400, 150, 450, 100);
		attm.setBounds(1050, 150, 450, 100);
		drpt.setBounds(400, 350, 450, 100);
		mrpt.setBounds(1050,350,450,100);
		fee.setBounds(400,550,450,100);
		atts.setBounds(1050,550,450,100);
		logout.setBounds(726, 750, 450,100);
		headingLabel.setBounds(725,0,450,90);
		headingLabel.setFont(font2);
		
		panel.add(pro);
		panel.add(attm);
		panel.add(drpt);
		panel.add(mrpt);
		panel.add(fee);
		panel.add(atts);
		panel.add(logout);
		panel.add(headingLabel);
		
		pro.addActionListener(this);
		attm.addActionListener(this);
		drpt.addActionListener(this);
		mrpt.addActionListener(this);
		fee.addActionListener(this);
		atts.addActionListener(this);
		logout.addActionListener(this);
		
		frame.add(panel);
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new User("1");

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==attm)
		{

			try 
			{
                Class.forName("com.mysql.cj.jdbc.Driver");
                                    
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
                String query="select count(*) from Daily_report where uid="+uid+" and Date_of_report = CURRENT_DATE()";
                System.out.println(query);
                Statement ps=con.createStatement();
            	ResultSet rs=ps.executeQuery(query);
            	//System.out.println(rs.getInt(0));
                if(rs.next())
                {
                	if(rs.getInt(1)==0)
                	{
                		Statement stmt = con.createStatement();
                	      
                	      String sql = "Insert into Daily_report(uid,date_of_report,time_spent,calories_burnt) values("+uid+",CURRENT_DATE(),0,0)";
                	      System.out.println(sql);
                	      JOptionPane.showMessageDialog(null, "Attendence marked successfully");
                	      stmt.executeUpdate(sql);
                	}
                	else
                	{
                		 JOptionPane.showMessageDialog(null, "Attendence already marked for today");
                	}
                	
                }
                con.close();
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			
		}
		
		if(e.getSource()==fee)
		{
			try {
				
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select fee_status from User where User_id="+uid;
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	//System.out.println(rs.getInt(0));
            if(rs.next())
            {
            	if(rs.getInt(1)==0)
            	{
            		JOptionPane.showMessageDialog(null, "Fee not yet paid");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Fee already paid");
            	}
            }
            con.close();
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			
		}
		if(e.getSource()==atts)
		{
			try {
				
			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select count(*) from Daily_report where month(date_of_report)=month(current_date())";
	            System.out.println(query);
	            Statement ps=con.createStatement();
	        	ResultSet rs=ps.executeQuery(query);
	        	//System.out.println(rs.getInt(0));
	            if(rs.next())
	            {
	            	JOptionPane.showMessageDialog(null, "you have attended "+rs.getInt(1)+" days in this month" );
	            }
	            con.close();
	            }
	            catch(Exception ee)
				{
					System.out.println(ee);
				}
			}
		
		
		if(e.getSource()==pro)
		{
			new UserProfile(uid);
		}

		if(e.getSource()==drpt)
		{
			new UserDaily(uid);
		}
		if(e.getSource()==mrpt)
		{
			new UserMonthly(uid);
		}
		if(e.getSource()==logout)
		{
			frame.dispose();
		}
			
	}

}
