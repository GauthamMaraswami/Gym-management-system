import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class ListUsers implements ActionListener{
	JFrame frame;
	JPanel panel;
	Font font1,font2,font3;
	JLabel headingLabel;
	JLabel name,userid,inst,age,dob,addr,phone;
	JLabel name1,userid1,dob1,addr1,phone1;
	String iid;
	public ListUsers(String Inst)
	{
		iid=Inst;
		frame = new JFrame("Instructor");
		panel = new JPanel();
		headingLabel = new JLabel("List of Users Under Instructor ");
		headingLabel.setBounds(600, 50, 1000, 30);
		
	font1=new Font("Georgia",Font.BOLD,20);
	font2 = new Font("Georgia",Font.BOLD,15);
	font3 = new Font("Georgia",Font.BOLD,35);
		headingLabel.setFont(font3);
		panel.setLayout(null);
			try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select * from User  where Inst_id="+iid;
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	//System.out.println(rs.getInt(0));
        	userid = new JLabel("User ID");
        	name = new JLabel("Name");
    		phone = new JLabel("Phone Number");
    		dob = new JLabel("Date Of Birth");
    		addr = new JLabel("Address");
    		panel.setLayout(null);
    		name.setBounds(400,150,200,30);
    		userid.setBounds(600,150,200,30);
    		phone.setBounds(800, 150, 200, 30);
    		dob.setBounds(1000, 150, 200, 30);
    		addr.setBounds(1200,150,200, 30);
    		name.setFont(font1);
    		userid.setFont(font1);
    		addr.setFont(font1);
    		phone.setFont(font1);
    		dob.setFont(font1);
    		panel.add(headingLabel);
    		panel.add(name);
    		panel.add(userid);
    		panel.add(addr);
    		panel.add(phone);
    		panel.add(dob);
    		int ptr=50;
            while(rs.next())
            {
            	userid1 = new JLabel(rs.getString(1));
            	name1 = new JLabel(rs.getString(4));
        		phone1 = new JLabel(rs.getString(3));
        		dob1 = new JLabel(rs.getString(8));
        		addr1 = new JLabel(rs.getString(6));
        		
        		name1.setBounds(400,150+ptr,200,30);
        		userid1.setBounds(600,150+ptr,200,30);
        		phone1.setBounds(800, 150+ptr, 200, 30);
        		dob1.setBounds(1000, 150+ptr, 200, 30);
        		addr1.setBounds(1200,150+ptr,200, 30);
        		name1.setFont(font2);
        		userid1.setFont(font2);
        		addr1.setFont(font2);
        		phone1.setFont(font2);
        		dob1.setFont(font2);
        		panel.add(name1);
        		panel.add(userid1);
        		panel.add(addr1);
        		panel.add(phone1);
        		panel.add(dob1);
        		ptr=ptr+50;
            	
            }
            frame.add(panel);
    		frame.setSize(700,700);
    		frame.setLocationRelativeTo(null);
    		frame.setResizable(true);
    		frame.setVisible(true);
    		con.close();
			}catch(Exception ee)
					{
						System.out.println(ee);
					}
			          
     

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListUsers("101");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
