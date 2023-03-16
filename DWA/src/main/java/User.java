
public class User {

	private String Name;
	private String Phone;
	private String DOB;
	private String Email;
	private String Password;
	
	public User(String name, String phone, String dOB, String email, String password) {
		Name = name;
		Phone = phone;
		DOB = dOB;
		Email = email;
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User [Name=" + Name + ", Phone=" + Phone + ", DOB=" + DOB + ", Email=" + Email + ", Password="
				+ Password + "]";
	}
	
	
}
