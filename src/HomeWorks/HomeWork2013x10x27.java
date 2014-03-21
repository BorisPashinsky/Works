package HomeWorks;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeWork2013x10x27 extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton q1;
	JButton q2;
	JLabel a;
	ActionListener al;
	int i;
	{
		this.setLayout(null);
		q1 = new JButton("¬верх");
		q2 = new JButton("¬низ");
		i = 0;
		a = new JLabel("" + i);
		q1.setBounds(25,25,75,50);
		q2.setBounds(25,75,75,50);
		a.setBounds(100,50,75,50);
		add(q1);
		add(q2);
		add(a);
		al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = ((JButton)e.getSource()).getText();
				if(name.equals("¬верх")){
					q1.setBounds(25,q1.getBounds().y - 10,75,50);
					q2.setBounds(25,q2.getBounds().y - 10,75,50);
					i++;
					a.setText("" + i);
				}else{
					q1.setBounds(25,q1.getBounds().y + 10,75,50);
					q2.setBounds(25,q2.getBounds().y + 10,75,50);
					i--;
					a.setText("" + i);
				}
			}
		};
		q1.addActionListener(al);
		q2.addActionListener(al);
	}
}