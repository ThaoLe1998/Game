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
import javax.swing.JTextArea;

import template.OptionTemplate;
import model.Model;
import controler.Controller;

public class Help extends OptionTemplate {
public Help() {
	initGUI();
	addLabels();
	addButtons();
	setSize(900, 750);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocation(200, 0);
	setVisible(true);
}
	
public static void main(String[] args) {
	Help hp= new Help();
	hp.setSize(900, 750);
    hp. setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    hp.setLocation(200, 0);
	hp.setVisible(true);
}

@Override
public void initGUI() {
	// TODO Auto-generated method stub
	setContentPane(new JLabel(new ImageIcon("src/view/game/nen.jpg")));
	Container c= getContentPane();
	c.setBackground(Color.black);
	setLayout(null);
	}

@Override
public void addLabels() {
	// TODO Auto-generated method stub

	JLabel lb= new JLabel("HELP");
	Font font= new Font("HELP",Font.ITALIC, 40);
	lb.setFont(font);
	lb.setForeground(Color.red);
	lb.setBounds(300, 0, 500, 50);
	add(lb);
	
	JTextArea lb2=new JTextArea("Instructions: \n\n+ nhấn vào Start Game để bắt đầu chơi.\n\n" + 
			"+ Click vào nút Start thì các hình ảnh bắt đầu tuần tự hiện lên \n\n" + 
			"   để người chơi có thể ghi nhớ vị trí của những cặp hình giống nhau\n\n" + 
			"+ Người chơi chọn 1 ví trí và nhấn vào hình , hình sẽ được lật lên,\n\n" + 
			"   nhiệm vụ của bạn là tìm vị trí hình thứ 2 giống hình đã chọn trước đó.\n\n" + 
			"+ Nếu người chơi tìm sai thì hình sẽ được up lại.\n\n" + 
			"+ Nếu người chơi chọn đúng thì cặp hình đó sẽ bị xóa khỏi \n\n" + 
			"   màn hình đồng thời bạn sẽ được cộng 100 điểm vào tổng điểm.\n\n" + 
			"+Khi người chơi lật hết được tất cả các hình thì họ sẽ là người thắng cuộc.\n\n" + 
			"    nút setting dùng giúp người chơi chọn hình ảnh cho các button.\n" + 
			"\n\tThanks for Playing and Have Fun!");
	lb2.setBounds(100,60,700,600);
	lb2.setOpaque(false);
	lb2.setForeground(Color.BLACK);
	lb2.setFont(new Font("arial", Font.PLAIN, 20));
	add(lb2);

}

@Override
public void addButtons() {
	JButton bt= new JButton("BACK");
	bt.setBackground(Color.gray);
	bt.setForeground(Color.red);
	bt.setBounds(300, 670, 120, 30);
	bt.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			GameMemory frame=new GameMemory();

			
		}
	});
	add(bt);
}
}
