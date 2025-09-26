package com.example.myboard.service;

import com.example.myboard.dto.BoardDto;
import com.example.myboard.entity.Board;
import com.example.myboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AutoConfiguration
public class BoardService {
    private BoardRepository  boardRepository;

    public List<BoardDto> getAllBoards(){
        List<BoardDto> boardDtos = new ArrayList<>();
        boardDtos = boardRepository.findAll()
        return boardDtos;
    }

}
