package logic;

import java.util.ArrayList;
import java.util.List;

import component.Entity;
import component.Field;
import component.GolfBall;
import component.Tree;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private GolfBall golfBall; 
	private Tree tree ;
	
	public GameLogic() {
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		this.gameObjectContainer = new ArrayList<Entity>();
		golfBall = new GolfBall(600,400);
		tree = new Tree(200,400);
		addNewObject(golfBall);
		addNewObject(tree);
	}
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	public void logicUpdate(){
		golfBall.update();
//		System.out.println("golf update");
//		System.out.println(golfBall.collideWith(tree));
//		System.out.println(Math.hypot(tree.getX()-golfBall.getX(), tree.getY()-golfBall.getY())+ " " + (tree.radius + golfBall.radius));
		if(golfBall.collideWith(tree)&& !tree.isDestroyed())
		{
			System.out.println("HIT");
			tree.onCollision(golfBall);
		}
//		System.out.println(golfBall.getAngle());
	}
}
