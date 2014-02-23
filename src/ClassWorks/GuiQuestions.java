package ClassWorks;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class GuiQuestions extends Applet implements ActionListener{
	int i = 0;
	int n;
	boolean[] b = new boolean[4];
	JButton J = new JButton();
	JCheckBox[] c = new JCheckBox[4];
	int k = 0;
	String[] s = new String[n * 9];
	public GuiQuestions() throws HeadlessException, IOException {
		{
			setLayout(new FlowLayout());
			Scanner in = new Scanner(new File("C:/Борка/Works/src/ClassWorks/questions.txt"));
			n = in.nextInt();
			System.out.println(n);
			JLabel[] a = new JLabel[n];
			for(int j = 0; j < n * 9;j++){
				System.out.println(",h");
				s[j] = in.nextLine();				
			}
			//CheckBox ButtonGroup
			//RadioButton
			a[i] = new JLabel(s[i]);
			this.add(a[i]);
			for(int j = 0;j < b.length;j++){
				b[j] = s[i + 1 + 2 * j].equals("true");
			}
			for(int j = 0; j < b.length; j++){
				c[j] = new JCheckBox(s[i + 2 + 2 * j]);
			}
			J.addActionListener(this);
			in.close();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton C = (JButton) e.getSource();
		if(C.equals(J)){
			boolean t = true;
			
			for(int j = 0; j < b.length;j++){
				if(c[j].isSelected() != b[j]){
					t = false;
					break;
				}
			}
			if(t){
				k +=2;
			}
			i += 9;
			for(int j = 0;j < b.length;j++){
				b[j] = s[i + 1 + 2 * j].equals("true");
			}
			for(int j = 0; j < b.length; j++){
				c[j].setText(s[i + 2 + 2 * j]);
			}
		}
	}

}
