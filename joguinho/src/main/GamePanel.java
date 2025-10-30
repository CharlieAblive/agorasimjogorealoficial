package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private BufferedImage img;
	private BufferedImage idleAnim;
	
	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		importImg();
		loadAnimation();
		
		setPanelSize();
		addKeyListener(new KeyInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}
	
	private void loadAnimation() {
		// TODO Auto-generated method stub
		
	}

	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/Swordsman_lvl1_Run_without_shadow.png");
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(800, 600);
		setPreferredSize(size);
		
		
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;

	}

	public void changeYDelta(int value) {
		this.yDelta += value;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(img.getSubimage(0, 0, 768/12, 512/8), (int)xDelta, (int)yDelta, 164, 162, null);
	}


	}

