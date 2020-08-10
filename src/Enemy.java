import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

	public double x, y;
	public int width, height;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		width = 10;
		height = 50;
	}
	
	public void Update() {
		y+= (Game.ball.y - y - 6);
		
	}
	
	
	public void Render(Graphics G) {
		G.setColor(Color.RED); //Cor do jogador
		G.fillRect((int)x, (int)y, width, height);
	}

}