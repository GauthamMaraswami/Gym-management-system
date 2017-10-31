

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

public class UserDetail implements ActionListener {
	JFrame frame,frame1;
	JPanel panel,panel1;
	Font font1,font2,font3;
	JLabel name,userid,inst,age,dob,addr,phone,headingLabel,headingLabel1,feestatus;
	JLabel name1,userid1,dob1,addr1,phone1,inst1,feestatus1;
	JButton search;
	JTextField searchf;

	public UserDetail()
	{
		frame = new JFrame("UserDetail");
		frame1 = new JFrame("UserDetailShown");
		panel = new JPanel();
		
		panel.setLayout(null);
		panel1 = new JPanel();
		
		panel1.setLayout(null);
	
		search = new JButton("Search");
	font1=new Font("Georgia",Font.BOLD,20);
	font2 = new Font("Georgia",Font.BOLD,15);
	font3 = new Font("Georgia",Font.BOLD,35);
	searchf= new JTextField(30);
	searchf.setBounds(50, 150, 400, 30);
	
	searchf.setFont(font1);
	search.setFont(font1);
	search.addActionListener(this);
	search.setBounds(600,150,200,50);
		
		panel.add(search);
	panel.add(searchf);
	frame.add(panel);
	frame.setSize(700,700);
	frame.setLocationRelativeTo(null);
	frame.setResizable(true);
	frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
new UserDetail();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search)
		{
			try {
				 
			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select count(*) from User where User_id= "+searchf.getText();
	            Statement ps=con.createStatement();
	        	ResultSet rs=ps.executeQuery(query);
	        	if(rs.next())
	        	{
	        		if(rs.getInt(1)==1)
	        		{
	        			String query1="select * from User where User_id= "+searchf.getText();
	                    Statement ps1=con.createStatement();
	                	ResultSet rs1=ps1.executeQuery(query1);
	                	 System.out.println(query1);
	                	if(rs1.next())
	                	{
	                		//frame.removeAll();
	                		//panel.setLayout(null);
	                		//frame1.add(panel1);
	                		System.out.println("query2");
	                		headingLabel1= new JLabel("User Data of User "+searchf.getText());
	                		name = new JLabel("Name");
	                		userid = new JLabel("User ID");
	                		inst = new JLabel("Instructor ID");
	                		dob = new JLabel("Date Of Birth");
	                		addr = new JLabel("Address");
	                		phone = new JLabel("Phone Number");
	                		feestatus=new JLabel("Fee Status");
	                		System.out.println(rs1.getString(2));
	                		name1 = new JLabel(rs1.getString(4));
	                		System.out.println(rs1.getString(4));
	                		userid1 = new JLabel(rs1.getString(1));
	                		inst1 = new JLabel(rs1.getString(7));
	                		dob1 = new JLabel(rs1.getString(8));
	                		addr1 = new JLabel(rs1.getString(6));
	                		phone1 = new JLabel(rs1.getString(3));
	                		System.out.println("query2aaa");
	                		if(rs1.getInt(5)==1)
	                			feestatus1=new JLabel("paid");
	                		else
	                			{feestatus1=new JLabel("Not paid");
	                			
	                			}
	                		headingLabel1.setBounds(700,200,600,30);
	                		name.setBounds(700,350-50,200,30);
	                		userid.setBounds(700,400-50,200,30);
	                		inst.setBounds(700,450-50,200,30);
	                		feestatus.setBounds(700,500-50,200,30);
	                		dob.setBounds(700,550-50,200,30);
	                		addr.setBounds(700,600-50,200,30);
	                		phone.setBounds(700,650-50,200,30);

	                		
	                		name1.setBounds(900,350-50,200,30);
	                		userid1.setBounds(900,400-50,200,30);
	                		inst1.setBounds(900,450-50,200,30);
	                		feestatus1.setBounds(900,500-50,200,30);
	                		dob1.setBounds(900,550-50,200,30);
	                		addr1.setBounds(900,600-50,200,30);
	                		phone1.setBounds(900,650-50,200,30);
	                		
	                		headingLabel1.setFont(font1);
	                		name.setFont(font1);
	                		userid.setFont(font1);
	                		inst.setFont(font1);
	                		feestatus.setFont(font1);
	                		dob.setFont(font1);
	                		addr.setFont(font1);
	                		phone.setFont(font1);
	                		name1.setFont(font1);
	                		userid1.setFont(font1);
	                		inst1.setFont(font1);
	                		feestatus1.setFont(font1);
	                		dob1.setFont(font1);
	                		addr1.setFont(font1);
	                		phone1.setFont(font1);
	                		System.out.println("query2aaa");
	                		panel1.add(headingLabel1);
	                		panel1.add(name);
	                		panel1.add(name1);
	                		panel1.add(userid);
	                		panel1.add(userid1);
	                		panel1.add(inst);
	                		panel1.add(inst1);
	                		panel1.add(feestatus1);
	                		panel1.add(feestatus);
	                		panel1.add(dob);
	                		panel1.add(dob1);
	                		panel1.add(addr);
	                		panel1.add(addr1);
	                		panel1.add(phone);
	                		panel1.add(phone1);
	                	
	                		frame1.add(panel1);
	            			frame1.setSize(500,500);
	                		frame1.setLocationRelativeTo(null);
	                		frame1.setResizable(true);
	                		System.out.println("query2aaa");
	                		frame1.setVisible(true);
	                	}
	        		}
	        		else {
	        			//panel.removeAll();
	        			//frame.remove(panel);
	        			JOptionPane.showMessageDialog(null, "Invalid User ID");
	        		}
	        		
	        	}
	            System.out.println(query);
	            con.close();
		}
			
			catch(Exception ee) {
		}

	
		}
	}
}
		// TODO Auto-generated method stub
		
	


