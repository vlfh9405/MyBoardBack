package com.example.myboard.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BOARD")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    @SequenceGenerator(name = "board_seq_gen", sequenceName = "BOARD_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "regDate")
    private Date regDate;
}
