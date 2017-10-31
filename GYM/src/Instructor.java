import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Instructor implements ActionListener 
{
	JFrame frame;
	JPanel panel;
	JButton b1,b2,b3,b4,b5,b6;
	Font font1,font2;
	JLabel headingLabel;
	String iid;
	public Instructor(String Inst) 
	{
		iid=Inst;
		frame = new JFrame("Instructor");
		panel = new JPanel();
		b1 = new JButton("Update Profile");
		b2 = new JButton("List Users");
		b3 = new JButton("Check Daily Report");
		b4 = new JButton("Check Monthly Report");
		b6 = new JButton("Log Out");
		headingLabel = new JLabel("Welcome Instructor");
		
		font1=new Font("Georgia",Font.BOLD,20);
		font2 = new Font("Georgia",Font.BOLD,50);
		
		panel.setLayout(null);
		
		b1.setFont(font1);
		b2.setFont(font1);
		b3.setFont(font1);
		b4.setFont(font1);
	
		b6.setFont(font1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b6.addActionListener(this);
		
		b1.setBounds(400,200,450,100);
		b2.setBounds(1050,200,450,100);
		b3.setBounds(400,500,450,100);
		b4.setBounds(1050,500,450,100);
		b6.setBounds(750,800,450,100);
		headingLabel.setBounds(670,0,650,90);
		headingLabel.setFont(font2);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b6);
		panel.add(headingLabel);
		
		frame.add(panel);
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		
		
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Instructor("101");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new InstructorProfile(iid);
		}
		if(e.getSource()==b6)
		{
			frame.dispose();
		}
		if(e.getSource()==b2)
		{
			new ListUsers(iid);
		}
		if(e.getSource()==b3)
		{
			new CheckUserDaily(iid);
		}
		if(e.getSource()==b4)
		{
			new InstructorMonthly(iid);
		}
	}

}
