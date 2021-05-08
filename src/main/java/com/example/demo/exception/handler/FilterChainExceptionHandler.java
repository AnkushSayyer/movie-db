//package com.example.demo.exception.handler;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.example.demo.exception.UnauthorizedException;
//
//@Component
//public class FilterChainExceptionHandler extends OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		try {
//			filterChain.doFilter(request, response);
//		}
//		catch(UnauthorizedException ex) {
//			response.setStatus(HttpStatus.UNAUTHORIZED.value());
//			response.getWriter().write("Please Login first");
//		}
//	}
//
//}
