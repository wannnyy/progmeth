package component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.CollidableEntity;

public class Tree extends CollidableEntity {
	public Tree(int x, int y) {
		this.x = x ; 
		this.y = y ; 
		this.z = -100 ; 
		this.radius = 40;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.GREEN);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.translate(-x, -y);
	}	
	public void onCollision(GolfBall golfBall){
		golfBall.hitObstacle();
		this.destroyed = true;
	}
	
	public double getX() {
		return this.x ;
	}
	public double getY() {
		return this.y ;
	}
}
