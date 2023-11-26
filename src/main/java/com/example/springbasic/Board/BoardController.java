package com.example.springbasic.Board;

import com.example.springbasic.Board.BoardRequestDto;
import com.example.springbasic.Board.BoardResponseDto;
import com.example.springbasic.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Transactional
    @PostMapping("/post")
    public Long createBoard(@RequestBody BoardRequestDto request) {
        return boardService.createBoard(request);
    }

    @GetMapping("/getAll")
    public List<BoardResponseDto> findAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/getOne/{id}")
    public BoardResponseDto findBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @Transactional
    @PutMapping("/update/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto request) {
        return boardService.updateBoard(id, request);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}
