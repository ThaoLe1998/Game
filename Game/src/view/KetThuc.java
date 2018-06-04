package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import template.OptionTemplate;
import model.Model;

public class KetThuc extends OptionTemplate {
	public KetThuc() {
		initGUI();
		addLabels();
		addButtons();
		
	}
	

	public static void main(String[] args) {
		KetThuc kt = new KetThuc();
		kt.setSize(700, 700);
		kt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		kt.setLocation(400, 0);
		kt.setVisible(true);
	}


	@Override
	public void initGUI() {
		// TODO Auto-generated method stub
		setContentPane(new JLabel(new ImageIcon("src/view/game/26.jpg")));
		Container c = getContentPane();
		c.setBackground(Color.black);
		setLayout(null);
		
	}


	@Override
	public void addLabels() {
		// TODO Auto-generated method stub
		JLabel lb = new JLabel("CHÚC MỪNG BẠN!!! ");
		Font font = new Font("Times New Roman", Font.BOLD, 40);
		lb.setFont(font);
		lb.setForeground(Color.red);
		lb.setBounds(150, 200, 600, 80);
		add(lb);
		
	}


	@Override
	public void addButtons() {
		JButton bt = new JButton("BACK");
		bt.setBackground(Color.blue);
		bt.setForeground(Color.red);
		bt.setBounds(300, 550, 150, 30);
		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Model model = new Model();
				Game frame = new Game(model);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				frame.setSize(new Dimension(1000, 700));
				frame.setLocation(100, 10);
				frame.setFont(new Font("Arial", Font.BOLD, 70));
				frame.setForeground(Color.WHITE);

			}
		});
		add(bt);

	}
}
