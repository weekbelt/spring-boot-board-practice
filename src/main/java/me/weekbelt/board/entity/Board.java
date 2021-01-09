package me.weekbelt.board.entity;

import lombok.*;

import javax.persistence.*;

@ToString(exclude = "writer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
