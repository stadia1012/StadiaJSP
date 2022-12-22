package site.stadiajsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");
		
		int x = 0;  // 기본값 지정
		int y = 0;
		
		if ( !x_.equals("") ) x = Integer.parseInt(x_);  // 빈문자열인지 검사. 빈문자일 경우 기본값임.
		if ( !y_.equals("") ) y = Integer.parseInt(y_);
		
		
		int result = 0;
		
		if ( op.equals("add") ) result = x+y;  // ==이 아닌 .equals()로 검사. 인스턴스 일치 여부가 아닌 값 비교.
		if ( op.equals("substract") ) result = x-y;
		
		out.printf("Result is %d", result );
		
	}
}
