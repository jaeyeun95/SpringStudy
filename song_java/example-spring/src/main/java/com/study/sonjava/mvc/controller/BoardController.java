package com.study.sonjava.mvc.controller;

import java.util.List;

import com.study.sonjava.configuration.http.BaseResponse;
import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {


	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public BaseResponse<List<Board>> getList(){
		return new BaseResponse<List<Board>>(boardService.getList());
	}
	
	@GetMapping("/{boardSeq}")
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		return new BaseResponse<Board>(boardService.get(boardSeq));
	}
	
	/**
	 * 등록/수정 처리
	 * @param board
	 */
	@GetMapping("/save")
	public BaseResponse<Integer> save(Board parameter) {
		boardService.save(parameter);
		return new BaseResponse<Integer>(parameter.getBoardSeq());
	}
	
//	public void updates(Board board) {
//		boardService.updates(board);
//	}
	
	@GetMapping("/delete/{boardSeq}")
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if( board == null){
			return new BaseResponse<Boolean>(false);
		}
		boardService.delete(boardSeq);
		return new BaseResponse<Boolean>(true);
	}
}
