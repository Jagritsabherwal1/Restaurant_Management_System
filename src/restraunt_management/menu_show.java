package restraunt_management;

import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class menu_show extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextField dish,cost,show;
	JButton b3,b4;
	menu_show(){
		setTitle("man_login");
		setSize(700,700);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		dish = new JTextField(40);
		cost = new JTextField(40);
		b3 = new JButton("Login");
		show=new JTextField(100);
		b3.addActionListener(this);

		l1.setBounds(100,100,100, 50);
		l2.setBounds(100,200,100,50);
		dish.setBounds(250,100,100,50);
		dish.setBounds(250,200,100,50);
		b3.setBounds(100,300,100,50);
		show.setBounds(200,400,400,300);
		c.add(l1); c.add(l2); c.add(b3);c.add(dish); c.add(cost);c.add(show);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		if(m.equals("Login")) {
		try
		{
			String s1 = dish.getText();
			String s2 = cost.getText();
			String s3 = b3.getActionCommand();			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from menu");
			while(rs.next())
			{
				String s4 = rs.getString("dish");
				String s5 = rs.getString("cost");
				System.out.format("%s, %s\n", s4, s5);
				for(int i=1;i<5;i++) {
					show.setText(s4+"     "+s5);
				}
				
			}
			
		}
		catch (Exception ae)
		{
			System.out.print(ae);
		}
		
	}
		
	}
//	public static void main(String args[]) {
//		new menu_show();
//	}
}
