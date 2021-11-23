package com.study.sonjava.mvc.controller;

import java.util.List;

import com.study.sonjava.configuration.exception.BaseException;
import com.study.sonjava.configuration.http.BaseResponse;
import com.study.sonjava.configuration.http.BaseResponseCode;
import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
		Board board = boardService.get(boardSeq);
		// null 처리
		if ( board == null ){
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] { "게시물" });
		}
		return new BaseResponse<Board>(boardService.get(boardSeq));
	}
	
	/**
	 * 등록/수정 처리
	 * @param board
	 */
	@GetMapping("/save")
	public BaseResponse<Integer> save(Board parameter) {
		// 제목 필수 체크
		// if ( StringUtils.isEmpty(parameter.getTitle())){
		if ( "".equals(parameter.getTitle()) || parameter.getTitle() == null){
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title" ,"제목" });
		}
		// 내용 필수 체크
		// if ( StringUtils.isEmpty(parameter.getContents())){
		if ( "".equals(parameter.getContents()) || parameter.getContents() == null){
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents" ,"내용" });
		}
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
