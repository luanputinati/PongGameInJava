import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
	
	private Thread thread;
	private boolean Running = true;
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 640;
	public static int HEIGHT = 320;
	public static int SCALE = 2;
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		this.addKeyListener(this);
		player = new Player(20, 130);
		enemy = new Enemy(610, 130);
		ball = new Ball(WIDTH/2 - 1, 130);
	}

	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame("Pong_new");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null); //colocar após o game para o java calcular a tela no meio
		frame.setVisible(true);
		new Thread(game).start();
	}
	
	
	public void Update() {
		player.Update();
		enemy.Update();
		ball.Update();
	}
	
	public void Render() {
		BufferStrategy BS = this.getBufferStrategy();
		if(BS == null) { 
			this.createBufferStrategy(3);
			return;
		}
		Graphics G = layer.getGraphics();
		G.setColor(Color.BLACK);
		G.fillRect(0,0,WIDTH,HEIGHT);
		player.Render(G);
		enemy.Render(G);
		ball.Render(G);
		G = BS.getDrawGraphics();
		G.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE,null);
		BS.show();
		
	}
	
	
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime(); 
		double amountOfUpdate = 60.0; 
		double ns = 1000000000 / amountOfUpdate; 
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(Running) {
			long now = System.nanoTime();
			delta+= (now-lastTime) / ns; 
			lastTime = now;
			if (delta >= 1) {
				Update();
				Render();
				frames++;
				delta--; 
			}
			if(System.currentTimeMillis() - timer  >=1000) {
				frames=0;
				timer+= 1000;
			}
		}
		
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.down = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.down = false;
		}
		
	}

	
}
