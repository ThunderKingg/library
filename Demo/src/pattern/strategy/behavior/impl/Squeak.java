package pattern.strategy.behavior.impl;

import pattern.strategy.behavior.QuackBehavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("吱吱叫");
	}

}
