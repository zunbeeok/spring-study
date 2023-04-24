package com.hello.board.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.board.dto.BoardDto;
// import com.hello.board.dto.BoardDto;
import com.hello.board.entity.Board;
import com.hello.board.repository.BoardJpaRepository;

@Service
public class BoardService {
    
    private final BoardJpaRepository boardJpaRepository;

    @Autowired
    public BoardService(BoardJpaRepository boardJpaRepository){
        this.boardJpaRepository = boardJpaRepository;
    }

    public List<Board> getBoardList(){
        List<Board> boardList = boardJpaRepository.findAll();
        return boardList;
    }

    public Board getBoard(Long id){
        Optional<Board> board = boardJpaRepository.findById(id);

        // if(board.isPresent()){
        //     return board.get();
        // }else{

        // }
        
        return board.get();
    }

    public void setBoard(Board board){
        SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.format(LocalDate.now());
        BoardDto boardDto= new BoardDto();
        boardDto.setDate();
        boardJpaRepository.save(board);
    }



}
