package site.stadiajsp.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/oddOrEven2")
public class OddOrEven2Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		
		String result;
		if(num%2 != 0) {
			result = "홀수입니다.";
		} else {
			result = "짝수입니다.";
		}
		
		request.setAttribute("result", result);  // "result"로 보내기
		
		// 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/oddOrEven2.jsp");
		dispatcher.forward(request, response);  // jsp와 공유되는 저장소
	}
}
