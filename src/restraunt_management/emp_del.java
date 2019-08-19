package restraunt_management;

import java.awt.Container;
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

public class emp_del extends JFrame implements ActionListener {
	JLabel l1,l2;
	JTextField name,id;
	JButton b3;
	public emp_del() {
		// TODO Auto-generated constructor stub
		setTitle("Employee update");
		setSize(700,450);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\emp2.png")));
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("id");
		l2 = new JLabel("name");
		id = new JTextField(40);
		name = new JTextField(40);
		b3 = new JButton("Delete");
		
		b3.addActionListener(this);

		l1.setBounds(100,50,100, 50);
		l2.setBounds(100,150,100,50);
		id.setBounds(250,50,100,50);
		name.setBounds(250,150,100,50);
		b3.setBounds(100,250,100,50);
		
		c.add(l1); c.add(l2); c.add(b3);c.add(id); c.add(name);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		try
		{
			String s1 = id.getText();
			int i=Integer.parseInt(s1);
			String s2 = name.getText();
			String s4 = b3.getActionCommand();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
	

			
			ResultSet rs = stm.executeQuery("select username,password from manager");
			while(rs.next())
			{
				System.out.println("while");
				String s = rs.getString("id");
				int idd=Integer.parseInt(s);
				String s5 = rs.getString("password");
				if(i==idd && s2.equals(s5))
				{
					man_select ob = new man_select();
					ob.setVisible(true);
					JOptionPane.showMessageDialog(this,"done");
					break;
					}
				else {
					System.out.println("else");
					JOptionPane.showMessageDialog(this,"Not Found");
				}
			
		
	}}
		catch (Exception ae)
		{
			System.out.print(ae);
		}

	}
public static void main(String args[]) {
	new emp_del();
}
}
