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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;


public class menu_table extends JFrame implements ActionListener{
	JTable t;
	JLabel l1;
	JButton b;
	JTextField t1,t2;
	int sum=0;
	
	menu_table(){
		setTitle("customer_signup");
		setSize(800,570);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		String col[] = {"DISH","COST"};
	
		DefaultTableModel model=new DefaultTableModel(col,0);
		Container c = getContentPane();
		t1=new JTextField(80);
		t2=new JTextField(80);
		b=new JButton("Add");
		l1=new JLabel("Dish");
		t1.setBounds(120, 540, 100, 100);
		l1.setBounds(50,540,100,100);
		b.setBounds(260,540,100,100);
		t2.setBounds(190, 540, 100, 100);
		t2.setEditable(false);
		c.add(l1);
		c.add(t1);
		c.add(t2);
		c.add(b);
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM restraunt.menu");
		while(rs.next()) {
			String s1 = rs.getString("dish");
			int i = rs.getInt("cost");
			Object data [] = {s1,i};
			t = new JTable(model);
			
			 model.addRow(data);
			 
		}
		
		t.setBounds(100,100, 100,100);
		
		
		
		c.add(t);
		
	}
		catch(Exception ae) {
			JOptionPane.showMessageDialog(this,ae);
		}
	}
	public static void main(String s[]) {
		new menu_table();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String h = e.getActionCommand();
		if(h.equals("Add")) {
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restraunt","root","root");
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM restraunt.menu");
			
			while(rs.next())
			{
				String s5 = t1.getText();
				String s4 = rs.getString("dish");
				int i2 = rs.getInt("cost");
				while(rs.next()) {
				if(s5.equalsIgnoreCase(s4)) {
				sum+=i2;
				}
				}
				String a=Integer.toString(sum);
				t2.setText(a);
			}
			
		}catch(Exception l) {
			System.out.println(l);
			}
		}
		}
		
	}


