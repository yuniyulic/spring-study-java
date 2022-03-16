package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		process(request, response);
		System.out.println("doGet왔음");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		process(request, response);
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost왔음");
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 클라이언트의 요청 path 정보를 추출한다.
		System.out.println("Dispatcher path정보 추출전");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		System.out.println("Dispatcher path정보 추출후");
		
		//2. 클라이언트의 요청 path에 따라 적절히 분기처리 한다.
		System.out.println("DispatcherServlet 들어옴");
		//로그인
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			//1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. 화면 네비게이션
			if (user != null) {
				response.sendRedirect("getBoardList.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
		}
	}

}
