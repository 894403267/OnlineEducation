package com.example.entry;

public class User extends BaseNode {

	private int user_id;
	
	private String user_name;
	
	private String user_email;
	
	private String password;
	
	private int admin_flg;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin_flg() {
		return admin_flg;
	}

	public void setAdmin_flg(int admin_flg) {
		this.admin_flg = admin_flg;
	}
	
	
}
