package com.example.myboard.controller;

import com.example.myboard.entity.Board;
import com.example.myboard.service.BoardService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AutoConfiguration
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public Page<Board> boardList() {

    }
}
