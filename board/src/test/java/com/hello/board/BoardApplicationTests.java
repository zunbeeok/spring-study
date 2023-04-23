package com.hello.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hello.board.repository.BoardJpaRepository;
import com.hello.board.service.BoardService;

@SpringBootTest
class BoardApplicationTests {

	private BoardService boardService;
	private BoardJpaRepository boardJpaRepository;

	@BeforeEach
	public void BeforeEach(){
		// boardJpaRepository = new BoardJpaRepository();
		// boardService =  new BoardService(boardJpaRepository);
	}

	@Test
	void contextLoads() {
	}



}
