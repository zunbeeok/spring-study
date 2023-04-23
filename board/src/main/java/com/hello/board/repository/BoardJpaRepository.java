package com.hello.board.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.board.entity.BoardEntity;

public interface BoardJpaRepository extends JpaRepository<BoardEntity,Long> {

    
}
