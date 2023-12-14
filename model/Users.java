package model;

public class Users {
	private String usersId;
	private String usersName;
	private String password;
	private String name;
	private String usersRole;
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
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
	public String getUsersRole() {
		return usersRole;
	}
	public void setUsersRole(String usersRole) {
		this.usersRole = usersRole;
	}
	public Users(String usersId, String usersName, String password, String name, String usersRole) {
		super();
		this.usersId = usersId;
		this.usersName = usersName;
		this.password = password;
		this.name = name;
		this.usersRole = usersRole;
	}
	public Users() {};

}
