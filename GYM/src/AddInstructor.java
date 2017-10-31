import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class AddInstructor implements ActionListener {
	JFrame frame;
	JPanel mainPanel, headerPanel, middlePanel, footerPanel;
	JLabel usernameLabel,passwordLabel,headingLabel,nameLabel,instruction_label,instructorLabel,salaryLabel,dayslotLabel,capacityLabel;
	JTextField userField,nameField,salaryField,dayslotField,capacityField;
	JPasswordField passField;
	JButton addButton;

	BorderLayout bl;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	Font font1,font2;

	public AddInstructor() 
	{
		frame = new JFrame("Add New Instruc3tor");
		
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		middlePanel = new JPanel();
		footerPanel = new JPanel();
		nameLabel = new JLabel("Enter Name  ");
		usernameLabel = new JLabel("Enter Username  ");
		passwordLabel = new JLabel("Enter Password  ");
		salaryLabel=new JLabel("Enter Salary");
		dayslotLabel=new JLabel("Enter Day slot");
		capacityLabel=new JLabel("Enter Capacity");
		instruction_label=new JLabel("User id value should be suggested not to change");
		font1=new Font("Georgia",Font.BOLD,26);
		font2=new Font("Georgia",Font.BOLD,15);
		usernameLabel.setFont(font1);
		passwordLabel.setFont(font1);
		nameLabel.setFont(font1);
		instruction_label.setFont(font2);
		capacityLabel.setFont(font1);
		dayslotLabel.setFont(font1);
		salaryLabel.setFont(font1);
		nameField = new JTextField(10);
		salaryField= new JTextField(10);
		capacityField = new JTextField(10);
		dayslotField = new JTextField(10);
try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
            String query="select max(Inst_id) from Instructor  order by(Inst_id)";
            
            System.out.println(query);
            Statement ps=con.createStatement();
        	ResultSet rs=ps.executeQuery(query);
        	if(rs.next())
        	{
        		
        		userField = new JTextField(String.valueOf(rs.getInt(1)+1),10);
        		
        	}
        	con.close();
}
			catch(Exception e) {
				System.out.println(e);
			}
passField = new JPasswordField(10);

nameField.setFont(font1);
userField.setFont(font1);
passField.setFont(font1);
salaryField.setFont(font1);
dayslotField.setFont(font1);
capacityField.setFont(font1);

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
gbc.gridx=0;
gbc.gridy=3;
gbl.setConstraints(salaryLabel, gbc);
middlePanel.add(salaryLabel);
gbc.gridx=1;
gbc.gridy=3;
gbl.setConstraints(salaryField, gbc);
middlePanel.add(salaryField);
gbc.gridx=0;
gbc.gridy=4;
gbl.setConstraints(dayslotLabel, gbc);
middlePanel.add(dayslotLabel);
gbc.gridx=1;
gbc.gridy=4;
gbl.setConstraints(dayslotField, gbc);
middlePanel.add(dayslotField);
gbc.gridx=0;
gbc.gridy=5;
gbl.setConstraints(capacityLabel, gbc);
middlePanel.add(capacityLabel);
gbc.gridx=1;
gbc.gridy=5;
gbl.setConstraints(capacityField, gbc);
middlePanel.add(capacityField);

System.out.println("hi");



footerPanel.add(addButton);

addButton.addActionListener(this);
mainPanel.add(footerPanel,bl.SOUTH);
frame.add(mainPanel);

frame.setSize(700,700);
frame.setLocationRelativeTo(null);
frame.setResizable(true);
frame.setVisible(true);
        	}
	

	public static void main(String[] args) {
		new AddInstructor();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addButton)
		{
			if(userField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"User Field can't be empty");
			else	if(passField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Password Field can't be empty");
			else	if(nameField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Name Field can't be empty");
			
			else
			{
				String name1=nameField.getText();
				
				String uid=userField.getText();
				String passwd=new String(passField.getPassword());
				String salary=salaryField.getText();
				String dayslot=dayslotField.getText();
				String capacity=capacityField.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
		            
					Statement stmt = con.createStatement();
	      	      
	      	      String sql = "Insert into Instructor(Inst_id,Password,name,dayslot,capacity,salary,appointed_date) values(\""+uid+"\",\""+passwd+"\",\""+name1+"\",\""+dayslot+"\",\""+capacity+"\",\""+salary+"\",current_date())";
	      	      System.out.println(sql);
	      	      JOptionPane.showMessageDialog(null, "Data updated successfully");
	      	    frame.dispose();
	      	      stmt.executeUpdate(sql);
	      	    con.close();
					}catch(Exception ee)
					{
						System.out.println(ee);
						 JOptionPane.showMessageDialog(null, ee);
					}
			}
		}
		
	}

}
