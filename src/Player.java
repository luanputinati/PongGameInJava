import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity{
	
	protected boolean up,down;
	
	public Player(int x, int y) {
		super(x, y);
	}
	
	public void update(){
		if(up) {
			y++;
		} else if(down) {
			y--;
		}
		if (y+height > Game.HEIGHT) {
			y = 265;
		}else if (y<0) {
			y = 5;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.CYAN); //Cor do jogador
		g.fillRect(x, y, width, height); //Renderização da cor
	}

}