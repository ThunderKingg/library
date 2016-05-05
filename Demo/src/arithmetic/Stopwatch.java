package arithmetic;
/**
 * 计时器类
 * @author Administrator
 *
 */
public class Stopwatch {
	private final long start;
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	public double elpasedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}
