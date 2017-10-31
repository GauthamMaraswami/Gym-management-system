
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;  
class MysqlCon  implements ActionListener{ /**
	 * 
	 */
	 Frame f= new Frame("Instructor profileaaaaaa");  
	 JTextField tf1 = new JTextField();  
	  JButton b1 = new JButton("search");  
	private static final long serialVersionUID = 1L;
    MysqlCon(){  
	
	
	  
	
     tf1.setBounds(200,50,150,20); 
   
     b1.setBounds(400,50,100,20);  
     b1.addActionListener(this);  
     f.add(tf1);f.add(b1);
	   
	    f.setSize(800,800);  
	    f.setLayout(null);  
	    f.setVisible(true);  	
	


}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	int no_of_matches=0;
	 String s1=tf1.getText(); 
	 System.out.println(s1);
	 try{ 
		  Label l1,l2,l3;  
	Class.forName("com.mysql.cj.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
	
	Statement stmt=con.createStatement();  
	ResultSet count1=stmt.executeQuery("select count(*) from Instructor where name like\"%"+s1+"%\"");  
	if (count1.next()) {
		no_of_matches=count1.getInt(1);
		System.out.println(no_of_matches);
		 }
	if (no_of_matches==1)
	{
	ResultSet rs=stmt.executeQuery("select * from Instructor where name like\"%"+s1+"%\"");  
	if(rs.next())  {
		f.removeAll();
		f.add(tf1);f.add(b1);
		
		Label l11,l12;
	
		l12=new Label("Profile");  
		l12.setBounds(75,75, 400,30); 
		f.add(l12);
		l11=new Label("ID");  
		l11.setBounds(50,100, 100,30); 
	l1=new Label(rs.getString(1));  
	l1.setBounds(200,100, 100,30); 
	l12=new Label("Name");
	l12.setBounds(50,120, 100,30); 
	f.add(l12);f.add(l11);
	l2=new Label(rs.getString(3));  
	l2.setBounds(200,120, 100,30);  
	l11=new Label("Phone");  
	l11.setBounds(50,140, 100,30); 
	l3=new Label(rs.getString(4));  
	l3.setBounds(200,140, 100,30); 
	f.add(l3);f.add(l11);
	l11=new Label("address");  
	l11.setBounds(50,160, 100,30); 
	l3=new Label(rs.getString(5));  
	l3.setBounds(200,160, 100,30); 
	f.add(l3);f.add(l11);
	l11=new Label("dayslot");  
	l11.setBounds(50,180, 100,30); 
	l3=new Label(rs.getString(6));  
	l3.setBounds(200,180, 100,30); 
	f.add(l3);f.add(l11);
	l11=new Label("salary");  
	l11.setBounds(50,200, 100,30); 
	l3=new Label(rs.getString(7));  
	l3.setBounds(200,200, 100,30); 
	f.add(l3);f.add(l11);
	l11=new Label("Capacity");  
	l11.setBounds(50,220, 100,30); 
	l3=new Label(rs.getString(8));  
	l3.setBounds(200,220, 100,30); 
	f.add(l3);f.add(l11);
	l11=new Label("Appointed Date");  
	l11.setBounds(50,240, 100,30); 
	l3=new Label(rs.getString(9));  
	l3.setBounds(200,240, 100,30); 
	f.add(l3);f.add(l11);
	
	
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  

	f.add(l1); f.add(l2);  
	}
	con.close();  
	}
	if(no_of_matches==0)
	{
		f.removeAll();
		f.add(tf1);f.add(b1);
		   
	    f.setSize(800,800);  
	    
	    f.setLayout(null);  
	    f.setVisible(true); 
	    l3=new Label("no Instructors found");  
		l3.setBounds(50,150, 300,30);
		f.add(l3 );
	}
	if(no_of_matches>1)
	{
		ResultSet rs=stmt.executeQuery("select * from Instructor where name like\"%"+s1+"%\"");
		f.removeAll();
		Label l12;
		l12=new Label("Oh there are more than one Instructors with that name");  
		l12.setBounds(75,75, 400,30); 
		f.add(l12);
		f.add(tf1);f.add(b1);
		System.out.println("tar");
		int ctr=0;
		while(rs.next())  {
			Label l11;
			l11=new Label("Id");  
			l11.setBounds(50,100+ctr*20, 100,30); 
			l3=new Label(rs.getString(1));  
			l3.setBounds(200,100+ctr*20, 100,30); 
			f.add(l3);f.add(l11);
			l11=new Label("Name");  
			l11.setBounds(250,100+ctr*20, 100,30); 
			l3=new Label(rs.getString(3));  
			l3.setBounds(300,100+ctr*20, 100,30); 
			f.add(l3);f.add(l11);
			System.out.println(rs.getString(1));  
			++ctr;
		
			}
	}
	}catch(Exception e){ System.out.println(e);}  
	 
	
}
public static void main(String[] args) {  
    new MysqlCon();  
}
}  