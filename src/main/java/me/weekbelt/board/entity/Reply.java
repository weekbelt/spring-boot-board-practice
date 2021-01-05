package me.weekbelt.board.entity;

import lombok.*;

import javax.persistence.*;

@ToString(exclude = "board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    private Board board;
}
