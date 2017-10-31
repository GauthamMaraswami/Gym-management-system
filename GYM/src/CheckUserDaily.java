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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckUserDaily implements ActionListener {
	JFrame frame;
	JFrame frame1;
	JPanel panel,panel1;
	JButton add,generate,b3,b4,b5,b6;
	Font font1,font2,font3;
	JLabel headingLabel, uid1,calories,name1,uid2,name2,enter_calories,m,c,heading1,id1,date1,time1,calories1,id2,date2,time2,calories2;
	JTextField time;
	String iid;
	public CheckUserDaily(String Instructor) {
		font1=new Font("Georgia",Font.BOLD,20);
		font2 = new Font("Georgia",Font.BOLD,15);
		font3 = new Font("Georgia",Font.BOLD,35);
		iid=Instructor;
		frame1 = new JFrame("Your Students Daily Reports");
		panel1 = new JPanel();
		heading1 = new JLabel("Your Students Daily Reports  ");
		heading1.setBounds(650, 150, 1000, 30);
		heading1.setFont(font3);
		id1=new JLabel("id");
		id1.setBounds(400, 200, 200, 30);
		id1.setFont(font1);
		uid1=new JLabel(" User id");
		uid1.setBounds(600, 200, 200, 30);
		uid1.setFont(font1);
		name1=new JLabel(" Name");
		name1.setBounds(800, 200, 200, 30);
		name1.setFont(font1);
		date1=new JLabel("Date");
		date1.setBounds(1000, 200, 200, 30);
		time1=new JLabel("time");
		time1.setBounds(1200, 200, 200, 30);
		calories1=new JLabel("calories");
		calories1.setBounds(1400, 200, 200, 30);
		date1.setFont(font1);
		time1.setFont(font1);
		calories1.setFont(font1);
		panel1.add(uid1);
		panel1.add(name1);
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
            String query="select D.id,U.name,D.uid,D.date_of_report,D.calories_burnt,D.time_spent from Daily_report as D,User as U where U.Inst_id= "+iid+" and D.uid=U.User_id order by(D.date_of_report) desc ,D.calories_burnt desc";
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	int ptr=50;
        	while(rs.next()) {
        		id2=new JLabel(rs.getString(1));
    			id2.setBounds(400, 200+ptr, 200, 30);
    			id2.setFont(font2);
    			uid2=new JLabel(rs.getString(3));
    			uid2.setBounds(600, 200+ptr, 200, 30);
    			uid2.setFont(font2);
    			name2=new JLabel(rs.getString(2));
    			name2.setBounds(800, 200+ptr, 200, 30);
    			name2.setFont(font2);
    			date2=new JLabel(rs.getString(4));
    			date2.setBounds(1000, 200+ptr, 200, 30);
    			time2=new JLabel(rs.getString(6));
    			time2.setBounds(1200, 200+ptr, 200, 30);
    			calories2=new JLabel(rs.getString(5));
    			calories2.setBounds(1400, 200+ptr, 200, 30);
    			date2.setFont(font2);
    			time2.setFont(font2);
    			calories2.setFont(font2);
    			panel1.add(id2);
    			panel1.add(uid2);
    			panel1.add(name2);
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
		
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new CheckUserDaily("101");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
