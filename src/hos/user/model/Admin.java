package hos.user.model;

public class Admin {

	private String Aid;
	private String FullName;
	private String Username;
	private String Password;
	private String Email;
	
	
	
	public Admin(String aid, String fullName, String username, String password, String email) {
		super();
		Aid = aid;
		FullName = fullName;
		Username = username;
		Password = password;
		Email = email;
	}
	
	
	public Admin(String fullName, String username, String password, String email) {
		super();
		FullName = fullName;
		Username = username;
		Password = password;
		Email = email;
	}


	public String getAid() {
		return Aid;
	}
	public void setAid(String aid) {
		Aid = aid;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
