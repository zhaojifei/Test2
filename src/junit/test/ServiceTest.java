package junit.test;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.DateUtils;

public class ServiceTest {
	
	public static void main(String[] args) throws UserExistException{
//		testRegister();
		testLogin();
	}
	
	public static void testRegister() throws UserExistException{
		User user = new User();
		user.setId("1");
		user.setUsername("hong1");
		user.setPassword("111111");
		user.setEmail("1@1.com");
		String s = "1990-01-01";
		user.setBirthday(DateUtils.stringToDate(s));
		user.setNickname("1hong1");
		BusinessServiceImpl bSI = new BusinessServiceImpl();
		try{
			bSI.register(user);
			System.out.println("注册成功");
		}catch(UserExistException e){
			System.out.println("用户已存在");
		}
		
	}
	
	public static void testLogin(){
		BusinessServiceImpl bSI = new BusinessServiceImpl();
		User user = bSI.login("hong2", "222222");
		System.out.println(user.getNickname());
	}
}
