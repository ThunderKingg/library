package pattern.strategy;

import pattern.strategy.behavior.FlyBehavior;
import pattern.strategy.behavior.QuackBehavior;

public abstract class Duck {
	FlyBehavior flyBehavior; 
	QuackBehavior quackBehavior;
	
	void swim(){
		System.out.println("游泳");
	}
	void performQuack(){
		quackBehavior.quack();
	}
	void performFly(){
		flyBehavior.fly();
	}
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	abstract void display();
}
