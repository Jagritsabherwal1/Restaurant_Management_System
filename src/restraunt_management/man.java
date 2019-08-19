package restraunt_management;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class man extends JFrame implements ActionListener{
	man(){
		setTitle("man");
		setSize(460,270);
		setVisible(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
			
		});
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\emp.jpg")));
		JLabel l1,l2;
		JTextField t1,t2;
		JLabel l5;
		JButton b1,b2;
		
		
		JButton b3,b4;
		Container c = getContentPane();
		c.setLayout(null);
//		l1 = new JLabel("Username");
//		l2 = new JLabel("Password");
//		t1 = new JTextField(40);
//		t2 = new JTextField(40);
		b3 = new JButton("Login");
		b4 = new JButton("Sign-Up");
		b3.addActionListener(this);
		b4.addActionListener(this);
//		l1.setBounds(100,100,300, 50);
//		l2.setBounds(100,200,300,50);
//		t1.setBounds(250,100,250,50);
//		t2.setBounds(250,200,250,50);
		b3.setBounds(290,150,70,50);
		b4.setBounds(280,50,90,50);
//		c.add(l1); c.add(l2); 
		c.add(b3); c.add(b4);
//		c.add(t1); c.add(t2);
		
				}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		String s1 = e.getActionCommand();
		if(s1.equals("Login"))
		{
			man_login ob2 = new man_login();
			ob2.setVisible(true);
		}
		else
		{
			man_signup ob4 = new man_signup();
			ob4.setVisible(true);
		}
		
	}
}
