package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	//ʵ�ַ���һ�������ݿ��в����µ�user����
	void add(User user);

	//ʵ�ַ������������ݿ��в�ѯָ����user����
	User find(String username, String password);

	//ʵ�ַ������������ݿ��в�ѯĳһuser�Ƿ����
	boolean find(String username);

}