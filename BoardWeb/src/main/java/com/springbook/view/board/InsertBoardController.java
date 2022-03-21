package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertBoardController {

	@RequestMapping(value="/insertBoard.do")//value 속성은 대부분 생략함.
	public void insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		
		BoardDAO boardDAO = new BoardDAO();
		
		boardDAO.insertBoard(vo);
		
	}
}
