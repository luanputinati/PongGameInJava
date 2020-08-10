import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 2.5;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		width = 6;
		height = 6;
		dx =  new Random().nextGaussian();
		dy = new Random().nextGaussian();
	}
	
	public void Update() {
		
		if(y+(dy*speed) + height >= Game.HEIGHT) {
			dy*=-1;
		} else if(y+(dy*speed) < 0) {
			dy*=-1;
		}
		
		if(x >= Game.WIDTH) {
			//ponto do enimigo
			System.out.println("Player");
			new Game();
			return;
		} else if (x <= 0) {
			// ponto do player
			System.out.println("Enemy");
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, Game.enemy.width, Game.enemy.height);
		if(bounds.intersects(boundsPlayer)) {
			dx*=-1;
		} else if(bounds.intersects(boundsEnemy)) {
			dx*=-1;
		}
		
		x+=dx*speed;
		y+=dy*speed;
		
	}
	
	
	public void Render(Graphics G) {
		G.setColor(Color.YELLOW); //Cor do jogador
		G.fillRect((int)x, (int)y, width, height);
		
	}
}
