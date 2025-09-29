package com.example.myboard.dto;

import com.example.myboard.entity.BoardImg;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {
    private Long id;
    private String name;
    private String title;
    private String content;
    private Date regDate;
    private List<BoardImg> boardImgs;

}
