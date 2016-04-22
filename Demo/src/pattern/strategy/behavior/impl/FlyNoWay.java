package pattern.strategy.behavior.impl;

import pattern.strategy.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("不会飞");

	}

}
