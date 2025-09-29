package com.example.myboard.repository;

import com.example.myboard.entity.BoardImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardImgRepository extends JpaRepository<BoardImg,Long> {
    List<BoardImg> findByBoardId(Long id);
}
