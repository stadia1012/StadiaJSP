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

@WebServlet("/calc5Post")
public class Calc5Post extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp ="0"; 
		if (cookies != null) {
			for( Cookie c : cookies ) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		if (operator != null && operator.equals("÷")) {
			operator = "/";
		} else if (operator != null && operator.equals("X")) {
			operator = "*";
		} else if (operator != null && operator.equals("BS")) {
			exp = exp.substring(0, exp.length()-1 );
			operator = "=";
		}
		
		if(operator != null && operator.equals("=")) {  // = 연산자는 계산. 나머지는 누적
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js"); // js엔진 사용
			try {
				exp = String.valueOf( engine.eval(exp) );
				if (exp.equals("null")) exp = "0";
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			exp += (value == null)?"":value;
			exp += (operator == null)?"":operator;
			exp += (dot == null)?"":operator;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		response.addCookie(expCookie);
		response.sendRedirect("calc5");
	}
}
