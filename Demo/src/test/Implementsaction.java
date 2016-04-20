package test;

public class Implementsaction implements Service {

	private Implementsaction() {}
	
	@Override
	public void method1() {
		System.out.println("1");
	}

	@Override
	public void method2() {
		System.out.println("2");
	}
	
	public static ServiceFactory factory = new ServiceFactory() {
		
		@Override
		public Service getService() {
			return new Implementsaction();
		}
	};

}
