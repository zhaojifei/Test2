package cn.itcast.dao.impl;

import java.util.Date;

import org.dom4j.Document;//dom4j����������ȡxml�ĵ���
import org.dom4j.Element;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.DateUtils;
import cn.itcast.utils.XmlUtils;

//dao������ݿ��л�ȡ�û����ݵľ���ʵ��
public class UserDaoImpl implements UserDao {
	//ʵ�ַ���һ�������ݿ��в����µ�user����
	@Override
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			//���xml�ļ��ĸ��ڵ�
			Element root = document.getRootElement();
			//�����ڵ�������ӽڵ�
			Element user_tag = root.addElement("user");
			user_tag.addAttribute("id", user.getId());
			user_tag.addAttribute("username", user.getUsername());
			user_tag.addAttribute("password", user.getPassword());
			user_tag.addAttribute("email", user.getEmail());
			user_tag.addAttribute("birthday", user.getBirthday()==null?"":DateUtils.dateToString(user.getBirthday()));
			user_tag.addAttribute("nickname", user.getNickname());
			//������Ҫ��ӵ�����֮��Ҫ����write2xml����д�뵽xml�ļ���ȥ
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//ʵ�ַ������������ݿ��в�ѯָ����user����
	@Override
	public User find(String username,String password){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element)document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			String birthday = e.attributeValue("birthday");
			if(birthday==null || birthday==""){
				user.setBirthday(null);
			}else{
				Date d = DateUtils.stringToDate(birthday);
				user.setBirthday(d);
			}
			user.setNickname(e.attributeValue("nickname"));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//ʵ�ַ������������ݿ��в�ѯĳһuser�Ƿ����
	@Override
	public boolean find(String username){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element)document.selectSingleNode("//user[@username='"+username+"']");
			if(e==null){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
