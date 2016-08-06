package cn.itcast.domain;

import java.util.Date;//包含各种工具类

//javaBean--位于domain包中，用于service层和dao层之间的交互
//dao层从数据库中获得数据，存储在javaBean中，service从javaBean中获取数据
//也就是该User类使用来存储dao层从数据库中获得的user的数据，在dao层中就应该写如何获取数据库中的数据
public class User {
	private String id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
