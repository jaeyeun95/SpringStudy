package com.study.sonjava.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.sonjava.mvc.domain.Board;

@Repository
public interface BoardRepository {
	
	List<Board> getList();
	
	Board get(int boardSeq);
	
	void save(Board board);
	
	void update(Board board);
	
	void delete(int boardSeq);

}
