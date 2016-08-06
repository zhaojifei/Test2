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
	//�����ǰ�request�е����ݸ���bean��ȥ
				//����ֵ�����Ͷ�Ӧ������������							//������һ��RegisterForm.class
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){
		//����Ҫ��װ�����bean
		try {
			//����Ҫ��װ���ݵ�bean
			T bean = beanClass.newInstance();
			//��request�е��������������bean��
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();//���username��password�ȱ�ǩ
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch(Exception e){
			System.out.println("webUtils����");
			throw new RuntimeException(e);
		}
	}
	
	//��������Bean֮������ֵ�ĸ���
	public static void copyBean(Object src,Object dest){
		//ע��һ��ת������������Date����ת����String����
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
		//ִ������Bean֮�����ݵĸ��ƣ����ƵĻ����ǹ�ͬ�е����Խ��и��ƣ��������Ͳ�ͬҪ����ת��
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����ȫ��Ψһ��IDֵ
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
}
