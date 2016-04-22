package pattern.strategy.behavior.impl;

import pattern.strategy.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("飞行");
	}

}
