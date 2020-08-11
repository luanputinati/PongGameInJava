import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity {
	
	public Enemy(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		y+= (Game.ball.y - y - 6);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.RED); //Cor do jogador
		g.fillRect(x, y, width, height); //Renderização da cor
	}

}