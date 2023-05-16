package logic;

import component.Entity;

public abstract class CollidableEntity extends Entity{
	protected int radius;
	protected boolean collideWith(CollidableEntity other){
//		System.out.println(this.x + " " + other.x);
//		System.out.println(Math.hypot(other.x-this.x, this.y-other.y)+ " " + (other.radius + this.radius));
		return Math.hypot(this.x-other.x, this.y-other.y) <= this.radius+other.radius;
	}	
}
