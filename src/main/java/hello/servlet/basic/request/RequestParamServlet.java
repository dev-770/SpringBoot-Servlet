package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. �Ķ���� ���� ���
 * http://localhost:8081/request-param?username=hello&age=20
 * @author User
 * 2. ������ �Ķ���� ���� ����
 * http://localhost:8081/request-param?username=hello&username=kim&age=20
 */

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("req");
		System.out.println("[��ü �Ķ���� ��ȸ] -  start");
		req.getParameterNames().asIterator()
			.forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));
		System.out.println("[��ü �Ķ���� ��ȸ] -  end");
		System.out.println();
		
		System.out.println("[���� �Ķ���� ��ȸ] - start");
		String username = req.getParameter("username");
		String age = req.getParameter("age");
		System.out.println("username = " + username);
		System.out.println("age = " + age);
		System.out.println("[���� �Ķ���� ��ȸ] - end");
		System.out.println();
		
		System.out.println("[�̸��� ���� ���� �Ķ���� ��ȸ]");
		String[] usernames = req.getParameterValues("username");
		 for (String name : usernames) {
			 System.out.println("username=" + name);
		 }
		
		resp.getWriter().write("ok");
	}
}
