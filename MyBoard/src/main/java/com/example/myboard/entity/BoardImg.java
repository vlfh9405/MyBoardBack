package com.example.myboard.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BOARDIMG")
public class BoardImg {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    @SequenceGenerator(name = "board_seq_gen", sequenceName = "BOARD_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 여러 이미지가 하나의 게시글에 속할 수 있음
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(name = "path")
    private String path;

    @Column(name = "regDate")
    private Date regDate;
}
