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

public class InstDetail implements ActionListener{
	JFrame frame,frame1;
	JPanel panel,panel1;
	Font font1,font2,font3;
	JLabel name,userid,capacity,dayslot,doa,addr,phone,headingLabel,headingLabel1,salary;
	JLabel name1,userid1,doa1,addr1,phone1,dayslot1,capacity1,salary1;
	JButton search;
	JTextField searchf;

	public InstDetail()
	{
		frame = new JFrame("Instructor Detail");
		frame1 = new JFrame("Instructor Detail Shown");
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
		
		new InstDetail();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search)
		{
			try {
				 
			    Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
	            String query="select count(*) from Instructor where Inst_id= "+searchf.getText();
	            Statement ps=con.createStatement();
	        	ResultSet rs=ps.executeQuery(query);
	        	if(rs.next())
	        	{
	        		if(rs.getInt(1)==1)
	        		{
	        			String query1="select * from Instructor where Inst_id= "+searchf.getText();
	                    Statement ps1=con.createStatement();
	                	ResultSet rs1=ps1.executeQuery(query1);
	                	 System.out.println(query1);
	                	if(rs1.next())
	                	{
	                		//frame.removeAll();
	                		//panel.setLayout(null);
	                		//frame1.add(panel1);
	                		System.out.println("query2");
	                		headingLabel1= new JLabel("Instructor Data ofInstructor "+searchf.getText());
	                		name = new JLabel("Name");
	                		userid = new JLabel("Instructor ID");
	                		dayslot = new JLabel("Instructor Day Slot");
	                		doa = new JLabel("Date Of Appointment");
	                		addr = new JLabel("Address");
	                		phone = new JLabel("Phone Number");
	                		capacity=new JLabel("capacity");
	                		salary=new JLabel("salary");
	                		
	                		name1 = new JLabel(rs1.getString(4));
	                		
	                		userid1 = new JLabel(rs1.getString(1));
	                		dayslot1= new JLabel(rs1.getString(5));
	                		doa1 = new JLabel(rs1.getString(9));
	                		addr1 = new JLabel(rs1.getString(6));
	                		phone1 = new JLabel(rs1.getString(3));
	              
	                		
	                		capacity1=new JLabel(rs1.getString(8));
	                		salary1=new JLabel(rs1.getString(7));
	                			
	                			
	                		headingLabel1.setBounds(700,200,600,30);
	                		name.setBounds(700,350-50,200,30);
	                		userid.setBounds(700,400-50,200,30);
	                		capacity.setBounds(700,450-50,200,30);
	                		dayslot.setBounds(700,500-50,200,30);
	                		doa.setBounds(700,550-50,200,30);
	                		addr.setBounds(700,600-50,200,30);
	                		phone.setBounds(700,650-50,200,30);
	                		salary.setBounds(700,700-50,200,30);
	                		
	                		name1.setBounds(900,350-50,200,30);
	                		userid1.setBounds(900,400-50,200,30);
	                		capacity1.setBounds(900,450-50,200,30);
	                		dayslot1.setBounds(900,500-50,200,30);
	                		doa1.setBounds(900,550-50,200,30);
	                		addr1.setBounds(900,600-50,200,30);
	                		phone1.setBounds(900,650-50,200,30);
	                		salary1.setBounds(900,700-50,200,30);
	                		headingLabel1.setFont(font1);
	                		name.setFont(font1);
	                		userid.setFont(font1);
	                		capacity.setFont(font1);
	                		dayslot.setFont(font1);
	                		doa.setFont(font1);
	                		addr.setFont(font1);
	                		phone.setFont(font1);
	                		salary.setFont(font1);
	                		salary1.setFont(font1);
	                		name1.setFont(font1);
	                		userid1.setFont(font1);
	                		dayslot1.setFont(font1);
	                		capacity1.setFont(font1);
	                		doa1.setFont(font1);
	                		addr1.setFont(font1);
	                		phone1.setFont(font1);
	                		System.out.println("query2aaa");
	                		panel1.add(headingLabel1);
	                		panel1.add(name);
	                		panel1.add(name1);
	                		panel1.add(userid);
	                		panel1.add(userid1);
	                		panel1.add(salary1);
	                		panel1.add(salary);
	                		panel1.add(capacity1);
	                		panel1.add(capacity);
	                		panel1.add(doa);
	                		panel1.add(doa1);
	                		panel1.add(addr);
	                		panel1.add(addr1);
	                		panel1.add(phone);
	                		panel1.add(phone1);
	                		panel1.add(dayslot);
	                		panel1.add(dayslot1);
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
