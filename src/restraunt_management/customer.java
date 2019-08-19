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

public class customer extends JFrame implements ActionListener{
	customer(){
		setTitle("customer");
		setSize(700,700);
		setVisible(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\restaurant.png")));
		JButton b1,b2,b3;
		Container c = getContentPane();
		c.setLayout(null);
		b1 = new JButton("LOGIN");
		b2= new JButton("SIGN-UP");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b2.setBounds(250,390,100,50);
		b1.setBounds(250,80,90,50);
		c.add(b1);
		c.add(b2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		String s1 = e.getActionCommand();
		if(s1.equals("LOGIN"))
		{
			customer_login ob2 = new customer_login();
			ob2.setVisible(true);
		}
		else if(s1.equals("SIGN-UP"))
		{
			customer_signup ob4 = new customer_signup();
			ob4.setVisible(true);
		}
		else 
		{
			customer_success ob = new customer_success();
			ob.setVisible(true);
		}
				
	}

}
