import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FeePortal implements ActionListener{
	JFrame frame,frame1,frame2;
	JPanel panel,panel1,panel2;
	Font font1,font2,font3;
	JTextField activate,payfee;
	JLabel headingLabel,headingLabel1,headingLabel2,headingLabel3;
	JLabel name,userid,name1,userid1;
	JButton b1,b2,b3,b4,b5;
	public FeePortal() {
		font1=new Font("Georgia",Font.BOLD,20);
		font2 = new Font("Georgia",Font.BOLD,15);
		font3 = new Font("Georgia",Font.BOLD,35);
		frame = new JFrame("Fees");
		panel = new JPanel();
		panel.setLayout(null);
		headingLabel = new JLabel("Fee Status ");
		headingLabel.setFont(font3);
		headingLabel.setBounds(750, 50, 250, 30);
		headingLabel1 = new JLabel("Paid");
		headingLabel1.setFont(font1);
		headingLabel1.setBounds(200, 150, 200, 30);
		headingLabel2 = new JLabel("Unpaid");
		headingLabel2.setFont(font1);
		headingLabel2.setBounds(600, 150, 200, 30);
		headingLabel3 = new JLabel("Inactive");
		headingLabel3.setFont(font1);
		headingLabel3.setBounds(1100, 150, 200, 30);
		b1 = new JButton("Reset");
		b1.setFont(font1);
		b1.setBounds(1400, 250, 300, 30);
		b2 = new JButton("Activate");
		b2.setFont(font1);
		b2.setBounds(1400, 500, 300, 30);
		b3 = new JButton("PAY");
		b3.setBounds(1400, 750, 300, 30);
		b3.setFont(font1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		/*b4.addActionListener(this);
		b5.addActionListener(this);*/
try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select User_id,name from User where fee_status=1  ";
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	userid = new JLabel("User ID");
        	name = new JLabel("Name");
        	name.setBounds(50,200,200,30);
    		userid.setBounds(300,200,200,30);
    		name.setFont(font1);
    		userid.setFont(font1);
    		panel.add(headingLabel);
    		panel.add(name);
    		panel.add(userid);
        	int ptr=50;
        	while(rs.next())
        	{
                   	userid1 = new JLabel(rs.getString(1));
                   	name1 = new JLabel(rs.getString(2));
                   	name1.setBounds(50,200+ptr,200,30);
            		userid1.setBounds(300,200+ptr,200,30);
            		name1.setFont(font2);
            		userid1.setFont(font2);
            		panel.add(name1);
            		panel.add(userid1);
            		ptr=ptr+50;
                	
            }
        	con.close();
}
catch(Exception e) {
	System.out.println(e);
}
try {
	
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
    String query="select User_id,name from User where not fee_status=1 and not status=\"Inactive\" ";
    System.out.println(query);
    Statement ps=con.createStatement();
	ResultSet rs=ps.executeQuery(query);
	userid = new JLabel("User ID");
	name = new JLabel("Name");
	name.setBounds(450,200,200,30);
	userid.setBounds(750,200,200,30);
	name.setFont(font1);
	userid.setFont(font1);
	panel.add(headingLabel);
	panel.add(name);
	panel.add(userid);
	int ptr=50;
	while(rs.next())
	{
           	userid1 = new JLabel(rs.getString(1));
           	name1 = new JLabel(rs.getString(2));
           	name1.setBounds(450,200+ptr,200,30);
    		userid1.setBounds(750,200+ptr,200,30);
    		name1.setFont(font2);
    		userid1.setFont(font2);
    		panel.add(name1);
    		panel.add(userid1);
    		ptr=ptr+50;
        	
    }
	con.close();
}
catch(Exception e) {
System.out.println(e);
}
try {
	
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
    String query="select User_id,name from User  where status=\"Inactive\"";
    System.out.println(query);
    Statement ps=con.createStatement();
	ResultSet rs=ps.executeQuery(query);
	userid = new JLabel("User ID");
	name = new JLabel("Name");
	name.setBounds(950,200,200,30);
	userid.setBounds(1250,200,200,30);
	name.setFont(font1);
	userid.setFont(font1);
	panel.add(headingLabel);
	panel.add(name);
	panel.add(userid);
	int ptr=50;
	while(rs.next())
	{
           	userid1 = new JLabel(rs.getString(1));
           	name1 = new JLabel(rs.getString(2));
           	name1.setBounds(950,200+ptr,200,30);
    		userid1.setBounds(1250,200+ptr,200,30);
    		name1.setFont(font2);
    		userid1.setFont(font2);
    		panel.add(name1);
    		panel.add(userid1);
    		ptr=ptr+50;
        	
    }
	con.close();
}
catch(Exception e) {
System.out.println(e);
}
		panel.add(headingLabel);
		panel.add(headingLabel1);
		panel.add(headingLabel2);
		panel.add(headingLabel3);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		frame.add(panel);
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new FeePortal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			
				try {
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
		            
				Statement stmt = con.createStatement();
				Statement stmt1 = con.createStatement();
      	      String sql = "update User set status=\"Inactive\" where fee_status=0";
      	    String sql1 = "update User set fee_status=0 where status=\"Active\" and fee_status=1";
      	      stmt.executeUpdate(sql);
      	      stmt1.executeUpdate(sql1);
      	      System.out.println(sql);
      	      JOptionPane.showMessageDialog(null, "Data updated successfully");
      	    frame.dispose();
      	    new FeePortal();
      	  con.close();
				}catch(Exception ee)
				{
					System.out.println(ee);
				}
				
			
		}
		if(e.getSource()==b2)
		{
			frame1 = new JFrame("Fees");
			panel1 = new JPanel();
			panel1.setLayout(null);
			b4 = new JButton("Activate");
			font1=new Font("Georgia",Font.BOLD,20);
			font2 = new Font("Georgia",Font.BOLD,15);
			font3 = new Font("Georgia",Font.BOLD,35);
			activate= new JTextField(30);
			activate.setBounds(50, 150, 100, 30);
			
			activate.setFont(font1);
			b4.setFont(font1);
			b4.addActionListener(this);
			b4.setBounds(200, 150, 100, 30);
			panel1.add(b4);
			panel1.add(activate);
			frame1.add(panel1);
			frame1.setSize(400,400);
			frame1.setLocationRelativeTo(null);
			frame1.setResizable(true);
			frame1.setVisible(true);
				
		// TODO Auto-generated method stub
		
	}
		
		if(e.getSource()==b3)
		{
			frame2 = new JFrame("Fees");
			panel2 = new JPanel();
			panel2.setLayout(null);
			b5 = new JButton("Pay");
			font1=new Font("Georgia",Font.BOLD,20);
			font2 = new Font("Georgia",Font.BOLD,15);
			font3 = new Font("Georgia",Font.BOLD,35);
			payfee= new JTextField(30);
			payfee.setBounds(50, 150, 100, 30);
			
			payfee.setFont(font1);
			b5.setFont(font1);
			b5.addActionListener(this);
			b5.setBounds(200, 150, 100, 30);
			panel2.add(b5);
			panel2.add(payfee);
			frame2.add(panel2);
			frame2.setSize(400,400);
			frame2.setLocationRelativeTo(null);
			frame2.setResizable(true);
			frame2.setVisible(true);
				
		// TODO Auto-generated method stub
		
	}
		if(e.getSource()==b4)
		{
			try {
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
				 System.out.println("aa");
				Statement stmt = con.createStatement();
				String sql = "update User set status=\"active\" , fee_status=1 where User_id="+activate.getText();
				Statement stmt1 = con.createStatement();
				String sql1="select status from User where User_id="+activate.getText();
				System.out.println(sql1);
				ResultSet rs=stmt1.executeQuery(sql1);
				if(rs.next())
				{
					if(rs.getString(1)=="active")
					{
						JOptionPane.showMessageDialog(null, "User already Active");
						frame2.dispose();
					}
					else {
						System.out.println(sql);
						 stmt.executeUpdate(sql);
						 JOptionPane.showMessageDialog(null, "Data updated successfully");
						 frame1.dispose();
						 frame.dispose();
						 new FeePortal();
					}
				
				}
				con.close();
				}catch(Exception ee)
				{
					System.out.println(ee);
					JOptionPane.showMessageDialog(null, "Invalid uid");
				}
		}
		if(e.getSource()==b5)
		{
			try {
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
		            
				 
				 
				 
				 
				Statement stmt = con.createStatement();
				Statement stmt1 = con.createStatement();
				String sql1="select fee_status from User where User_id="+payfee.getText();
				ResultSet rs=stmt1.executeQuery(sql1);
				if(rs.next())
				{
					if(rs.getInt(1)==1)
					{
						JOptionPane.showMessageDialog(null, "fee already paid");
						frame2.dispose();
					}
					else {
						String sql = "update User set  fee_status=1 where User_id="+payfee.getText();
						System.out.println(sql);
						 stmt.executeUpdate(sql);
						 JOptionPane.showMessageDialog(null, "Data updated successfully");
						 frame2.dispose();
						 frame.dispose();
						 new FeePortal();
					}
				}
				con.close();
				}catch(Exception ee)
				{
					System.out.println(ee);
					JOptionPane.showMessageDialog(null, "Invalid uid");
				}
		}
		

}
}
