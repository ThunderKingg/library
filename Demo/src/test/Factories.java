package test;

public class Factories {
	public static void serviceConsumer(ServiceFactory fact){
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serviceConsumer(Implementsaction.factory);
	}
}
