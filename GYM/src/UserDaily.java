import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserDaily implements ActionListener {

	
	String uid;
	JFrame frame;
	JFrame frame1;
	JPanel panel,panel1;
	JButton add,generate,b3,b4,b5,b6;
	Font font1,font2,font3;
	JLabel headingLabel, macid,calories,selectmachine,enter_calories,m,c,heading1,id1,date1,time1,calories1,id2,date2,time2,calories2;
	JTextField time;
	 JComboBox cb;
	 String[] macs=new String[10];
 	int[] cals=new int[10];
	public UserDaily(String User)
	{
		uid=User;
		frame = new JFrame("Add Daily Report");
		panel = new JPanel();
		
		headingLabel = new JLabel("Update your workout  ");
		headingLabel.setBounds(750, 150, 500, 30);
		selectmachine=new JLabel("select macid");
		selectmachine.setBounds(600, 200, 200, 30);
		calories=new JLabel("time");
		calories.setBounds(800, 200, 200, 30);
		add = new JButton("Add");
		b3=new JButton("check Daily Reports");
		generate = new JButton("Generate");
		font1=new Font("Georgia",Font.BOLD,20);
		font2 = new Font("Georgia",Font.BOLD,15);
		font3 = new Font("Georgia",Font.BOLD,35);
		headingLabel.setFont(font3);
		selectmachine.setFont(font1);
		calories.setFont(font1);
		add.addActionListener(this);
		add.setFont(font1);
		add.setBounds(1000, 300, 200, 30);
		b3.addActionListener(this);
		b3.setFont(font1);
		b3.setBounds(750, 500, 400, 30);
		generate.addActionListener(this);
		generate.setFont(font1);
		generate.setBounds(1300, 300, 200, 30);
			panel.setLayout(null);
			panel.add(headingLabel);
			panel.add(selectmachine);
			panel.add(calories);
			panel.add(add);
			panel.add(generate);
			panel.add(b3);
			
			try {
				
			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select * from Machine ";
	            Statement ps1=con.createStatement();
	        	ResultSet rs=ps1.executeQuery(query);
	        	int ctr=0;
	        	
	        	
	        	while(rs.next())
	        	{
	        	    macs[ctr]=rs.getString(1);
	        	    cals[ctr]=rs.getInt(2);
	        		++ctr;
	        	}
	        	cb=new JComboBox(macs); 
				cb.setBounds(650, 300,100, 30);
				cb.setFont(font1);
				con.close();
			}catch(Exception e)
			{
				
			}
			
			
			
			
			
			time=new JTextField(10);
			time.setBounds(800,300,100,30);
			time.setFont(font1);
			panel.add(cb);
			panel.add(time);
			frame.add(panel);
			frame.setSize(700,700);
    		frame.setLocationRelativeTo(null);
    		frame.setResizable(true);
    		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new UserDaily("1");
	}
	int ctr=0;
	int calsum=0;
	int tottime=0;
	@Override
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			JOptionPane.showMessageDialog(null, "Data Added Machine:"+macs[cb.getSelectedIndex()] +" time:"+time.getText()+" calories:"+Integer.toString(cals[cb.getSelectedIndex()]*Integer.parseInt(time.getText())));
			String mac1=macs[cb.getSelectedIndex()];
			
			int time1=Integer.parseInt(time.getText());
			tottime+=time1;
			calsum+=cals[cb.getSelectedIndex()]*Integer.parseInt(time.getText());
		
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            
				Statement stmt = con.createStatement();
      	      
      	      String sql = "Insert into Workout(Date_of_workout,uid,mac_id,time) values(current_date(),"+uid+","+mac1+","+time1+")";
		
      	    stmt.executeUpdate(sql);
      		
    	      con.close();
			}catch(Exception ee)
			{
				System.out.println(ee);
			}

		
			
			
			/*m = new JLabel(macs[cb.getSelectedIndex()]);
			m.setBounds(650, 350+ctr,100, 30);
			c=new JLabel( Integer.toString(cals[cb.getSelectedIndex()]*Integer.parseInt(time.getText())));
			c.setBounds(800, 350+ctr, 100, 30);
			c.setFont(font1);
			m.setFont(font1);
			System.out.println("hi");
			panel1.add(c);
			panel1.add(m);
			
			ctr=ctr+50;
			
			frame1.add(panel1);*/
		}
		
		if(e.getSource()==generate) 
		{	
			try {
				
			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select count(*) from Daily_report where date_of_report=current_date() and uid="+ uid+"";
	    		System.out.println(uid);
	    		System.out.println(query);
	            Statement ps1=con.createStatement();
	        	ResultSet rs=ps1.executeQuery(query);
	        	if(rs.next())
	        	{
	        		if(rs.getInt(1)==1)
	        		{
	        			Statement stmt = con.createStatement();
	            	      
	            	      String sql = "Update Daily_report set time_spent="+tottime+", calories_burnt="+calsum+" where date_of_report=current_date() and uid= "+uid;
	            			System.out.println(sql);
	      		
	            	    stmt.executeUpdate(sql);
	            	    JOptionPane.showMessageDialog(null,"report Updated successfully");
	            		
	          	   
	        		}
	        	}
	        	else {
	        	Statement stmt1 = con.createStatement();
      	      
      	      String sql1 = "Insert into Daily_report(uid,date_of_report,time_spent,calories_burnt) values ("+uid+",current_date(),"+tottime+","+calsum+")";
      		System.out.println(sql1);
      	    stmt1.executeUpdate(sql1);
	        	
	        	con.close();
	        	JOptionPane.showMessageDialog(null,"report generated successfully");
	        	}
	        	
			}catch(Exception ee)
			{
				System.out.println(ee);
			}
			
		}
		if(e.getSource()==b3) {
			frame1 = new JFrame("Your Daily Reports");
			panel1 = new JPanel();
			heading1 = new JLabel("Your daily reports  ");
			heading1.setBounds(750, 150, 500, 30);
			heading1.setFont(font3);
			id1=new JLabel("id");
			id1.setBounds(600, 200, 200, 30);
			id1.setFont(font1);
			date1=new JLabel("Date");
			date1.setBounds(800, 200, 200, 30);
			time1=new JLabel("time");
			time1.setBounds(1000, 200, 200, 30);
			calories1=new JLabel("calories");
			calories1.setBounds(1200, 200, 200, 30);
			date1.setFont(font1);
			time1.setFont(font1);
			calories1.setFont(font1);
			panel1.setLayout(null);
			panel1.add(heading1);
			panel1.add(id1);
			panel1.add(date1);
			panel1.add(time1);
			panel1.add(calories1);
			try {
				
			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select * from Daily_report where uid= "+uid+" order by(date_of_report) desc";
	            System.out.println(query);
	            Statement ps=con.createStatement();
	        	ResultSet rs=ps.executeQuery(query);
	        	int ptr=50;
	        	while(rs.next()) {
	        		id2=new JLabel(rs.getString(1));
	    			id2.setBounds(600, 200+ptr, 200, 30);
	    			id2.setFont(font1);
	    			date2=new JLabel(rs.getString(3));
	    			date2.setBounds(800, 200+ptr, 200, 30);
	    			time2=new JLabel(rs.getString(4));
	    			time2.setBounds(1000, 200+ptr, 200, 30);
	    			calories2=new JLabel(rs.getString(5));
	    			calories2.setBounds(1200, 200+ptr, 200, 30);
	    			date2.setFont(font2);
	    			time2.setFont(font2);
	    			calories2.setFont(font2);
	    			panel1.add(id2);
	    			panel1.add(date2);
	    			panel1.add(time2);
	    			panel1.add(calories2);
	        		ptr+=50;
	        	}
	        	con.close();
			}catch(Exception ee)
			{
				System.out.println(ee);
			}
			
			
			frame1.add(panel1);
			frame1.setSize(700,700);
    		frame1.setLocationRelativeTo(null);
    		frame1.setResizable(true);
    		frame1.setVisible(true);
		}
		// TODO Auto-generated method stub
		
	}

}
