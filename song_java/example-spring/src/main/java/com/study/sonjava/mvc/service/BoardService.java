package com.study.sonjava.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.repository.BoardRepository;

/*
 * 게시판 서비스
 * @author 재윤
 * */
@Service
public class BoardService {

	@Autowired
	private BoardRepository repository;
	
	public List<Board> getList(){
		return repository.getList();
	}
	
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}
	
	public int save(Board parameter) {
		// 조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq());
		if (board == null){
			repository.save(parameter);
		}else {
			repository.update(parameter);
		}
		return parameter.getBoardSeq();
	}
	
	public void update(Board board) {
		repository.update(board);
	}
	
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}
}
