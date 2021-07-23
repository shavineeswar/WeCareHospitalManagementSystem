package hos.user.model;

public class Doctor {

	private String Did;
	private String Fullname;
	private String Username;
	private String Password;
	private String Email;
	private String Phone;
	private String Specialization;
	
	
	public Doctor(String Did, String Fullname, String Username, String Password, String Email, String Phone,
			String Specialization) {
		super();
		this.Did = Did;
		this.Fullname = Fullname;
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
		this.Phone = Phone;
		this.Specialization = Specialization;
	}
	

	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
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
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	
	
}

