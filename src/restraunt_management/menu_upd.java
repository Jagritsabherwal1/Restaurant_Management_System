package restraunt_management;

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

public class menu_upd extends JFrame implements ActionListener {
	JLabel l1,l2;
	JTextField dish,cost;
	JButton b3,b4;
	public menu_upd() {
		// TODO Auto-generated constructor stub
		setTitle("Manager Access");
		setSize(700,700);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\menu.jpg")));
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("DISH");
		l2 = new JLabel("Cost");
		dish = new JTextField(40);
		cost = new JTextField(40);
		b3 = new JButton("SAVE");
		l1.setFont(new Font("DISH", Font.BOLD, 20));
		l2.setFont(new Font("COST", Font.BOLD, 20));
		
		b3.addActionListener(this);

		l1.setBounds(100,100,100, 50);
		l2.setBounds(100,200,100,50);
		dish.setBounds(250,100,100,50);
		cost.setBounds(250,200,100,50);
		b3.setBounds(100,300,100,50);
		
		c.add(l1); c.add(l2); c.add(b3);c.add(dish); c.add(cost);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		try
		{
			String s1 = dish.getText();
			String s2 = cost.getText();
			String s3 = b3.getActionCommand();	
//			System.out.println(s1+s2+s3+s4);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
	
			if(s3.equals("SAVE"))
			{
				stm.executeUpdate("INSERT into menu values('"+s1+"','"+s2+"')");
				JOptionPane.showMessageDialog(this,"SAVED");
				man_select o=new man_select();
				o.setVisible(true);
			}
			else
			{
				
			}
			
		
	}
		catch (Exception ae)
		{
			System.out.print(ae);
		}

}
	
	

}
