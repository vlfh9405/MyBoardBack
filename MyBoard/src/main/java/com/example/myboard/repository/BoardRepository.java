package com.example.myboard.repository;

import com.example.myboard.entity.Board;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    // 제목 검색
    @Query(value = "SELECT * FROM (SELECT b.*, ROWNUM rn FROM BOARD b ORDER BY b.id DESC) WHERE rn BETWEEN :startRow AND :endRow", nativeQuery = true)
    List<Board> findBoardsByPage(@Param("startRow") int startRow, @Param("endRow") int endRow);

    // 제목으로 검색한 게시글 페이지
    @Query(value = "SELECT * FROM (SELECT b.*, ROWNUM rn FROM BOARD b WHERE b.title LIKE %:keyword% ORDER BY b.id DESC) WHERE rn BETWEEN :startRow AND :endRow", nativeQuery = true)
    List<Board> findBoardsByTitle(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("keyword") String keyword);

    // 내용으로 검색한 게시글 페이지
    @Query(value = "SELECT * FROM (SELECT b.*, ROWNUM rn FROM BOARD b WHERE b.content LIKE %:keyword% ORDER BY b.id DESC) WHERE rn BETWEEN :startRow AND :endRow", nativeQuery = true)
    List<Board> findBoardsByContent(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("keyword") String keyword);

    // 전체 게시글 수
    @Query(value = "SELECT COUNT(*) FROM BOARD", nativeQuery = true)
    int countBoards();

    // 제목으로 검색한 게시글 수
    @Query(value = "SELECT COUNT(*) FROM BOARD WHERE title LIKE %:keyword%", nativeQuery = true)
    int countBoardsByTitle(@Param("keyword") String keyword);

    // 내용으로 검색한 게시글 수
    @Query(value = "SELECT COUNT(*) FROM BOARD WHERE content LIKE %:keyword%", nativeQuery = true)
    int countBoardsByContent(@Param("keyword") String keyword);

    void deleteById(Long id);
}
