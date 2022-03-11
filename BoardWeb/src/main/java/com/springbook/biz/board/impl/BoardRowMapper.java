//package com.springbook.biz.board.impl;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.springbook.biz.board.BoardVo;
//
//public class BoardRowMapper implements RowMapper<BoardVo> {
//	public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//		BoardVo board = new BoardVo();
//		board.setSeq(rs.getInt("SEQ"));
//		board.setTitle(rs.getString("TITLE"));
//		board.setWriter(rs.getString("WRITER"));
//		board.setContent(rs.getString("CONTENT"));
//		board.setRegDate(rs.getDate("REGDATE"));
//		board.setCnt(rs.getInt("CNT"));
//		return board;
//	}
//	
//}
