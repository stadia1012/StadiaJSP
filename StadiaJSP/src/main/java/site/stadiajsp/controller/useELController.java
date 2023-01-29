package site.stadiajsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/useEL")
public class useELController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 1012;
		
		
		request.setAttribute("num", num);  // "result"로 보내기
		
		// 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/useEL.jsp");
		dispatcher.forward(request, response);
	}
}
