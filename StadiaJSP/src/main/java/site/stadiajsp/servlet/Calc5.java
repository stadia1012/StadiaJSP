package site.stadiajsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Session 객체를 이용한 값 저장

@WebServlet("/calc5")
public class Calc5 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();  // cookie는 배열로 선언
		
		String num_ = request.getParameter("num");
		String op = request.getParameter("operator");
		
		int num = 0;
		
		if ( !num_.equals("") ) num = Integer.parseInt(num_);  // 빈문자열 검사.

		
		if(op.equals("=")) {  // "="이면 계산
			int x = 0;
			int y = num;
			for( Cookie c : cookies ) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt( c.getValue() );
					break;
				}
			}
			String operator = "";
			for( Cookie c : cookies ) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			int result = 0;
			if(operator.equals("+")) {
				result = x+y;
			} else {
				result = x-y;
			}
			out.printf( "Result is %d", result );
			
		} else {  // "="이 아닐 경우 값 저장
//			session.setAttribute("number", num);  // session 방식
//			session.setAttribute("operator", op);
			Cookie valueCookie = new Cookie("value", String.valueOf(num));  // Cookie는 String만 저장 가능
			Cookie opCookie = new Cookie("op", op);
			
//			## setPath : 쿠키를 사용할 URL 지정. 하위 URL 요청 시에만 쿠키가 전달됨. 기본값은 루트("/")
//			valueCookie.setPath("/");  // 모든 URL 요청 시 valueCookie 전달됨
//			opCookie.setPath("/");	
			
			valueCookie.setMaxAge(24*60*60); // 만료기간 설정. 단위: 초. 설정 안하면 브라우저 종료 시 제거.
			opCookie.setMaxAge(24*60*60);		
			
			response.addCookie(valueCookie);  // 쿠키 클라이언트에 저장
			response.addCookie(opCookie);  
			
			response.sendRedirect("/calc4.html");  // 리다이렉션
		}
	}
}
