package component;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import logic.CollidableEntity;

public class GolfBall extends CollidableEntity {
	private final int radius = 20;
	private final int maxSpeed = 20;
	private int powerPercent;
	private int x;
	private int y;
	private int speed;

	public GolfBall(int x, int y) {
		this.setPowerPercent(0);
		this.setSpeed(0);
		this.setX(x);
		this.setY(y);
	}

	public void hit() {
		if (speed == 0) {
			Line arrow = new Line(this.getX(), this.getY(), this.getX(), this.getY() - 50);
			arrow.setStroke(Color.RED);
			arrow.setStrokeWidth(2);
			arrow.setVisible(false);
		}
	}

	public void update() {
		if (speed == 0 && InputUtility.isDrag) {
//			System.out.println("adawdawdawda");

		}
	}

	public int getPowerPercent() {
		return powerPercent;
	}

	public void setPowerPercent(int powerPercent) {
		this.powerPercent = powerPercent;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLUE);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.translate(-x, -y);

		if (speed == 0 && InputUtility.isDrag) {
			gc.setStroke(Color.RED);
			gc.setLineWidth(2.0);
			gc.strokeLine(x, y, 2 * x - InputUtility.mousePosX, 2 * y - InputUtility.mousePosY);
		}

	}

}
