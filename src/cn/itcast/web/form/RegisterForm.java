package cn.itcast.web.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private Map errors = new HashMap();
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/*
	�û�������Ϊ�գ�������3-8Ϊ��ĸ
	���벻��Ϊ�գ�������3-8Ϊ����
	��֤���벻��Ϊ�գ�������һ������һ��
	�����ʼ�����Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
	���տ���Ϊ�գ����ǲ�Ϊ��ʱ����������
	�ǳƲ���Ϊ�գ�����Ҫ�Ǻ���
	*/
	//�û�������Ϊ�գ�������3-8Ϊ��ĸ
	public boolean isOK(){
		boolean isOK = true;
		if(this.username==null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "�û�������Ϊ��");
		}else{
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK = false;
				errors.put("username", "�û���������3-8λ��ĸ");
			}
		}
		//���벻��Ϊ�գ�������3-8Ϊ����		
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "���벻��Ϊ��");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOK = false;
				errors.put("password", "���������3-8λ����");
			}
		}
		//��֤���벻��Ϊ�գ�������һ������һ��		
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ��");
		}else{
			if(!this.password2.equals(this.password)){
				isOK = false;
				errors.put("password2", "������������Ҫһ��");
			}
		}
		//�����ʼ�����Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������		
		if(this.email==null || this.email.trim().equals("")){
			isOK = false;
			errors.put("email", "���䲻��Ϊ��");
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("email", "�����ʽ����ȷ");
			}
		}
		//���տ���Ϊ�գ����ǲ�Ϊ��ʱ����������
		if(this.birthday != null && !this.birthday.trim().equals("")){
			try{
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(this.birthday,"yyyy-MM-dd");
			}catch(Exception e){
				isOK = false;
				errors.put("birthday", "��������ո�ʽ����ȷ");
			}
		}
		//�ǳƲ���Ϊ�գ�����Ҫ�Ǻ���
		if(this.nickname==null || this.nickname.trim().equals("")){
			isOK = false;
			errors.put("nickname", "�ǳƲ���Ϊ��");
		}else{
			if(!this.nickname.matches("[\u4e00-\u9fa5]+")){
				isOK = false;
				errors.put("nickname", "�ǳƸ�ʽ�����Ǻ���");
			}
		}
		return isOK;
	}
}
