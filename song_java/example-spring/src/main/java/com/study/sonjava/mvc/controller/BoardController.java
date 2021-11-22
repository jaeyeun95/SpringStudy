package com.study.sonjava.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {


	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public List<Board> getList(){
		return boardService.getList();
	}
	
	@GetMapping("/{boardSeq}")
	public Board get(@PathVariable int boardSeq) {
		return boardService.get(boardSeq);
	}
	
	/**
	 * 등록/수정 처리
	 * @param board
	 */
	@GetMapping("/save")
	public int save(Board parameter) {
		boardService.save(parameter);
		return	parameter.getBoardSeq();
	}
	
//	public void updates(Board board) {
//		boardService.updates(board);
//	}
	
	@GetMapping("/delete/{boardSeq}")
	public boolean delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if( board == null){
			return false;
		}
		boardService.delete(boardSeq);
		return true;
	}
}
