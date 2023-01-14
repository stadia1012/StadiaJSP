package site.stadiajsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		try {
			for ( int i=0; i<num_.length; i++ ) {
				int num = 0;			// for문 안에서의 num 선언? 변수 선언이 반복되어 부적절하지 않은가? -> num은 for문 안에서만 사용되는 지역변수로 바람직하다고 볼 수 있다.
				if (!num_[i].equals("")) {
					num = Integer.parseInt(num_[i]);
				}
				result += num;
			}
		} catch(NumberFormatException e) {
			out.println("Please submit numbers(integers) only.");
			return;
		}

		out.printf("result is %d", result );
		
	}
}
