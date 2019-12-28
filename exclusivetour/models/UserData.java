package exclusivetour.models;

public class UserData {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String login;
	private String password;
	private String email;
	private long phone;
	private int role;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", login=" + login + ", password=" + password + ", email=" + email + ", phone=" + phone + ", role="
				+ role + "]";
	}

	

}
