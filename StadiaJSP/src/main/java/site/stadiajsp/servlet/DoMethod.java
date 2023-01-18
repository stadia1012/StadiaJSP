package site.stadiajsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Session 객체를 이용한 값 저장

@WebServlet("/doMethod")
public class DoMethod extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공통으로 처리되는 라인");
		
		if (request.getMethod().equals("GET")) {
			System.out.println("GET 요청 수신");
		} else if (request.getMethod().equals("POST")) {
			System.out.println("POST 요청 수신");
		}
		
		super.service(request, response); 
		// super.service 호출할 경우 doGet, doPost 등 해당하는 메서드 함수 없으면 405 오류 발생
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드가 호출됨");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드가 호출됨");
	}
}
