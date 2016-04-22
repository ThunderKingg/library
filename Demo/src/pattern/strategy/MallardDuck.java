package pattern.strategy;

import pattern.strategy.behavior.impl.FlyWithWings;
import pattern.strategy.behavior.impl.Quack;

public class MallardDuck extends Duck {
	public MallardDuck(){
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	@Override
	void display() {
		System.out.println("绿头鸭");
	}
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.display();
		duck.performFly();
		duck.performQuack();
	}
}
