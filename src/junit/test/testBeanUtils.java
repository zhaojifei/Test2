package junit.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.form.RegisterForm;

public class testBeanUtils {
	public static void main(String[] args) {
		RegisterForm form = new RegisterForm();
		try {
			BeanUtils.setProperty(form, "username", "hong");
			System.out.println(form.getUsername());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
