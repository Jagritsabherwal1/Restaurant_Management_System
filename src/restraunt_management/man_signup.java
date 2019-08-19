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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class man_signup extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField username,pass,name;
	JButton b3,b4;
	man_signup(){
		setTitle("Man_singnup");
		setSize(500,500);
		setVisible(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\mansign.jpg")));
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("Username");
		l1.setFont(new Font("Username", Font.BOLD, 18));
		l1.setForeground(Color.white);
		l2 = new JLabel("Password");
		l2.setFont(new Font("Password", Font.BOLD, 18));
		l2.setForeground(Color.white);
		l3 = new JLabel("Name");
		l3.setFont(new Font("N", Font.BOLD, 18));
		l3.setForeground(Color.white);
		username = new JTextField(40);
		pass = new JTextField(40);
		name = new JTextField(40);
		b3 = new JButton("CONFIRM");
		b4 = new JButton("Go back to Login");
		
		b3.addActionListener(this);
		b4.addActionListener(this);
		l3.setBounds(100,300,100,50);
		name.setBounds(250,300,100,50);

		l1.setBounds(100,100,100, 50);
		l2.setBounds(100,200,100,50);
		username.setBounds(250,100,100,50);
		pass.setBounds(250,200,100,50);
		b3.setBounds(100,400,100,50);
		b4.setBounds(250,400, 150, 50);
		
		c.add(l1); c.add(l2); c.add(b3);c.add(username); c.add(pass);c.add(b4);c.add(l3);c.add(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		if(m.equals("CONFIRM")) {
			String s1 = username.getText();
			String s2 = pass.getText();
			String s4 = name.getText();
			if(s1.equals("")&&s2.equals("")&&s4.equals("")) {
				JOptionPane.showMessageDialog(this,"NO VALUES");
			}
			else {
			try
		{
			
			String s3 = b3.getActionCommand();		
			System.out.println(s1+s2+s3+s4);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
	
			if(s3.equals("CONFIRM"))
			{
				stm.executeUpdate("INSERT into manager values('"+s4+"','"+s1+"','"+s2+"')");
				man_login ob1 = new man_login();
				ob1.setVisible(true);
			}
		
			
		
	}
		catch (Exception ae)
		{
			JOptionPane.showMessageDialog(this,ae);
		}}}
	else {
		
		man_login ob2=new man_login();
		ob2.setVisible(true);
}
}}