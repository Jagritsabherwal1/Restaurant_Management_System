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

public class menu_del extends JFrame implements ActionListener {
	JLabel l1;
	JTextField dish;
	JButton b3;
	public menu_del() {
		// TODO Auto-generated constructor stub
		setTitle("MENU del");
		setSize(700,700);	
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\restr.jpg")));
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("dish");
		l1.setFont(new Font("D", Font.BOLD, 18));
		l1.setForeground(Color.white);
		
		dish = new JTextField(40);
		
		b3 = new JButton("Delete");
		
		b3.addActionListener(this);

		l1.setBounds(100,100,100, 50);
		dish.setBounds(200,100,100,50);
		b3.setBounds(100,400,100,50);
		
		c.add(l1); c.add(b3); c.add(dish);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		try
		{
			String s1 = dish.getText();
			String s4 = b3.getActionCommand();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
	
			if(s4.equals("Delete"))
			{
				System.out.println(s4);
				stm.executeUpdate("DELETE from menu where dish='"+s1+"'");
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
			JOptionPane.showMessageDialog(this,ae);
		}

	}
//public static void main(String args[]) {
//	new menu_del();
//	
//}
}