package restraunt_management;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class customer_login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField username,pass;
	JButton b3,b4;
	customer_login(){
		setTitle("customer_login");
		setSize(750,500);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		ImageIcon imageIcon = new ImageIcon("cust.jpg");
		  l3 = new JLabel(imageIcon);
		  l3.setBounds(160,0,450,130);
		  
		  
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\restr1.jpg")));
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		username = new JTextField(40);
		pass = new JTextField(40);
		b3 = new JButton("Login");
		
		b3.addActionListener(this);

		l1.setBounds(120,170,100, 50);
		l1.setFont(new Font("Username", Font.BOLD, 18));
		l1.setForeground(Color.white);
		l2.setBounds(120,270,100,50);
		l2.setFont(new Font("password", Font.BOLD, 18));
		l2.setForeground(Color.white);
		username.setBounds(290,170,200,50);
		pass.setBounds(290,270,200,50);
		b3.setBounds(100,370,100,50);
		
		c.add(l1); c.add(l2); c.add(b3);c.add(username); c.add(pass);c.add(l3);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		if(m.equals("Login")) {
		try
		{
			String s1 = username.getText();
			String s2 = pass.getText();
			String s3 = b3.getActionCommand();			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select username,password from customer");
			while(rs.next())
			{
				String s4 = rs.getString("username");
				String s5 = rs.getString("password");
				if(s1.equals(s4) && s2.equals(s5))
				{
					customer_success ob = new customer_success();
					ob.setVisible(true);
					JOptionPane.showMessageDialog(this,"done");
					break;
					}
				else {
					JOptionPane.showMessageDialog(this,"Not Found");
				}
				
			}
			
		}
		catch (Exception ae)
		{
			System.out.print(ae);
		}
		
	}
		
	}

}
