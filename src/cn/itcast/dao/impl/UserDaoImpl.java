package cn.itcast.dao.impl;

import java.util.Date;

import org.dom4j.Document;//dom4j包是用来读取xml文档的
import org.dom4j.Element;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.DateUtils;
import cn.itcast.utils.XmlUtils;

//dao层从数据库中获取用户数据的具体实现
public class UserDaoImpl implements UserDao {
	//实现方法一：向数据库中插入新的user数据
	@Override
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			//获得xml文件的根节点
			Element root = document.getRootElement();
			//往根节点下添加子节点
			Element user_tag = root.addElement("user");
			user_tag.addAttribute("id", user.getId());
			user_tag.addAttribute("username", user.getUsername());
			user_tag.addAttribute("password", user.getPassword());
			user_tag.addAttribute("email", user.getEmail());
			user_tag.addAttribute("birthday", user.getBirthday()==null?"":DateUtils.dateToString(user.getBirthday()));
			user_tag.addAttribute("nickname", user.getNickname());
			//设置完要添加的数据之后不要忘了write2xml方法写入到xml文件中去
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//实现方法二：从数据库中查询指定的user数据
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
	//实现方法三：从数据库中查询某一user是否存在
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
