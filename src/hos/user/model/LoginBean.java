package hos.user.model;
import java.io.Serializable;

public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Username;
	private String Password;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	
	
	
}
