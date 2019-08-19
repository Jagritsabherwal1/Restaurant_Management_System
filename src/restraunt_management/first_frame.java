package restraunt_management;

import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class first_frame extends JFrame implements ActionListener {
	first_frame(){
		setTitle("welcome");
		setSize(700,500);
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		JLabel l1;
		ImageIcon imageIcon = new ImageIcon("1.jpg");
		  l1 = new JLabel(imageIcon);
		  l1.setBounds(160,0,330,130);
		  
		  setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\food.jpg")));
		 
		  JButton b1,b2;
		Container c = getContentPane();
		c.setLayout(null);
		b1 = new JButton("MANAGER");
		b2= new JButton("CUSTOMER");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.setBounds(250,250,100, 50);
		b2.setBounds(250,350,100,50);
		
		c.add(b1);
		c.add(b2);
		c.add(l1);
		setVisible(true);

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s1 = e.getActionCommand();
		if(s1.equals("MANAGER"))
		{
			man ob = new man();
			ob.setVisible(true);
		}
		else
		{
			customer ob1 = new customer();
			ob1.setVisible(true
					);
		}
	}
	public static void main(String s[])
	{
		new first_frame();
	}
	
}


	

