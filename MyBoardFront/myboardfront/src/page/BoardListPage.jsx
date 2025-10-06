import React, { useEffect, useState } from "react";
import {getBoardList } from "../api/BoardApi";
import "../css/BoardListPage.css";
import BoardList from "../components/BoardList";
import WriteButton from "../components/WriteButton";
import Pagenation from "../components/Pagenation";
import Searchbar from "../components/Searchbar";

const BoardListPage = () => {
  const [boardData, setBoardData] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
   const [searchType, setSearchType] = useState(""); 
  const [keyword, setKeyword] = useState("");
  const postsPerPage = 5;

  const fetchBoards = (page, type = searchType, kw = keyword) => {
    getBoardList(page, postsPerPage, type, kw).then((res) => {
      setBoardData(res.boards);
      setTotalPages(Math.ceil(res.totalCount / postsPerPage));
    });
  };
  useEffect(() => {
    fetchBoards(currentPage);
  }, [currentPage]);

  const handleSearch = (type, kw) => {
    setSearchType(type);
    setKeyword(kw);
    setCurrentPage(1); // 검색하면 항상 1페이지부터 보여줌
    fetchBoards(1, type, kw);
  };

  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber); // currentPage 바뀌면 useEffect가 다시 fetchBoards 호출
  };

  return (
    <div className="BoardListPage">
      <Searchbar onSearch={handleSearch} />
      <BoardList boardList={boardData} />
      <Pagenation
        currentPage={currentPage}
        totalPages={totalPages}
        onPageChange={handlePageChange}
      />
      <WriteButton />
    </div>
  );
};

export default BoardListPage;