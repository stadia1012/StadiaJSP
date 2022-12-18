package site.stadiajsp.servlet.filter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// 필터는 tomcat 시작 시 실행. 이후 요청이 있을 때마다 실행

@WebFilter("/*")  // 모든 URL에 적용
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8"); // 이 3개 코드를 필터에 쓰면 다른 서블릿엔 쓰지 않아도 된다.
		
		System.out.println("before filter");  // 서블릿 실행 전 실행됨
		chain.doFilter(request, response);  // 다음 필터나 서블릿으로 흐름 넘김
		System.out.println("after filter");  // 서블릿 실행 후 실행됨
	}
}
