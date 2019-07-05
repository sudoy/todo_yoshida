package todo.forms;

public class UserForm {
	private String password;
	private String name;
	private String email;
	public UserForm(String password, String name, String email) {
		super();
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public UserForm() {

	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
