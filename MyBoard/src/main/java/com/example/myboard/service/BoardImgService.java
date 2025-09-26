package com.example.myboard.service;

import com.example.myboard.repository.BoardImgRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@AutoConfiguration
public class BoardImgService {
    private BoardImgRepository boardImgRepository;

}
