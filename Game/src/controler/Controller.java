package controler;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import audio.AudioUtility;
import model.IModel;
import model.Model;
import view.Game;
import view.GameMemory;
import view.Help;

public class Controller implements IController {

	private IModel model;
	private Game view;
	private GameMemory view1;
	final AudioClip nhacCell = AudioUtility.getAudioClip("src/audio/nhac/p.au");
	static final AudioClip nhacGame = AudioUtility.getAudioClip("src/audio/nhac/pacemusic.au");
	

	public static AudioClip getNhacGame() {
		return nhacGame;
	}

	public Controller(IModel model, Game view) {
		this.model = model;
		this.view = view;
	}

	public Controller( GameMemory view1) {
		
		this.view1 = view1;
	}

	public void exitGame() {

		view1.getExitButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
				model.exit();
			}
		});

	}


	

	public void resumeGame() {
		view.getPauseButton().addActionListener(new ActionListener() {
			int i = 0;

			public void actionPerformed(ActionEvent arg0) {
				
				view.getPauseButton().setEnabled(true);
				if (i % 2 == 0) {
					view.getPauseButton().setIcon(new ImageIcon("src/view/game/36.png"));
					view.getTime().stop();
					nhacGame.stop();
					i++;
				} else {
					view.getPauseButton().setIcon(new ImageIcon("src/view/game/35.png"));
					view.getTime().start();
					nhacGame.play();
					view.getAudioButton().setIcon(new ImageIcon("src/view/game/33.png"));
					i++;
				}

			}
		});

	}

	public void processEvent(final int index) {

		view.getArrButton()[index].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (view.getMh() == null)
					return;
				nhacCell.play();
				model.process(index);
			}
		});

	}

	public void helpGame() {
		view1.getHelpButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				view1.setVisible(false);
				nhacGame.stop();
				Help hp = new Help();
				

			}
		});
	}

	public void audioGame() {
		// TODO Auto-generated method stub
		view.getAudioButton().addActionListener(new ActionListener() {
			int i = 0;

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.getAudioButton().setEnabled(true);
				if (i % 2 == 0) {
					view.getAudioButton().setIcon(new ImageIcon("src/view/game/34.png"));
					nhacGame.stop();
					nhacCell.stop();
					i++;
				} else {
					view.getAudioButton().setIcon(new ImageIcon("src/view/game/33.png"));
					nhacGame.loop();
					nhacCell.loop();
					i++;
				}

			}
		});
	}
	
	public void newGame() {
		view1.getStart().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view1.setVisible(false);
				model = new Model();
				Game frame = new Game(model);
				frame.getAudioButton().setEnabled(true);
				frame.getPauseButton().setEnabled(true);
				frame.requestStartGame();
				frame.getTime().start();
				nhacGame.play();
				model.start();
				
			}
		});
	}

	public void backGame() {
		view.getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(false);
				GameMemory frame = new GameMemory();
				
				
			}
		});
			}
}
