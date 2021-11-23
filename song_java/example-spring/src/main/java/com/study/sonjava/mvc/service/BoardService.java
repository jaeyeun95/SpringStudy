package com.study.sonjava.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.parameter.BoardParameter;
import com.study.sonjava.mvc.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/**
	 * 단순 반복문을 이용한 등록 처리.
	 */
	// connection 을 10000번을 열었다 닫았다... 시간이 오래걸림 --> 100건 이하에서 사용 권장
	public void saveList1(List<BoardParameter> list){
		for(BoardParameter parameter : list){
			repository.save(parameter);
		}
	}
	/**
	 * 100개씩 배열에 담아서 일괄 등록 처리.
	 * list로 묶어서 1번의 connection으로 INSERT 성공
	 */
	public void saveList2(List<BoardParameter> boardlist){
		Map<String, Object> paramap = new HashMap<String, Object>();
		paramap.put("boardList", boardlist);
		repository.saveList(paramap);
	}

	
	public void update(Board board) {
		repository.update(board);
	}
	
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}
}
