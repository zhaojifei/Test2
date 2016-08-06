package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.utils.ServiceUtils;

//��web���ṩ���е�ҵ�����ע��͵�½��������
public class BusinessServiceImpl {
	
	private UserDao dao = new UserDaoImpl();//���ù���ģʽ����spring����������ģʽ���ײ���뻻���ϲ㲻�øģ�����ģ�黯
	
	//ע���������Ҫ���ע����û��Ƿ���ڣ���������ڣ�����ע��
	public void register(User user) throws UserExistException{
		if(dao.find(user.getUsername())==true){
			throw new UserExistException();//�����û��Ѵ���ʱ��web���׳����쳣���Ǳ���ʱ�쳣���ǿ��Դ�����쳣�����û�һ����ʾ
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	//��½����,��½���ܵķ���ֵ�Ǹ�user����
	public User login(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username,password);
	}
}
