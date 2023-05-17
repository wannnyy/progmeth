package logic;

import java.util.ArrayList;
import java.util.List;

import component.Entity;
import component.Field;
import component.GolfBall;
import component.Hole;
import component.Obstacle;
import component.Rock;
import component.Tree;
import component.Wall;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private List<Obstacle> obstacle;
	private GolfBall golfBall;
	private Tree tree, tree1;
	private Hole hole;
	private Rock rock;
	private Wall wall1;

	public GameLogic() {
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		this.gameObjectContainer = new ArrayList<Entity>();
		this.obstacle = new ArrayList<Obstacle>();
		golfBall = new GolfBall(600, 400);
		tree = new Tree(200, 400);
		tree1 = new Tree(400, 400);
		hole = new Hole(100, 200);
		wall1 = new Wall(350, 250, 20, 70);
		rock = new Rock(300, 300);
		addNewObject(golfBall);
		addNewObject(rock);
		addNewObject(tree);
		addNewObject(tree1);
		addNewObject(hole);
		addNewObject(wall1);
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
		if (entity instanceof Obstacle) {
			obstacle.add((Obstacle) entity);
		}
	}

	public void logicUpdate() {
		golfBall.update();
		for (Obstacle e : obstacle) {
			if (golfBall.collideWith(e) && !e.isDestroyed()) {
				System.out.println("hit");
				e.onCollision(golfBall);
			}
		}
		if (hole.isBallInHole(golfBall) && golfBall.getSpeed() == 0) {
			System.out.println("GameEnded");
		}
	}
}
