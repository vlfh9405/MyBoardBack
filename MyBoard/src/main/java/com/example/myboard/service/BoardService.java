package com.example.myboard.service;

import com.example.myboard.dto.BoardDto;
import com.example.myboard.dto.BoardPageResponse;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository  boardRepository;
    private final BoardImgRepository boardImgRepository;

    // 게시글 전체 리스트
    public BoardPageResponse getBoardsByPage(int page, int size, String type, String keyword) {
        int startRow = (page - 1) * size + 1;
        int endRow = page * size;

        List<Board> boards;
        int totalCount;

        if(keyword != null && !keyword.isEmpty()) {
            if("title".equals(type)) {
                boards = boardRepository.findBoardsByTitle(startRow, endRow, keyword);
                totalCount = boardRepository.countBoardsByTitle(keyword);
            } else if("content".equals(type)) {
                boards = boardRepository.findBoardsByContent(startRow, endRow, keyword);
                totalCount = boardRepository.countBoardsByContent(keyword);
            } else {
                boards = boardRepository.findBoardsByPage(startRow, endRow);
                totalCount = boardRepository.countBoards();
            }
        } else {
            boards = boardRepository.findBoardsByPage(startRow, endRow);
            totalCount = boardRepository.countBoards();
        }

        List<BoardDto> boardDtos = boards.stream()
                .map(board -> BoardDto.builder()
                        .id(board.getId())
                        .name(board.getName())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .regDate(board.getRegDate())
                        .build())
                .collect(Collectors.toList());

        return new BoardPageResponse(boardDtos, totalCount);
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

    // 글 삭제
    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }

    //글 수정
    public void updateBoard(BoardDto boardDto) {
        Optional<Board> boardOptional = boardRepository.findById(boardDto.getId());
        if(boardOptional.isPresent()){
            Board board = boardOptional.get();
            board.setTitle(boardDto.getTitle());
            board.setContent(boardDto.getContent());
            boardRepository.save(board);
        }else{
            throw new RuntimeException("해당글이 존재하지 않습니다.");
        }
    }

}
