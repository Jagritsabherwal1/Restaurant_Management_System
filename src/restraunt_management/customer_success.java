package restraunt_management;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class customer_success extends JFrame implements ActionListener {
	customer_success(){
		setTitle("customer_success");
		setSize(700,700);
		setVisible(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		
		JButton b1,b2,b3;
		Container c = getContentPane();
		c.setLayout(null);
		b1 = new JButton("MENU");
		b2= new JButton("BOOKING");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b1.setBounds(100,100,100, 50);
		b2.setBounds(100,300,100,50);
		
		c.add(b1);
		c.add(b2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m=e.getActionCommand();
		if(m.equals("MENU")) {
			menu_show o=new menu_show();
			o.setVisible(true);
		}
	}

}
