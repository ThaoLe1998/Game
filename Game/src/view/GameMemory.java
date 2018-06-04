package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controler.Controller;
import controler.IController;
import model.IModel;
import model.Model;
import template.OptionTemplate;

public class GameMemory extends OptionTemplate {
	JButton start;
	private IController control;
	private JButton aboutButton, continueButton, exitButton, helpButton, setingButton;
	private static int diem = 0;

	public static int getMap() {
		return map;
	}

	public static void setMap(int map) {
		GameMemory.map = map;
	}

	private static int map = 1;

	public GameMemory() {

		this.control = new Controller(this);
		initGUI();
		addLabels();
		addButtons();
		setSize(540, 745);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 0);
		setVisible(true);
	}


	public IController getControl() {
		return control;
	}

	public void setControl(IController control) {
		this.control = control;
	}

	public static int getDiem() {
		return diem;
	}

	public static void setDiem(int diem) {
		GameMemory.diem = diem;
	}

	public JButton getAboutButton() {
		return aboutButton;
	}

	public void setAboutButton(JButton aboutButton) {
		this.aboutButton = aboutButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	public JButton getHelpButton() {
		return helpButton;
	}

	public void setHelpButton(JButton helpButton) {
		this.helpButton = helpButton;
	}

	public JButton getSetingButton() {
		return setingButton;
	}

	public void setSetingButton(JButton setingButton) {
		this.setingButton = setingButton;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	@Override
	public void initGUI() {
		Container c = getContentPane();
		setContentPane(new JLabel(new ImageIcon("src/view/game/nengame.png")));
		setLayout(null);

	}

	@Override
	public void addLabels() {

	}

	@Override
	public void addButtons() {
		helpButton = new JButton("Help");
		helpButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		helpButton.setForeground(Color.red);
		helpButton.setBounds(180, 530, 200, 40);
		add(helpButton);
		control.helpGame();
		// control.helpGame();

		exitButton = new JButton("Exit");
		exitButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		exitButton.setForeground(Color.red);
		exitButton.setBounds(180, 580, 200, 40);
		add(exitButton);
		control.exitGame();

		aboutButton = new JButton("About");
		aboutButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		aboutButton.setForeground(Color.red);
		aboutButton.setBounds(180, 480, 200, 40);
		add(aboutButton);

		setingButton = new JButton("Setting");
		setingButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		setingButton.setForeground(Color.red);
		setingButton.setBounds(180, 430, 200, 40);
		add(setingButton);

//		ImageIcon i =new ImageIcon("src/view/game/play1.png");
		start = new JButton("New Game");
//		start.setIcon((i));
		start.setForeground(Color.red);
		start.setBounds(180, 330,200, 40);
		start.setFont(new Font(".VnAristote", Font.BOLD, 30));
		start.setOpaque(false);
		start.setBorder(null);
		start.setBorderPainted(false);
//		start.setText(null);
		start.setMargin(new Insets(0, 0, 0, 0));
		start.setIconTextGap(0);
		add(start);
		control.newGame();
		

		continueButton = new JButton("Continue");
		// continueButton.setIcon((new ImageIcon("src/view/game/conti.jpg")));
		continueButton.setForeground(Color.red);
		continueButton.setBounds(180, 380, 200, 40);
		continueButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		continueButton.setEnabled(false);
		continueButton.setOpaque(false);
		continueButton.setBorder(null);
		add(continueButton);

	}

	public static void main(String[] args) {
		new GameMemory();
	}
}

class ImageButton extends JButton {

	public ImageButton(String img) {
		this(new ImageIcon(img));
	}

	public ImageButton(ImageIcon icon) {
		setIcon(icon);
		setMargin(new Insets(0, 0, 0, 0));
		setIconTextGap(0);
		setBorderPainted(false);
		setBorder(null);
		setText(null);
		setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	}
}
