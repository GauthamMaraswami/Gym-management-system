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

public class UserMonthly implements ActionListener{

	String uid;
	JFrame frame2;
	JFrame frame1;
	JPanel panel2,panel1;
	JButton view,reset;
	Font font1,font2,font3;
	JLabel headingLabel, uid1,calories,name1,uid2,name2,Inst1,Inst2,fs1,fs2,rank1,rank2,heading1,id1,date1,time1,calories1,id2,date2,time2,calories2;
	JTextField time;
	public UserMonthly(String user)
	{
		uid=user;
		font1=new Font("Georgia",Font.BOLD,20);
		font2 = new Font("Georgia",Font.BOLD,15);
		font3 = new Font("Georgia",Font.BOLD,35);
		frame2 = new JFrame("Monthly Reports");
		panel2 = new JPanel();
		heading1 = new JLabel("Monthly Reports  ");
		heading1.setBounds(750, 150, 500, 30);
		heading1.setFont(font3);
		id1=new JLabel("id");
		id1.setBounds(200, 200, 200, 30);
		id1.setFont(font1);
		uid1=new JLabel(" User id");
		uid1.setBounds(400, 200, 200, 30);
		uid1.setFont(font1);
		name1=new JLabel(" Name");
		name1.setBounds(600, 200, 200, 30);
		name1.setFont(font1);
		Inst1=new JLabel("Instructor Name");
		Inst1.setBounds(800, 200, 200, 30);
		Inst1.setFont(font1);
		date1=new JLabel("Month");
		date1.setBounds(1000, 200, 200, 30);
		calories1=new JLabel("calories");
		calories1.setBounds(1200, 200, 200, 30);
		fs1=new JLabel("food suggestions");
		fs1.setBounds(1400, 200, 200, 30);
		rank1=new JLabel("Rank");
		rank1.setBounds(1600, 200, 200, 30);
		rank1.setFont(font1);
		fs1.setFont(font1);
		date1.setFont(font1);
		rank1.setFont(font1);
		calories1.setFont(font1);
		panel2.add(Inst1);
		panel2.add(uid1);
		panel2.add(name1);
		panel2.setLayout(null);
		panel2.add(heading1);
		panel2.add(id1);
		panel2.add(date1);
		panel2.add(fs1);
		panel2.add(rank1);
		panel2.add(calories1);
		try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select D.id,U.name,D.uid,D.month,D.tot_calories,D.food_suggestions,I.name,D.rank from Monthly_report as D,User as U,Instructor as I where  D.uid=U.User_id and U.User_id="+uid+" and U.Inst_id=I.Inst_id order by D.month desc,D.rank ";
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	int ptr=50;
        	while(rs.next()) {
        		
        		id2=new JLabel(rs.getString(1));
    			id2.setBounds(200, 200+ptr, 200, 30);
    			id2.setFont(font2);
    			uid2=new JLabel(rs.getString(3));
    			uid2.setBounds(400, 200+ptr, 200, 30);
    			uid2.setFont(font2);
    			name2=new JLabel(rs.getString(2));
    			name2.setBounds(600, 200+ptr, 200, 30);
    			name2.setFont(font2);
    			Inst2=new JLabel(rs.getString(7));
    			Inst2.setBounds(800, 200+ptr, 200, 30);
    			Inst2.setFont(font1);
    			date2=new JLabel(rs.getString(4));
    			date2.setBounds(1000, 200+ptr, 200, 30);
    			fs2=new JLabel(rs.getString(6));
    			fs2.setBounds(1400, 200+ptr, 200, 30);
    			calories2=new JLabel(rs.getString(5));
    			calories2.setBounds(1200, 200+ptr, 200, 30);
    			rank2=new JLabel(rs.getString(8));
    			rank2.setBounds(1600, 200+ptr, 200, 30);

    			
    			
    			panel2.add(rank2);
    			panel2.add(Inst2);
    			panel2.add(id2);
    			panel2.add(uid2);
    			panel2.add(name2);
    			panel2.add(date2);
    			panel2.add(fs2);
    			panel2.add(calories2);
    			  
        		ptr+=50;
        	}
        	con.close();
		}catch(Exception ee)
		{
			System.out.println(ee);
		}
		
		
		frame2.add(panel2);
		frame2.setSize(700,700);
		frame2.setLocationRelativeTo(null);
		frame2.setResizable(true);
		frame2.setVisible(true);
		
	
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserMonthly("1");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
