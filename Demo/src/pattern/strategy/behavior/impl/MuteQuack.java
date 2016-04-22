package pattern.strategy.behavior.impl;

import pattern.strategy.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("不会叫");
	}

}
