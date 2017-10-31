import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddStudent implements ActionListener
{
	JFrame frame;
	JPanel mainPanel, headerPanel, middlePanel, footerPanel;
	JLabel usernameLabel,passwordLabel,headingLabel,nameLabel,instruction_label,instructorLabel;
	JTextField userField,nameField;
	JPasswordField passField;
	JButton addButton;
	 String[] Instructorhm=new String[100];  
	 String[] Instid=new String[100];
	 JComboBox cb;
	
	BorderLayout bl;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	Font font1,font2;
	
	public AddStudent() 
	{
		frame = new JFrame("Add New Student");
		
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		middlePanel = new JPanel();
		footerPanel = new JPanel();
	
		
		
try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select max(User_id) from User  order by(User_id)";
            String query1="select Inst_id,name from Instructor  ";
            System.out.println(query);
            Statement ps=con.createStatement();
            Statement ps1=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	if(rs.next())
        	{
        		ResultSet rs1=ps1.executeQuery(query1);
		nameLabel = new JLabel("Enter Name  ");
		usernameLabel = new JLabel("Enter Username  ");
		passwordLabel = new JLabel("Enter Password  ");
		instructorLabel=new JLabel("select Instructor");
		instruction_label=new JLabel("User id value should be suggested not to change");
		font1=new Font("Georgia",Font.BOLD,26);
		font2=new Font("Georgia",Font.BOLD,15);
		usernameLabel.setFont(font1);
		passwordLabel.setFont(font1);
		nameLabel.setFont(font1);
		instructorLabel.setFont(font1);
		instruction_label.setFont(font2);
		nameField = new JTextField(10);
		userField = new JTextField(String.valueOf(rs.getInt(1)+1),10);
		passField = new JPasswordField(10);
	
		 int ctr=0;
			while(rs1.next())
			{
				Instructorhm[ctr]=rs1.getString(1);
				Instid[ctr]=rs1.getString(2);
				System.out.println(Instructorhm[ctr]+Instid[ctr]);
				++ctr;
			}
		
	       
			cb=new JComboBox(Instid); 
		nameField.setFont(font1);
		userField.setFont(font1);
		passField.setFont(font1);
		cb.setFont(font1);
		instruction_label.setBounds(800,600,800,30);
		instructorLabel.setBounds(0, 600, 200, 30);
		cb.setBounds(0, 600,90,20);
		
		addButton = new JButton("Add");
		
		bl = new BorderLayout();
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		mainPanel.setLayout(bl);
		
		mainPanel.add(headerPanel,bl.NORTH);
		mainPanel.add(middlePanel,bl.CENTER);
		frame.add(instruction_label);
		//headerPanel.add(headingLabel);

		
		middlePanel.setLayout(gbl);
		
		gbc.insets=new Insets(4,4,4,4);
		gbc.anchor=GridBagConstraints.WEST;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(nameLabel, gbc);
		middlePanel.add(nameLabel);
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(nameField, gbc);
		middlePanel.add(nameField);
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(usernameLabel, gbc);
		middlePanel.add(usernameLabel);
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(userField, gbc);
		middlePanel.add(userField);
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(passwordLabel, gbc);
		middlePanel.add(passwordLabel);
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(passField, gbc);
		middlePanel.add(passField);
		
		middlePanel.add(instructorLabel);
		middlePanel.add(cb);
		footerPanel.add(addButton);
		
		addButton.addActionListener(this);
		mainPanel.add(footerPanel,bl.SOUTH);
		frame.add(mainPanel);
		
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		con.close();
        	}
}catch(Exception ee)
{
	System.out.println(ee);
}
              	
	}
	public static void main(String[] args) 
	{
		new AddStudent();

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addButton)
		{
			if(userField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"User Field can't be empty");
			else	if(passField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Password Field can't be empty");
			else	if(passField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Name Field can't be empty");
			
			else
			{
				String name1=nameField.getText();
				
				String uid=userField.getText();
				String passwd=new String(passField.getPassword());
				String instid=Instructorhm[cb.getSelectedIndex()];
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
		            
					Statement stmt = con.createStatement();
	      	      
	      	      String sql = "Insert into User(User_id,Password,name,Inst_id,fee_status,status) values(\""+uid+"\",\""+passwd+"\",\""+name1+"\",\""+instid+"\",0,\"active\")";
	      	      System.out.println(sql);
	      	      JOptionPane.showMessageDialog(null, "Data updated successfully");
	      	    frame.dispose();
	      	      stmt.executeUpdate(sql);
	      	    con.close();
					}catch(Exception ee)
					{
						System.out.println(ee);
					}

				
			
			userField.setText("");
			passField.setText("");
			JOptionPane.showMessageDialog(null,"Details added successfully");
			
			}
			
		}
		
	}

}
