package dao_kadai;

import java.util.Date;

public class UserBeans {
	private int id;
	private String login_id;
	private String name;
	private Date birth_Date;
	private String password;
	private String create_Date;
	private String update_Date;

	public UserBeans(String login_id, String name) {
		this.login_id = login_id;
		this.name = name;
	}

	public UserBeans(int id, String login_id, String name, Date birth_Date, String password, String create_Date,
			String update_Date) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_Date = birth_Date;
		this.password = password;
		this.create_Date = create_Date;
		this.update_Date = update_Date;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth_Date() {
		return birth_Date;
	}

	public void setBirth_Date(Date birth_Date) {
		this.birth_Date = birth_Date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	public String getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(String update_Date) {
		this.update_Date = update_Date;
	}



}
