package junit.test;

import java.util.Date;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.utils.DateUtils;

public class UserTest {
	
	public static void main(String[] args){
		testAdd();
		//testFind();
		//testFind1();
	}
	
	public static void testAdd(){
		User user = new User();
		user.setId("2");
		user.setUsername("hong2");
		user.setPassword("222222");
		user.setEmail("2@2.com");
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//		Date d = new Date();
//		user.setBirthday(d);
		String birthday = "1990-01-01";
		Date d = DateUtils.stringToDate(birthday);
		user.setBirthday(d);
		user.setNickname("2hong2");
		UserDao testAdd = new UserDaoImpl();
		testAdd.add(user);
	}
	
	public static void testFind(){
		UserDao testFind = new UserDaoImpl();
		testFind.find("hong1", "111111");
	}
	
	public static void testFind1(){
		UserDao testFind1 = new UserDaoImpl();
		System.out.println(testFind1.find("hong4"));
	}
}
