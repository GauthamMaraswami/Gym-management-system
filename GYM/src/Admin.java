import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class Admin implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JButton crins,crusr,lsins,lsusr,srch,mrpt,drpt,rank;
	Font font1,font2;
	JLabel headingLabel;
	
	public Admin()
	{
		frame = new JFrame("Admin");
		panel = new JPanel();
		crins = new JButton("Create Instructor");
		crusr = new JButton("Create User");
		lsins = new JButton("List Instructors");
		lsusr = new JButton("List Users");
		srch = new JButton("Fee Management");
		mrpt = new JButton("Generate Monthly Report");
		drpt = new JButton("Check Daily Report");
		rank = new JButton("Generate Rank");
		headingLabel = new JLabel("Welcome Admin");
		
		font2 = new Font("Georgia",Font.BOLD,50);
		font1=new Font("Georgia",Font.BOLD,20);
		
		panel.setLayout(null);
		crins.setFont(font1);
		crusr.setFont(font1);
		lsins.setFont(font1);
		lsusr.setFont(font1);
		srch.setFont(font1);
		mrpt.setFont(font1);
		drpt.setFont(font1);
		rank.setFont(font1);
		
		crins.setBounds(400, 150, 450, 100);
		crusr.setBounds(1050, 150, 450, 100);
		lsins.setBounds(400, 350, 450, 100);
		lsusr.setBounds(1050, 350, 450, 100);
		drpt.setBounds(400, 550, 450, 100);
		mrpt.setBounds(1050, 550, 450, 100);
		srch.setBounds(400, 750, 450, 100);
		rank.setBounds(1050, 750, 450, 100);
		headingLabel.setBounds(725,0,650,90);
		headingLabel.setFont(font2);
		
		
		panel.add(crins);
		panel.add(crusr);
		panel.add(lsins);
		panel.add(lsusr);
		panel.add(drpt);
		panel.add(mrpt);
		panel.add(srch);
		panel.add(rank);
		panel.add(headingLabel);
		
		crins.addActionListener(this);
		crusr.addActionListener(this);
		lsins.addActionListener(this);
		lsusr.addActionListener(this);
		drpt.addActionListener(this);
		mrpt.addActionListener(this);
		srch.addActionListener(this);
		rank.addActionListener(this);
		
		frame.add(panel);
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==crusr)
		{
			new AddStudent();
		}
		if(e.getSource()==crins)
		{
			new AddInstructor();
		}
		if(e.getSource()==lsusr)
		{
			new ListUserProfile();
		}
		if(e.getSource()==lsins)
		{
			new ListInstProfile();
		}
		if(e.getSource()==srch)
		{
			new FeePortal();
		}
		if(e.getSource()==drpt)
		{
			new CheckUserDailyAdmin();
		}
		if(e.getSource()==mrpt)
		{
			new MonthlyReport();
		}
		if(e.getSource()==rank)
		{
try {
		    	

			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select uid,month,tot_calories from Monthly_report  where month=month(current_date) order by tot_calories desc";
	            System.out.println(query);
	            Statement ps=con.createStatement();
	        	ResultSet rs=ps.executeQuery(query);
	        	int ctr=1;
	        	while(rs.next())
	        	{
	        		 
	 	        	
	        		
	        		String query1="Update  Monthly_report set rank ="+ctr+" where uid="+rs.getString(1)+" and month=month(current_date)";
		            System.out.println(query1);
		            Statement ps1=con.createStatement();
		        	
		        	  ps1.executeUpdate(query1);
		        	  ++ctr;
		        	  
	 	        	
	        	
	        	}
	        	
	        	
	        	con.close();
		}catch(Exception ee){}
JOptionPane.showMessageDialog(null, "Rank Successfully generated" );
		}
		
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Admin();

	}

}
