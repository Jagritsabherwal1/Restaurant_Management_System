package restraunt_management;


import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class man_select extends JFrame implements ActionListener {
	JRadioButton rb1,rb2;    
	JButton b1,b2,b3;    
	man_select(){
		setTitle("man_select");
		setSize(700,700);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setContentPane(new JLabel(new ImageIcon("D:\\restraunt_management\\edit.png")));
		Container c = getContentPane();
		c.setLayout(null);
		
	        b1=new JButton("MENU");
	        b2=new JButton("EMPLOYEE");
	        b3=new JButton("CUSTOMER");
	        b1.setBounds(100,400,100,50);
	        b2.setBounds(250,400,100,50);
	        b3.setBounds(400,400,100,50);
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        
	        c.add(b1);
	        c.add(b2);
	        c.add(b3);
		rb1=new JRadioButton("UPDATE");    
		rb1.setBounds(100,100,100,30);      
		rb2=new JRadioButton("DELETE");    
		rb2.setBounds(100,150,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);bg.add(rb2);    
		c.add(rb1);c.add(rb2);    
}

	public void actionPerformed(ActionEvent e){ 
		String m=e.getActionCommand();
		if(rb1.isSelected() && m.equals("MENU")){   
			menu_upd ob=new menu_upd();
			ob.setVisible(true);
		   
		}    
		else if(rb2.isSelected() && m.equals("MENU")){    
		   menu_del o3=new menu_del();
		   o3.setVisible(true);
		}   
		else if(rb1.isSelected() && m.equals("EMPLOYEE")) {
			emp_upd o=new emp_upd();
			o.setVisible(true);
		}
		else if(rb2.isSelected() && m.equals("EMPLOYEE")) {
			emp_del o2=new emp_del();
			o2.setVisible(true);
		}
		else if(rb1.isSelected() && m.equals("CUSTOMER")){
			
		}
		else if(rb2.isSelected() && m.equals("CUSTOMER")) {
			
		}
		else {
			
		}
		}    
//	public static void main(String args[]) {
//		 new man_select();
//	}
}
