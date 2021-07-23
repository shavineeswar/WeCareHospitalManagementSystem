package hos.user.model;

public class Laboratorist {

	private String Lid;
	private String FullName;
	private String Username;
	private String Password;
	private String Email;
	private String Phone;
	private String Position;
	
	public Laboratorist(String lid, String fullName, String username, String password, String email, String phone,
			String position) {
		super();
		Lid = lid;
		FullName = fullName;
		Username = username;
		Password = password;
		Email = email;
		Phone = phone;
		Position = position;
	}

	public String getLid() {
		return Lid;
	}

	public void setLid(String lid) {
		Lid = lid;
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
