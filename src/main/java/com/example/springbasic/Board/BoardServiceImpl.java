package com.example.springbasic.Board;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    
    //@Autowired 보다는 생성자 주입 방식으로
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public Long createBoard(BoardRequestDto request) {
        Board board = request.toEntity();
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getPostNumber();
    }

    @Override
    public List<BoardResponseDto> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public BoardResponseDto getBoardById(Long id) {
        Optional<Board> boardId = boardRepository.findById(id);
        Board board = boardId.orElseThrow(() -> new IllegalStateException("Board not found with id: " + id));
        return new BoardResponseDto(board);
    }

    @Override
    @Transactional
    public Long updateBoard(Long id, BoardRequestDto request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Board not found with id: " + id));


        board.update(request.getTitle(),
                request.getViews(), request.getCategory(), request.getMemberId());

        return board.getPostNumber();
    }


    @Override
    @Transactional
    public Long deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Board not found with id: " + id));

        // Soft delete 수행
        board.softDelete();

        return board.getPostNumber();
    }
}
