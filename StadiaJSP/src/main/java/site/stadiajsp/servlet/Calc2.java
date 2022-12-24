package site.stadiajsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// ServletContext를 이용한 값 저장

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();  // ServletContext 저장소
		
		
		String num_ = request.getParameter("num");
		String op = request.getParameter("operator");
		
		int num = 0;
		
		if ( !num_.equals("") ) num = Integer.parseInt(num_);  // 빈문자열인지 검사. 아니면 num에 저장

		
		if(op.equals("=")) {  // "="이면 계산
			int x = (Integer)application.getAttribute("number");  // getAttribute는 값을 Object로 반환하므로 강제 형변환
			int y = num;
			String operator = (String)application.getAttribute("operator");
			
			int result = 0;
			if(operator.equals("+")) {
				result = x+y;
			} else {
				result = x-y;
			}
			out.printf("Result is %d", result );
			
		} else {  // "="이 아닐 경우 값 저장
			application.setAttribute("number", num);
			application.setAttribute("operator", op);
			out.println("뒤로가기를 눌러 계산을 계속해주세요.");
		}
	}
}
