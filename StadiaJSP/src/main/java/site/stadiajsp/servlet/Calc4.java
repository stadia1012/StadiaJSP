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

@WebServlet("/calc4")
public class Calc4 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		ServletContext application = request.getServletContext();  // application 저장소
//		HttpSession session = request.getSession();  //  Session
		Cookie[] cookies = request.getCookies();  // cookie는 배열로 선언
		
		String num_ = request.getParameter("num");
		String op = request.getParameter("operator");
		
		int num = 0;
		
		if ( !num_.equals("") ) num = Integer.parseInt(num_);  // 빈문자열인지 검사.

		
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
//			session.setAttribute("number", num);
//			session.setAttribute("operator", op);
			Cookie valueCookie = new Cookie("value", String.valueOf(num));  // Cookie는 String만 저장 가능
			Cookie opCookie = new Cookie("op", op);
			
			response.addCookie(valueCookie);  // 쿠키 클라이언트에 저장
			response.addCookie(opCookie);  
			
			out.println("뒤로가기를 눌러 계산을 계속해주세요.");
		}
	}
}
