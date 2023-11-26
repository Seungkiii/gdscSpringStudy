package com.example.springbasic.Board;

import java.util.List;

public interface BoardService {

    Long createBoard(BoardRequestDto request);

    List<BoardResponseDto> getAllBoards();

    BoardResponseDto getBoardById(Long id);

    Long updateBoard(Long id, BoardRequestDto request);

    Long deleteBoard(Long id);

}
