package me.weekbelt.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.weekbelt.board.dto.BoardDTO;
import me.weekbelt.board.entity.Board;
import me.weekbelt.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto) {
        log.info(dto.toString());
        Board board = dtoToEntity(dto);
        boardRepository.save(board);

        return board.getBno();
    }
}
