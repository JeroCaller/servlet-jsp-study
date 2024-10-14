package model.db;

public class JDBCTool {
	public static void freeConnection(AutoCloseable ...closes) {
		for (AutoCloseable cl : closes) {
			if (cl == null) continue;
			
			try {
				cl.close();
			} catch (Exception e) {
				String errorMsg = String.format("""
						%f : close() 메서드 호출 중 %f 에러 발생.
						""", 
						cl.getClass().getName(), 
						e.getClass().getName()
					).trim();
				System.out.println(errorMsg);
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * 예외 발생 시 이를 처리하는 메서드. 
	 * @param e - 예외 객체.
	 */
	public static void handleException(String methodName, Exception e) {
		String errorMsg = String.format("""
				%s 메서드 호출 중 %f 에러 발생.
				""", 
				methodName, 
				e.getClass().getName()
			).trim();
		System.out.println(errorMsg);
		e.printStackTrace();
	}
	
}
