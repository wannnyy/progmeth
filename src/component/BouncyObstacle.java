package component;

public class BouncyObstacle extends Obstacle implements Solid {
	public BouncyObstacle(int x, int y) {
		super(x, y);
		
	}
	
	public int bounce(GolfBall gb) {
//		return Physics.hit(gb.getSpeed(), this.getBounciness());
	}
		
}
