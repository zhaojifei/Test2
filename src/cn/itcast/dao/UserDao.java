package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	//实现方法一：向数据库中插入新的user数据
	void add(User user);

	//实现方法二：从数据库中查询指定的user数据
	User find(String username, String password);

	//实现方法三：从数据库中查询某一user是否存在
	boolean find(String username);

}