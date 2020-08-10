import java.awt.Color;
import java.awt.Graphics;

public class Player{

	public int width,height;
	
	public boolean up,down;
	
	
	public int x,y;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		width = 10;
		height = 50;
	}
	
	public void Update(){
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
	
	public void Render(Graphics G) {
		G.setColor(Color.WHITE); //Cor do jogador
		G.fillRect(x, y, width, height);
	}

}