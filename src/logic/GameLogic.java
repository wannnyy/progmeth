package logic;

import java.util.ArrayList;
import java.util.List;

import component.Entity;
import component.GolfBall;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private GolfBall golfBall; 
	
	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();
		golfBall = new GolfBall(600,400);
		addNewObject(golfBall);
	}
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
}
