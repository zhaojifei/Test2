package cn.itcast.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {
	//作用是把request中的数据给到bean中去
				//返回值的类型对应传进来的类型							//传进来一个RegisterForm.class
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){
		//创建要封装对象的bean
		try {
			//创建要封装数据的bean
			T bean = beanClass.newInstance();
			//把request中的数据整到上面的bean中
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();//获得username，password等标签
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch(Exception e){
			System.out.println("webUtils出错");
			throw new RuntimeException(e);
		}
	}
	
	//进行两个Bean之间属性值的复制
	public static void copyBean(Object src,Object dest){
		//注册一个转换器，用来将Date类型转换成String类型
		ConvertUtils.register(new Converter(){
			public Object convert(Class type, Object value) {
				if(value==null){
					return null;
				}
				String str = (String) value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}	
		}, Date.class);
		//执行两个Bean之间数据的复制，复制的机制是共同有的属性进行复制，属性类型不同要进行转换
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//产生全球唯一的ID值
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
}
