package hos.user.model;

public class Accountant {

	private String Aid;
	private String FullName;
	private String Username;
	private String Password;
	private String Email;
	private String Phone;
	private String Position;
	
	public Accountant(String aid, String fullName, String username, String password, String email, String phone,
			String position) {
		super();
		Aid = aid;
		FullName = fullName;
		Username = username;
		Password = password;
		Email = email;
		Phone = phone;
		Position = position;
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

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}
	
	
	
	
	
}
