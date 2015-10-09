package other;

public final class UserInfoSinlgeton {
	
	public static UserInfoSinlgeton instance;
	public static String username;
	public static String password;
	
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		UserInfoSinlgeton.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		UserInfoSinlgeton.password = password;
	}

	private UserInfoSinlgeton(){}
	
	public final static UserInfoSinlgeton getInstance(){
		if(instance==null){
			synchronized (UserInfoSinlgeton.class) {
				if(instance==null){
					instance = new UserInfoSinlgeton();
				}
			}
		}
		
		return instance;
	}
}
