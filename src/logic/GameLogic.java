package logic;

import java.util.ArrayList;
import java.util.List;

import component.Entity;
import component.Field;
import component.GolfBall;
import component.Obstacle;
import component.Tree;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private List<Obstacle> obstacle ; 
	private GolfBall golfBall; 
	private Tree tree ,tree1 ;
	
	public GameLogic() {
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		this.gameObjectContainer = new ArrayList<Entity>();
		this.obstacle = new ArrayList<Obstacle>();
		golfBall = new GolfBall(600,400);
		tree = new Tree(200,400);
		tree1 = new Tree(400,400);
		addNewObject(golfBall);
		addNewObject(tree);
		addNewObject(tree1);
	}
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
		if(entity instanceof Obstacle)
		{
			obstacle.add((Obstacle) entity);
		}	
	}
	public void logicUpdate(){
		golfBall.update();
//		System.out.println("golf update");
//		System.out.println(golfBall.collideWith(tree));
//		System.out.println(Math.hypot(tree.getX()-golfBall.getX(), tree.getY()-golfBall.getY())+ " " + (tree.radius + golfBall.radius));
		for(Obstacle e : obstacle)
		{
			if(golfBall.collideWith(e) && !e.isDestroyed()) {
				System.out.println("hit");
				e.onCollision(golfBall);
			}
		}
	}
}
