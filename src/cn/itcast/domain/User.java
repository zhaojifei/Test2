package cn.itcast.domain;

import java.util.Date;//�������ֹ�����

//javaBean--λ��domain���У�����service���dao��֮��Ľ���
//dao������ݿ��л�����ݣ��洢��javaBean�У�service��javaBean�л�ȡ����
//Ҳ���Ǹ�User��ʹ�����洢dao������ݿ��л�õ�user�����ݣ���dao���о�Ӧ��д��λ�ȡ���ݿ��е�����
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
