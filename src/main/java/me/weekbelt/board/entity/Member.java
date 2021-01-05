package me.weekbelt.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Member extends BaseEntity {

    @Id
    private String email;

    private String password;

    private String name;
}
