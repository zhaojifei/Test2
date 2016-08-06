package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.DateUtils;
import cn.itcast.utils.WebUtils;
import cn.itcast.web.form.RegisterForm;

//处理注册请求
public class RegisterServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		request.setCharacterEncoding("UTF-8");
 		//1.对提交的表单进行合法性验证，并且将数据封装到form中
 		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
 		boolean b = form.isOK();
 		//2.如果校验失败，跳回到表单页面，回显错误信息
 		if(!b){
 			request.setAttribute("form", form);
 			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
 			return;
 		}		
 		//3.如果校验成功，则调用Service处理注册请求
 		User user = new User();
 		WebUtils.copyBean(form, user);
 		user.setId(WebUtils.generateID());
 		BusinessServiceImpl service = new BusinessServiceImpl();
 		try {
 		//6.如果Service处理 成功，则跳转到网站的全局消息显示页面，为用户显示注册成功消息。
			service.register(user);
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (UserExistException e) {
		//4.如果Service处理不成功，并且不成功的原因是注册用户已存在，则跳回注册页面，显示注册用户已存在的消息
			form.getErrors().put("username", "用户已存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}catch(Exception e){
		//5.如果Service处理不成功，并且不成功的原因是其他问题，则跳转到网站的全局消息显示页面，为用户显示友好错误提示
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知异常");
			request.getRequestDispatcher("/WEB-INF/jsp/message").forward(request, response);
		}
	}

}
