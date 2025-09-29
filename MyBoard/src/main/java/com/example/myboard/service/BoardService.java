package com.example.myboard.service;

import com.example.myboard.dto.BoardDto;
import com.example.myboard.entity.Board;
import com.example.myboard.repository.BoardImgRepository;
import com.example.myboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository  boardRepository;
    private final BoardImgRepository boardImgRepository;

    // 게시글 전체 리스트
    public List<BoardDto> getAllBoards(){
        return boardRepository.findAll()
                .stream()
                .map(board -> BoardDto.builder()
                        .id(board.getId())
                        .name(board.getName())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .regDate(board.getRegDate())
                        .boardImgs(boardImgRepository.findByBoardId(board.getId()))
                        .build())
                .collect(Collectors.toList());
    }
    // 게시글 상세 조회
    public BoardDto findBoardById(Long id){
        return boardRepository.findById(id)
                .map(board -> BoardDto.builder()
                        .id(board.getId())
                        .name(board.getName())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .regDate(board.getRegDate())
                        .boardImgs(boardImgRepository.findByBoardId(board.getId()))
                        .build()
                ).orElse(null);
    }

    // 글 등록
    public void insertBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setName(boardDto.getName());
        boardRepository.save(board);
    }

}
