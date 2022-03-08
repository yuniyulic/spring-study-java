package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVo vo) {
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVo vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		return boardDAO.getBoardList(vo);
	}

}
