import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {

	protected int x, y;
	protected int width, height;
	
	public Entity (int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 50;
	}
	
	public void render(Graphics g) {
		
	}
}
