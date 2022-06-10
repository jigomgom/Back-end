//package com.mini.babmeokeon.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mini.babmeokeon.dto.ResponseDto;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class customFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("MyCustomFilter");
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (request instanceof HttpServletRequest && httpRequest.getMethod().equals("POST") && httpRequest.getRequestURI().equals("/signin") && authentication != null) {
//            System.out.println("이미 로그인 되어 있습니다.");
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json");
//            ObjectMapper mapper = new ObjectMapper();
//            ResponseDto<Object> responseDto = new ResponseDto<>(true, "로그인 성공");
//            String result =mapper.writeValueAsString(responseDto);
//            response.getWriter().write(result);
//        }else {
//            filterChain.doFilter(request, response);
//        }
//    }
//
//}

