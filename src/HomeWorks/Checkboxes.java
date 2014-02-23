package HomeWorks;

import java.applet.Applet;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class Checkboxes extends Applet implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int n = 4;
	static int m = 4;
	static JCheckBox[][] c = new JCheckBox[n][m];
	public Checkboxes() throws HeadlessException {

		{
			setLayout(null);
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					c[i][j] = new JCheckBox();
					c[i][j].setBounds(23 * i, 23 * j, 23, 23);
					c[i][j].setSelected(r.nextBoolean());
					c[i][j].addActionListener(this);
					this.add(c[i][j]);
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox C = (JCheckBox) e.getSource();
		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(C.equals(c[i][j])){
					x = i;
					y = j;
				}
			}
		}
		for(int i = 0; i < n; i++){
			c[i][y].setSelected(!c[i][y].isSelected());
		}
		for(int j = 0; j < m; j++){
			c[x][j].setSelected(!c[x][j].isSelected());
		}
		boolean b = c[0][0].isSelected();
		boolean victory = true;
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				if (c[i][j].isSelected() != b){
					victory = false;
					break;
				}
			}
		}
		if(victory){
			for (int i = 0; i < n; i++){
				for (int j = 0; j < m; j++){
					c[i][j].setVisible(false);
				}
			}
			JLabel v = new JLabel("you win");
			v.setBounds(0, 0, 100, 20);
			add(v);
		}
	}
}
