package me.weekbelt.board.entity;

import lombok.*;

import javax.persistence.*;

@ToString(exclude = "board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
