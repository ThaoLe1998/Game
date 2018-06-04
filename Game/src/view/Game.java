package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import controler.Controller;
import controler.IController;
import model.Hinh;
import model.IModel;
import model.ManHinhAnh;
import model.Model;
import observer.ObserverHinhAnh;
import observer.ObserverXL;
import template.OptionTemplate;

public class Game extends OptionTemplate implements ObserverHinhAnh, ObserverXL, Runnable {
	private Thread aminator = null;
	private int width;
	private int height;
	private static int MAX = 3;
	private ManHinhAnh mh = null;
	private Object[] arrObMH = null;
	private IController control;
	private int congDiem = 100;
	private static final String LABEL = "MARK: ";
	private static final String START = "START";
	private Timer time;
	private int bodem = 60;
	private static final int TOPHEIGHT = 40;
	private static final int SIZE = 100;
	private JButton arrButton[];
	private JButton startButton, setingButton, audioButton, pauseButton, backButton;
	private JLabel leftLabel, rightLabel, mapLabel;
	private IModel model;
	private static int count = 0;
	private static int before = 0;

	public JButton getPauseButton() {
		return pauseButton;
	}

	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
	}

	public JButton getSetingButton() {
		return setingButton;
	}

	public JButton getAudioButton() {
		return audioButton;
	}

	public void setAudioButton(JButton audioButton) {
		this.audioButton = audioButton;
	}

	public void setSetingButton(JButton setingButton) {
		this.setingButton = setingButton;
	}

	public JButton[] getArrButton() {
		return arrButton;
	}

	public void setArrButton(JButton[] arrButton) {
		this.arrButton = arrButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public Game(IModel model) {

		setContentPane(new JLabel(new ImageIcon("src/view/game/26.jpg")));
		this.model = model;
		this.control = new Controller(model, this);
		model.registerObserversHinhAnh(this);
		model.registerObserversXL(this);
		initGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocation(100, 10);
		setVisible(true);
		
	}

	public void initGUI() {
		try {
			arrButton = new JButton[MAX * 4];
			width = 4 * SIZE;
			height = 4 * SIZE + 2 * TOPHEIGHT;
			setSize(new Dimension(width, height));
			addButtons();
			addLabels();
			setPreferredSize(new Dimension(width, height));
			this.setLayout(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addButtons() {
		int y = TOPHEIGHT;
		for (int i = 0; i < MAX; i++) {
			int x = 300;
			for (int j = 0; j < 4; j++) {
				final int index = i * 4 + j;
				arrButton[index] = new JButton(index + " ");
				arrButton[index].setBounds(x, y, SIZE + 5, SIZE + 5);
				arrButton[index].setIcon(new ImageIcon("src/view/game/go1.png"));
				control.processEvent(index);
				add(arrButton[index]);
				x += SIZE + 20;
			}
			y += SIZE + 20;
		}

		// nut exit
		audioButton = new JButton("");
		audioButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		audioButton.setForeground(Color.red);
		audioButton.setBackground(Color.blue);
		audioButton.setIcon(new ImageIcon("src/view/game/33.png"));
		audioButton.setEnabled(false);
		audioButton.setBounds(80, 230, 150, TOPHEIGHT - 5);
		audioButton.setOpaque(false);
		add(audioButton);
		control.audioGame();

		pauseButton = new JButton("");
		pauseButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		pauseButton.setForeground(Color.red);
		pauseButton.setBackground(Color.blue);
		pauseButton.setIcon(new ImageIcon("src/view/game/35.png"));
		pauseButton.setEnabled(false);
		pauseButton.setBounds(80, 280, 150, TOPHEIGHT - 5);
		pauseButton.setOpaque(false);
		add(pauseButton);
		control.resumeGame();

		backButton = new JButton("Back");
		backButton.setFont(new Font(".VnAristote", Font.BOLD, 30));
		backButton.setForeground(Color.red);
		backButton.setBackground(Color.blue);
		backButton.setBounds(80, 330, 150, TOPHEIGHT - 5);
		add(backButton);
		control.backGame();

	}

	public ManHinhAnh getMh() {
		return mh;
	}

	public void setMh(ManHinhAnh mh) {
		this.mh = mh;
	}

	public void addLabels() {
		JPanel leftPanel = new JPanel();
		leftLabel = new JLabel("TIME:" + bodem);
		ActionListener aTime = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				--bodem;
				leftLabel.setText("Time = " + bodem);
				if (bodem == 0) {
					JOptionPane.showMessageDialog(null, "Het gio ban thua roi");
					time.stop();
					gameOver();
				}
			}
		};
		time = new Timer(1000, aTime);
		time.stop();

		leftLabel.setFont(new Font(".VnBlack", Font.BOLD, 25));
		leftLabel.setForeground(Color.red);
		leftLabel.setBackground(Color.blue);
		leftLabel.setBounds(80, 100, 150, 20);
		add(leftLabel);
		

		rightLabel = new JLabel(LABEL + GameMemory.getDiem());
		rightLabel.setFont(new Font(".VnBlack", Font.BOLD, 25));
		rightLabel.setForeground(Color.red);
		rightLabel.setBackground(Color.blue);
		rightLabel.setBounds(80, 150, 250, 20);
		add(rightLabel);

		mapLabel = new JLabel("MAP: " + GameMemory.getMap() + "");
		mapLabel.setFont(new Font(".VnBlack", Font.BOLD, 25));
		mapLabel.setForeground(Color.red);
		mapLabel.setBackground(Color.blue);
		mapLabel.setBounds(80, 190, 250, 20);
		add(mapLabel);

	}

	public Timer getTime() {
		return time;
	}

	public void setBodem(int bodem) {
		this.bodem = bodem;
	}

	public void requestStartGame() {
		model.start();

	}

	private void requestExitGame() {
		model.exit();
	}

	public void update(ManHinhAnh oMHinh) {
		this.mh = oMHinh;
		if (mh == null) {
			stopGame();
		} else {
			initGame();
		}
	}

	private void initGame() {
		if (aminator == null) {
			aminator = new Thread(this);
			aminator.start();
		}

	}

	private void stopGame() {// kt gam
		if (GameMemory.getMap() < 4) {
			time.stop();
			GameMemory.setMap(GameMemory.getMap() + 1);
			MAX++;
			setBodem(bodem + 10 * (GameMemory.getMap() - 1));

			Model model = new Model();
			Game view = new Game(model);
			this.setVisible(false);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
			view.setSize(new Dimension(900, 700));
			view.setLocation(100, 10);
			view.setFont(new Font("Arial", Font.BOLD, 70));
			view.setForeground(Color.WHITE);
			view.getAudioButton().setEnabled(true);
			view.getPauseButton().setEnabled(true);
			view.requestStartGame();
			view.getTime().start();
			Controller.getNhacGame().play();
			model.start();

		} else {
			GameMemory.setDiem(0);
			deleteButtons();
			repaint();
			aminator = null;
			setVisible(false);
			KetThuc kt = new KetThuc();
			kt.setSize(700, 700);
			kt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			kt.setLocation(400, 0);
			kt.setVisible(true);
		}
	}

	private void gameOver() {// kt game
		Model model = new Model();
		Game view = new Game(model);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.pack();
		view.setVisible(true);
		view.setSize(new Dimension(1000, 700));
		view.setLocation(100, 10);
		view.setFont(new Font("Arial", Font.BOLD, 70));
		view.setForeground(Color.WHITE);
	}

	private void deleteButtons() {
		Thread thread = new Thread(new Runnable() {

			public void run() {
				for (int i = arrButton.length - 1; i >= 0; i--) {
					try {
						remove(arrButton[i]);
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				repaint();
			}
		});
		thread.start();

	}

	public void run() {
		arrObMH = mh.getMhAnh();
	}

	private synchronized void openCell(int i) {
		if (arrObMH[i] == null) {
			System.out.println("cell=null");
			return;
		}
		if (arrObMH[i] instanceof Hinh) {
			arrButton[i].setText(" ");
			Hinh icon = (Hinh) arrObMH[i];
			congDiem = icon.getDiem();
			arrButton[i].setIcon(icon.getHinhAnh());
			
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}

	private synchronized void closeCell(int i) {
		if (arrObMH[i] == null) {
			return;
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		if (arrObMH[i] instanceof Hinh) {
			arrButton[i].setText("");
			arrButton[i].setIcon(null);
			arrButton[i].setIcon(new ImageIcon("src/view/game/go1.png"));
		}

	}

	public void update(final int truoc, final int hienTai, boolean b) {
		if (truoc == Model.NONEINDEX) {
			openCell(hienTai);
			before = hienTai;
			count++;
			System.out.println("count 0: "+ count);
			return;
		}
		if (truoc != hienTai) {
			if (b) {
				Thread thread = new Thread(new Runnable() {

					public void run() {
						openCell(hienTai);
						System.out.println("hien tai: " + hienTai);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {

						}

						arrButton[truoc].setVisible(false);
						arrButton[hienTai].setVisible(false);
						count =0;
						closeCell(before);
						System.out.println("result count: " + count);
					}
				});

				thread.start();
				GameMemory.setDiem(GameMemory.getDiem() + congDiem);
				rightLabel.setText(LABEL + GameMemory.getDiem() + "");

			} else {
				
				if(count ==2) {
					closeCell(truoc);
					closeCell(before);
					count =0;
					openCell(hienTai);
					count++;
					
				}
				else {
					openCell(hienTai);
					before = truoc;
					count++;
					System.out.println(count);
				}
				

			}
		}
	}

}