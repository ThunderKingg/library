package framework.control;

/**
 * 事例：控制框架
 * 事件就绪的时候执行事件。
 * 本例中指基于时间触发的事件。
 * 对于要控制什么，控制框架并不包含任何具体的信息。
 * 那些信息由继承类实现action方法来实现具体事件。
 * @author Administrator
 *
 */
public abstract class Event {
	private long eventTime;
	
	protected final long delayTime;
	public Event(long dealayTime){
		this.delayTime = dealayTime;
		start();
	}
	
	public void start(){
		this.eventTime = System.nanoTime() + delayTime;
	}
	/**
	 * ready()负责告诉你何时可以运行action方法了。
	 * 可以在导出类中覆盖ready()方法使Event可以基于时间以外的因素而触发。
	 * @return
	 */
	public boolean ready(){
		return System.nanoTime() >= eventTime;
	}
	public abstract void action();
}
