package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * HttpServletRequest �⺻
 * @author User
 *
 */

@WebServlet(urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet  {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		printStartLine(req);
//		printHeaders(req);
//		printHeaderUtils(req);
//		printEtc(req);
	}
	
	private void printStartLine(HttpServletRequest req) {
		 System.out.println("--- REQUEST-LINE - start ---");
		 System.out.println("request.getMethod() = " + req.getMethod()); //GET
		 System.out.println("request.getProtocal() = " + req.getProtocol()); // HTTP/1.1
		 System.out.println("request.getScheme() = " + req.getScheme()); //http
		 // http://localhost:8080/request-header
		 System.out.println("request.getRequestURL() = " + req.getRequestURL());
		 // /request-test
		 System.out.println("request.getRequestURI() = " + req.getRequestURI());
		 //username=hi
		 System.out.println("request.getQueryString() = " + req.getQueryString());
		 System.out.println("request.isSecure() = " + req.isSecure()); //https ��� ����
		 System.out.println("--- REQUEST-LINE - end ---");
		 System.out.println();
	}
	
	//Header ��� ����
	private void printHeaders(HttpServletRequest req) {
		System.out.println("--- Headers - start ---");
		
		/*
		 * Enumeration<String> headerNames = req.getHeaderNames(); while
		 * (headerNames.hasMoreElements()) { String headerName =
		 * headerNames.nextElement(); System.out.println(headerName + ": " +
		 * req.getHeader(headerName)); }
		 */
		
		 req.getHeaderNames().asIterator()
		 .forEachRemaining(headerName -> System.out.println(headerName + ": " + req.getHeader(headerName)));
		 System.out.println("--- Headers - end ---");
		 System.out.println();
	}
	
	
	//Header ���� ��ȸ
	private void printHeaderUtils(HttpServletRequest req) {
	 System.out.println("--- Header ���� ��ȸ start ---");
	 System.out.println("[Host ���� ��ȸ]");
	 System.out.println("request.getServerName() = " + req.getServerName()); //Host ���
	 System.out.println("request.getServerPort() = " + req.getServerPort()); //Host ���
	 System.out.println();
	 System.out.println("[Accept-Language ���� ��ȸ]");
	 req.getLocales().asIterator()
	 .forEachRemaining(locale -> System.out.println("locale = " + locale));
	 System.out.println("request.getLocale() = " + req.getLocale());
	 System.out.println();
	 System.out.println("[cookie ���� ��ȸ]");
	 if (req.getCookies() != null) {
		 for (Cookie cookie : req.getCookies()) {
			 System.out.println(cookie.getName() + ": " + cookie.getValue());
		 }
	 }
	 System.out.println();
	 System.out.println("[Content ���� ��ȸ]");
	 System.out.println("request.getContentType() = " + req.getContentType());
	 System.out.println("request.getContentLength() = " + req.getContentLength());
	 System.out.println("request.getCharacterEncoding() = " + req.getCharacterEncoding());
	 System.out.println("--- Header ���� ��ȸ end ---");
	 System.out.println();
	}
	
	private void printEtc(HttpServletRequest request) {
		 System.out.println("--- ��Ÿ ��ȸ start ---");
		 System.out.println("[Remote ����]");
		 System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
		 System.out.println("request.getRemoteAddr() = " +	request.getRemoteAddr()); //
		 System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
		 System.out.println();
		 System.out.println("[Local ����]");
		 System.out.println("request.getLocalName() = " + request.getLocalName()); //
		 System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
		 System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
		 System.out.println("--- ��Ÿ ��ȸ end ---");
		 System.out.println();
	}
}
