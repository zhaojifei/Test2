package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.utils.ServiceUtils;

//对web层提供所有的业务服务：注册和登陆两个服务
public class BusinessServiceImpl {
	
	private UserDao dao = new UserDaoImpl();//运用工厂模式或者spring来代替这种模式，底层代码换了上层不用改，更加模块化
	
	//注册服务，首先要检测注册的用户是否存在，如果不存在，允许注册
	public void register(User user) throws UserExistException{
		if(dao.find(user.getUsername())==true){
			throw new UserExistException();//发现用户已存在时给web层抛出的异常，是编译时异常，是可以处理的异常，给用户一个提示
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	//登陆服务,登陆功能的返回值是该user对象
	public User login(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username,password);
	}
}
