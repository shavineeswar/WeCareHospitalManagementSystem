package hos.user.model;

public class Nurse {

	private String Nid;
	private String FullName;
	private String Username;
	private String Password;
	private String Email;
	private String Phone;
	private String Department;
	private String Position;
	
	public Nurse(String nid, String fullName, String username, String password, String email, String phone,
			String department, String position) {
		super();
		Nid = nid;
		FullName = fullName;
		Username = username;
		Password = password;
		Email = email;
		Phone = phone;
		Department = department;
		Position = position;
	}

	public String getNid() {
		return Nid;
	}

	public void setNid(String nid) {
		Nid = nid;
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

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	
	
	
	
	
	
}
