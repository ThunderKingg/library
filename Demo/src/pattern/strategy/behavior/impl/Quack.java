package pattern.strategy.behavior.impl;

import pattern.strategy.behavior.QuackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("呱呱叫");
	}

}
