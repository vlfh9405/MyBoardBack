package com.example.myboard.controller;

import com.example.myboard.dto.BoardDto;
import com.example.myboard.entity.Board;
import com.example.myboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public List<BoardDto> boardList() {
        List<BoardDto> boards = boardService.getAllBoards();
        boards.sort((b1, b2) -> b2.getId().compareTo(b1.getId()));
        return boards;
    }

    @GetMapping("/detail")
    public BoardDto boardDetail(@RequestParam("id") Long id){
        return boardService.findBoardById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertBoard(@RequestBody BoardDto boardDto) {
        boardService.insertBoard(boardDto);
        return ResponseEntity.ok("글 등록 성공");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBoard(@RequestBody BoardDto boardDto) {
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBoard(@RequestBody BoardDto boardDto) {
        return null;
    }

    @DeleteMapping("/multi/delete")
    public ResponseEntity<?> deleteBoards(@RequestBody BoardDto boardDto) {
        return null;
    }
}
