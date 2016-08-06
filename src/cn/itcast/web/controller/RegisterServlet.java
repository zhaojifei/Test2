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

//����ע������
public class RegisterServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		request.setCharacterEncoding("UTF-8");
 		//1.���ύ�ı����кϷ�����֤�����ҽ����ݷ�װ��form��
 		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
 		boolean b = form.isOK();
 		//2.���У��ʧ�ܣ����ص���ҳ�棬���Դ�����Ϣ
 		if(!b){
 			request.setAttribute("form", form);
 			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
 			return;
 		}		
 		//3.���У��ɹ��������Service����ע������
 		User user = new User();
 		WebUtils.copyBean(form, user);
 		user.setId(WebUtils.generateID());
 		BusinessServiceImpl service = new BusinessServiceImpl();
 		try {
 		//6.���Service���� �ɹ�������ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾע��ɹ���Ϣ��
			service.register(user);
			request.setAttribute("message", "ע��ɹ�");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (UserExistException e) {
		//4.���Service�����ɹ������Ҳ��ɹ���ԭ����ע���û��Ѵ��ڣ�������ע��ҳ�棬��ʾע���û��Ѵ��ڵ���Ϣ
			form.getErrors().put("username", "�û��Ѵ���");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}catch(Exception e){
		//5.���Service�����ɹ������Ҳ��ɹ���ԭ�����������⣬����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����ʾ
			e.printStackTrace();
			request.setAttribute("message", "����������δ֪�쳣");
			request.getRequestDispatcher("/WEB-INF/jsp/message").forward(request, response);
		}
	}

}
