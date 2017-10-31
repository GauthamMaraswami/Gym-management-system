import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class ListUserProfile implements ActionListener
{
	JFrame frame;
	JPanel panel;
	Font font1,font2,font3;
	JLabel headingLabel;
	JLabel name,userid,inst,age,dob,addr,phone;
	JLabel name1,userid1,dob1,addr1,phone1;
	JButton b1;
	
	
	public ListUserProfile()
	{
		frame = new JFrame("Instructor");
		panel = new JPanel();
		headingLabel = new JLabel("List of Users  ");
		headingLabel.setBounds(750, 150, 1000, 30);
		b1 = new JButton("Search");
	font1=new Font("Georgia",Font.BOLD,20);
	font2 = new Font("Georgia",Font.BOLD,15);
	font3 = new Font("Georgia",Font.BOLD,35);
	headingLabel.setFont(font3);
	b1.setFont(font1);
	b1.addActionListener(this);
	b1.setBounds(750,50,200,50);
		panel.setLayout(null);
	try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select User_id,name from User ";
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	userid = new JLabel("User ID");
        	name = new JLabel("Name");
        	name.setBounds(700,200,200,30);
    		userid.setBounds(1000,200,200,30);
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
                   	name1.setBounds(700,200+ptr,200,30);
            		userid1.setBounds(1000,200+ptr,200,30);
            		name1.setFont(font2);
            		userid1.setFont(font2);
            		panel.add(name1);
            		panel.add(userid1);
            		ptr=ptr+50;
                	
            }
        	panel.add(b1);
            frame.add(panel);
    		frame.setSize(700,700);
    		frame.setLocationRelativeTo(null);
    		frame.setResizable(true);
    		frame.setVisible(true);
    		con.close();
	}catch(Exception e) {
		System.out.println(e);}
	}
	

	public static void main(String[] args) {
		new ListUserProfile();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			new UserDetail();
		}
		
	}

}
