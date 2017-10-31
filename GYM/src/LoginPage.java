
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.SQLException.*;

public class LoginPage implements ActionListener
{
	JFrame frame;
	JPanel mainPanel, headerPanel, middlePanel, footerPanel;
	JLabel usernameLabel,passwordLabel,headingLabel;
	JTextField userField;
	JPasswordField passField;
	JButton loginButton, cancelButton;
	Font font,font1;
	BorderLayout bl;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	String struser,strpass,query,query1,dbuser,dbpass;
	
	public LoginPage() 
	{
		frame = new JFrame("Login Page");
		
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		middlePanel = new JPanel();
		footerPanel = new JPanel();
	
		usernameLabel = new JLabel("Enter Username  ");
		passwordLabel = new JLabel("Enter Password  ");
		font1=new Font("Georgia",Font.BOLD,26);
		usernameLabel.setFont(font1);
		passwordLabel.setFont(font1);
		
		headingLabel = new JLabel("Welcome To LOGIN PAGE");
		font =new Font("Georgia",Font.BOLD,40);
		headingLabel.setFont(font);
		
		userField = new JTextField(10);
		passField = new JPasswordField(10);
		userField.setFont(font1);
		passField.setFont(font1);
	
		loginButton = new JButton("Login");
		cancelButton = new JButton("Cancel");
		loginButton.setFont(font1);
		cancelButton.setFont(font1);
		
		bl = new BorderLayout();
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		mainPanel.setLayout(bl);
		
		mainPanel.add(headerPanel,bl.NORTH);
		mainPanel.add(middlePanel,bl.CENTER);
		mainPanel.add(footerPanel,bl.SOUTH);
		
		headerPanel.add(headingLabel);
		
		middlePanel.setLayout(gbl);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(usernameLabel, gbc);
		middlePanel.add(usernameLabel);
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(userField, gbc);
		middlePanel.add(userField);
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(passwordLabel, gbc);
		middlePanel.add(passwordLabel);
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(passField, gbc);
		middlePanel.add(passField);
		
		footerPanel.add(loginButton);
		footerPanel.add(cancelButton);
		
		loginButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		
		frame.add(mainPanel);
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
              
		
	}
	public static void main(String[] args) 
	{
		new LoginPage();

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginButton)
		{
			if(userField.getText().equals(""))
				JOptionPane.showMessageDialog(middlePanel, "User Field can't be empty");
			if(passField.getText().equals(""))
				JOptionPane.showMessageDialog(middlePanel, "Password Field can't be empty");
		else 
		{
			struser=userField.getText();
			strpass=passField.getText();
			
			if(struser.equals("admin") && strpass.equals("admin"))
			{
				JOptionPane.showMessageDialog(null, "Hey ! Admin, You are successfully logged in!");
				new Admin();
				userField.setText("");
      			passField.setText("");		
			}
			/*if(struser.equals("2") && strpass.equals("2"))
			{
				JOptionPane.showMessageDialog(null, "Hey !Instructor, You are successfully logged in!");
				new Instructor();
				userField.setText("");
      			passField.setText("");		
			}*/
			else 
			{
					try 
					{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                                            
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"  );
                        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");
                        query="select * from User where User_id='"+struser+"' and password ='"+strpass+"'";
                        Statement ps=con.createStatement();
                    	ResultSet rs=ps.executeQuery(query);
                    	//System.out.println(rs.getInt(0));
                        if(rs.next())
                        {
                        	System.out.println("hii");
                            JOptionPane.showMessageDialog(null, "Hey ! User, you are successfully logged in!");
                            
                            new User(struser);
                        }
                        else
                        {
                        	  query1="select * from Instructor where Inst_id='"+struser+"' and password ='"+strpass+"'";
                              ps=con.createStatement();
                          	 rs=ps.executeQuery(query1);
                              if(rs.next())
                              {
                                  JOptionPane.showMessageDialog(null, "Hey ! Instructor , you are successfully logged in!");
                                  new Instructor(struser);
                              }
                              	else
                              		JOptionPane.showMessageDialog(null, "Sorry! Failed to log in.");
                        }
                        con.close();
					}catch(Exception ee){
						System.out.println(ee);
					}
					
                        	userField.setText("");
                        	passField.setText("");
				} 
			}
		}
			else if(e.getSource()==cancelButton)
						frame.dispose();
			}
		}
	
