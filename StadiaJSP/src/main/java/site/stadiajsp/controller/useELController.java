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

@WebServlet("/useEL")
public class useELController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 1012;

		ArrayList<String> array1 = new ArrayList<>();
		array1.add("White");
		array1.add("Black");
		array1.add("Red");
		
		
		HashMap<String,Object> map1 = new HashMap<String, Object>();
		map1.put("name", "Stadia");
		map1.put("email", "stadia@gmail.com");
		
		
		request.setAttribute("number", num);
		request.setAttribute("arrayList", array1);
		request.setAttribute("map1", map1);
		
		
		// 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/useEL.jsp");
		dispatcher.forward(request, response);
	}
}
