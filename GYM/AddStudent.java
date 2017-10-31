import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddStudent implements ActionListener
{
	JFrame frame;
	JPanel mainPanel, headerPanel, middlePanel, footerPanel;
	JLabel usernameLabel,passwordLabel,headingLabel,nameLabel;
	JTextField userField,nameField;
	JPasswordField passField;
	JButton addButton;
	
	BorderLayout bl;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	Font font1;
	
	public AddStudent() 
	{
		frame = new JFrame("Add New Student");
		
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		middlePanel = new JPanel();
		footerPanel = new JPanel();
	
		nameLabel = new JLabel("Enter Name  ");
		usernameLabel = new JLabel("Enter Username  ");
		passwordLabel = new JLabel("Enter Password  ");
		
		font1=new Font("Georgia",Font.BOLD,26);
		usernameLabel.setFont(font1);
		passwordLabel.setFont(font1);
		nameLabel.setFont(font1);
		
		nameField = new JTextField(10);
		userField = new JTextField(10);
		passField = new JPasswordField(10);
		nameField.setFont(font1);
		userField.setFont(font1);
		passField.setFont(font1);
		
		
		addButton = new JButton("Add");
		
		bl = new BorderLayout();
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		mainPanel.setLayout(bl);
		
		mainPanel.add(headerPanel,bl.NORTH);
		mainPanel.add(middlePanel,bl.CENTER);
		mainPanel.add(footerPanel,bl.SOUTH);
		
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
		
		
		footerPanel.add(addButton);
		
		addButton.addActionListener(this);
		
		frame.add(mainPanel);
		
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
              	
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
				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:MyFirstDsn");
				CallableStatement cl=con.prepareCall("{Call addstudent1(?,?,?)}");
	

				cl.setString(1,nameField.getText());
				cl.setString(2,userField.getText());
				cl.setString(3,passField.getText());
			
				cl.executeQuery();
			}catch(Exception ee) { }
			userField.setText("");
			passField.setText("");
			JOptionPane.showMessageDialog(null,"Details added successfully");
			
			}
			
		}
		
	}

}
