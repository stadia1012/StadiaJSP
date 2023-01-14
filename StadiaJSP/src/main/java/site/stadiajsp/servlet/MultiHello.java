package site.stadiajsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/multihello")
public class MultiHello extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cnt_ = request.getParameter("cnt");  // cnt 기본값 설정 위해 임시 변수인 cnt_에 담기 / String타입으로 받아옴
		int cnt = 10;

		if( cnt_ != null && !cnt_.equals("") ) {
			cnt = Integer.parseInt(cnt_);
		}
		
		for (int i=0; i < cnt; i++) {
			out.println( (i+1) + ": Hello! 안녕하세요! <br >");
			// println인데 개행이 안되는 이유? -> html 코드를 보내는 것으로 html 코드가 개행됨
		}
		
	}
}
