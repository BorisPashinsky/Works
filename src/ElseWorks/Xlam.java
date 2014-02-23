package ElseWorks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;

@SuppressWarnings({ "serial",})
public class Xlam extends JApplet implements ActionListener {
	JCheckBox[][] cb;
	ButtonGroup group = new ButtonGroup();
	JLabel number = new JLabel("Введите размер поля:");
	JLabel victory = new JLabel("Поздравляю, вы выиграли! Очень за вас рад");
	JButton ok = new JButton("ОК");
	JTextPane tp = new JTextPane();
	int n = 0;
	boolean flag = true;
	{
		number.setBounds(0, 100, 150, 50);
		ok.setBounds(300, 100, 50, 50);
		tp.setBounds(200, 110, 50, 20);
		ok.addActionListener(this);
		this.add(number);
		this.add(ok);
		this.add(tp);
		this.setLayout(null);
		this.validate();
		this.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		if (ok == e.getSource()){
			String s = tp.getText();
			n = Integer.parseInt(s);
			cb = new JCheckBox[n][n];
			number.setVisible(false);
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cb[i][j] = new JCheckBox();
					cb[i][j].setSelected(r.nextBoolean());
					cb[i][j].setBounds(50*i + 20, 50*j + 80, 50, 50);
					cb[i][j].addActionListener(this);
					this.add(cb[i][j]);
				}
				this.validate();
				this.repaint();
			}
			ok.setVisible(false);
			tp.setVisible(false);
		} else {
			JCheckBox pr = (JCheckBox) e.getSource();
			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (cb[i][j] == pr){
						a = i;
						b = j;
						break;
					}
				}
			}
			for (int k = 0; k < n; k++){
				if (cb[k][b].isSelected() == false){
					cb[k][b].setSelected(true);
				} else {
					cb[k][b].setSelected(false);
				}
				if (cb[a][k].isSelected() == false){
					cb[a][k].setSelected(true);
				} else {
					cb[a][k].setSelected(false);
				}
			}
			for (int x = 0; x < n; x++){
				for (int y = 0; y < n; y++){
					if (cb[x][y].isSelected() == false){
						flag = false;
						break;
					}
				}
			}
			if (flag == true){
				for (int x = 0; x < n; x++){
					for (int y = 0; y < n; y++){
						cb[x][y].setVisible(false);
					}
				}
				victory.setBounds(20, -100, 400, 400);
				this.add(victory);
			}
			flag = true;
		}
	}
}
