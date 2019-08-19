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

public class emp_upd extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField id,name,joining;
	JButton b3,b4;
	public emp_upd() {
		// TODO Auto-generated constructor stub
		setTitle("Employee update");
		setSize(700,450);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\em.jpg")));
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("id");
		l1.setFont(new Font("id", Font.BOLD, 22));
		
		l2 = new JLabel("name");
		l2.setFont(new Font("Name", Font.BOLD, 22));
		
		l3 =new JLabel("Joining Date");
	
		l3.setFont(new Font("Joining  Date", Font.BOLD, 20));
		id = new JTextField(40);
		name = new JTextField(40);
		joining = new JTextField(40);
		b3 = new JButton("Save");
		
		b3.addActionListener(this);

		l1.setBounds(150,50,170, 50);
		l2.setBounds(150,150,170,50);
		l3.setBounds(150,250,170,50);
		id.setBounds(300,50,170,50);
		name.setBounds(300,150,170,50);
		joining.setBounds(300,250,170,50);
		b3.setBounds(150,320,70,50);
		
		c.add(l1); c.add(l2);c.add(l3); c.add(b3);c.add(id); c.add(name);c.add(joining);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		try
		{
			String s1 = id.getText();
			String s2 = name.getText();
			String s3 =joining.getText();
			String s4 = b3.getActionCommand();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
	
			if(s4.equals("Save"))
			{
				System.out.println(s4);
				stm.executeUpdate("INSERT into employee values('"+s1+"','"+s2+"','"+s3+"')");
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
//	public static void main(String args[]) {
//		new emp_upd();
//	}
}
