package me.weekbelt.board.service;


import me.weekbelt.board.dto.BoardDTO;
import me.weekbelt.board.entity.Board;
import me.weekbelt.board.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder().email(dto.getWriterEmail()).build();

        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
    }
}
