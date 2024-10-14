package command;

/**
 * 심플 팩토리 클래스. 
 * 팩토리 인스턴스 자체는 굳이 여러 개의 인스턴스를 만들 필요가 없으므로 
 * 싱글톤으로 구현해보았다. 
 */
public class SimpleFactory {
	private static SimpleFactory simpleFactory = new SimpleFactory();
	private SimpleFactory() {}
	public static SimpleFactory getInstance() {
		return simpleFactory;
	}
	
	public CommandInterface getCommand(String requestUri) {
		switch(requestUri) {
			case "/login.do":
				// LoginViewServlet
				return new LoginViewCommand();
			case "/loginProc.do":
				// LoginProcServlet
				return new LoginProcCommand();
			case "/signup.do":
				// SignUpViewServlet
				return new SignUpViewCommand();
			case "/signupProc.do":
				// SignUpProcServlet
				return new SignUpProcCommand();
			case "/products.do":
				// CategoryProductServlet
				return new CategoryProductCommand();
			case "/cart.do":
				// ProductCartServlet
				return new ProductCartCommand();
			default:
				// 비정상적인 요청에 대한 안내 페이지로 이동하게끔 함.
				return new UnExpectedRequestViewCommand();
		}
	}
}
