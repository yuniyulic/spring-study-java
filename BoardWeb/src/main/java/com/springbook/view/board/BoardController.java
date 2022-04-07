package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//글 목록 변환 처리
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}
	
	
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); //Model 정보 저장
		return "getBoard.jsp"; //View 이름 리턴
	}
	
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
		
	//글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		//Null Check
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		//Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp"; //View 이름 리턴
	}
	
	//글 목록 검색
	//@RequestParam을 사용한 글 목록 검색 기능 구현 (BoardVO에 변수 추가 안 하고)
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(@RequestParam(value="searchCondition", 
//								defaultValue="TITLE", required=false) String condition, 
//								@RequestParam(value="searchKeyword", 
//								defaultValue="", required=false) String keyword, 
//								BoardDAO boardDAO, Model model) {
//		System.out.println("검색 조건 : " + condition);
//		System.out.println("검색 단어 : " + keyword);
//		
//		//model.addAttribute("boardList", boardDAO.getBoardList(vo)); //Model 정보 저장
//		return "getBoardList.jsp"; //View 이름 리턴
//	}
	
}
