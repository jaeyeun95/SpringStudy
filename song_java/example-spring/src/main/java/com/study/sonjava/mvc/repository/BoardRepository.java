package com.study.sonjava.mvc.repository;

import java.util.List;
import java.util.Map;

import com.study.sonjava.mvc.domain.Board;
import com.study.sonjava.mvc.parameter.BoardParameter;
import com.study.sonjava.mvc.parameter.BoardSearchParameter;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository {
	
	// List<Board> getList();
	List<Board> getList(BoardSearchParameter parameter);
	
	Board get(int boardSeq);
	
	void save(Board board);
	void save(BoardParameter board);
	void saveList(Map<String, Object> paramap);
	
	void update(Board board);
	
	void delete(int boardSeq);

}
