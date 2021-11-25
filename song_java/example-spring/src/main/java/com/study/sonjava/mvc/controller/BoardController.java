package com.study.sonjava.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.sonjava.configuration.exception.BaseException;
import com.study.sonjava.configuration.http.BaseResponse;
import com.study.sonjava.configuration.http.BaseResponseCode;
import com.study.sonjava.framework.web.bind.annotation.RequestConfig;
import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.parameter.BoardParameter;
import com.study.sonjava.mvc.parameter.BoardSearchParameter;
import com.study.sonjava.mvc.service.BoardService;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {


	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public BaseResponse<List<Board>> getList(BoardSearchParameter parameter){
		return new BaseResponse<List<Board>>(boardService.getList(parameter));
	}
	// @GetMapping("/list")
	// public List<Board> getList2(){
	// 	return boardService.getList();
	// }
	
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
	@PutMapping("/save")
	@RequestConfig
	// @GetMapping("/save")
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

	/**
	 * 대용량 등록 처리
	 */
	@PutMapping("/saveList1")
	public BaseResponse<Boolean> saveList1(){
		int count = 0;
		// 테스트를 위한 랜덤 1000건의 데이터를 생ㅅ어
		List<BoardParameter> list = new ArrayList<BoardParameter>();
		while(true){
			count++;
			String title = RandomStringUtils.randomAlphabetic(10);
			String contents = RandomStringUtils.randomAlphabetic(10);
			list.add(new BoardParameter(title, contents));
			if ( count >= 10000){
				break;
			}
		}
		// 시간 측정을 위해 start, end를 구하여 초로 출력
		long start = System.currentTimeMillis();
		boardService.saveList1(list);
		long end = System.currentTimeMillis();
		log.info("실행시간 : {} ", (end - start) / 1000.0);
		return new BaseResponse<Boolean>(true);

	}

	/**
	 * 대용량 처리 2
	 */
	@PutMapping("/saveList2")
	public BaseResponse<Boolean> saveList2(){
		int count = 0;
		// 테스트를 위한 랜덤 1000건의 데이터를 생ㅅ어
		List<BoardParameter> list = new ArrayList<BoardParameter>();
		while(true){
			count++;
			String title = RandomStringUtils.randomAlphabetic(10);
			String contents = RandomStringUtils.randomAlphabetic(10);
			list.add(new BoardParameter(title, contents));
			if ( count >= 50){
				break;
			}
		}
		// 시간 측정을 위해 start, end를 구하여 초로 출력
		long start = System.currentTimeMillis();
		boardService.saveList2(list);
		long end = System.currentTimeMillis();
		log.info("실행시간 : {} ", (end - start) / 1000.0);
		return new BaseResponse<Boolean>(true);

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
