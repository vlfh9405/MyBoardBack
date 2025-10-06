package com.example.myboard.controller;

import com.example.myboard.dto.BoardDto;
import com.example.myboard.dto.BoardPageResponse;
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
    public BoardPageResponse getBoards(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String keyword)
            {
        return boardService.getBoardsByPage(page, size, type, keyword);
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
        boardService.updateBoard(boardDto);
        return ResponseEntity.ok("글 수정 성공");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBoard(@RequestParam("id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("글 삭제 성공");
    }
}
