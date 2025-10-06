package com.example.myboard.test;

import com.example.myboard.controller.BoardController;
import com.example.myboard.dto.BoardDto;
import com.example.myboard.entity.Board;
import com.example.myboard.entity.Test;
import com.example.myboard.repository.BoardRepository;
import com.example.myboard.repository.TestRepository;
import com.example.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestCode {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private BoardController boardController;

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @org.junit.jupiter.api.Test
    public void findByTest(){
        // given
        Test test = new Test();
        test.setTest(1);

        // when
        Test saved = testRepository.save(test);

        // then
        assertThat(saved.getTest()).isGreaterThan(0); // ID가 생성되었는지 확인
    }

/*    @org.junit.jupiter.api.Test
    public void controllerTest(){
        List<BoardDto> list = boardController.boardList();
        list.forEach(System.out::println);
    }*/

 /*   @org.junit.jupiter.api.Test
    public void serviceTest(){
        List<BoardDto> list = boardService.getAllBoards();
        list.forEach(System.out::println);
    }*/

    @org.junit.jupiter.api.Test
    public void insertBoardTest() {
        BoardDto boardDto = new BoardDto();
        boardDto.setName("test");
        boardDto.setTitle("test제목");
        boardDto.setContent("test 내용");

        boardService.insertBoard(boardDto);
    }
}
