package site.stadiajsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/scope")
public class scopeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 1012;
		
		request.setAttribute("number", num);
		
		// 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/scope.jsp");
		dispatcher.forward(request, response);
	}
}
