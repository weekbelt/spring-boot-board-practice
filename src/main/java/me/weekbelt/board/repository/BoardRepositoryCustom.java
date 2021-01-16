package me.weekbelt.board.repository;

import me.weekbelt.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
    Board search1();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
