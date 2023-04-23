package com.hello.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import com.hello.board.domain.Board;
import com.hello.board.entity.Board;
import com.hello.board.dto.BoardDto;
import com.hello.board.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("board")
public class BoardController {
    
    //di주입.
    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    // //처음 들어오는 페이지.
    // @GetMapping("/list")
    // public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum){
    //     List<Board> boardList = boardService.getBoardList();
    //     model.addAttribute("boardList", boardList);
    //     return "list";
    // }

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Long id,Model model){
        Board board = boardService.getBoard(id);
        // model.addAttribute("title", board.get);
        // model.addAttribute("mainText", board);
        model.addAttribute("board", board);
        return "board/view";
    }

    @GetMapping("/write")
    public String writeForm(){
        return "board/write";
    }


    //body로 받을때 writeForm객체에 어떻게 데이터가 맵핑되는지 궁금하다.
    //Board는 entity고 controller에 entity를 적는건 위험하다고 했던것 같다.
    //어떻게 고쳐야 테스트 주도 설계에 맞게 될수있을까 entity를 여기에 적는게 맞을까?
    @PostMapping(value="/write")
    public void postMethodName(Board board) {
        boardService.setBoard(board);
    }
    
}

class WriteForm{
    private String title;

    private String mainText;

    private String writer;

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getMainText() {
        return mainText;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    public String getWriter() {
        return writer;
    }
}


