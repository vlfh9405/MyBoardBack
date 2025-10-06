import React, { useState } from "react";
import "../css/Searchbar.css";

const Searchbar = ({ onSearch }) => {
  const [type, setType] = useState("title"); // 기본값: 제목
  const [keyword, setKeyword] = useState("");

  const handleSearch = () => {
    if (onSearch) {
      onSearch(type, keyword); // 부모에게 선택된 type과 keyword 전달
    }
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      handleSearch();
    }
  };

  return (
    <div className="Searchbar">
      <select value={type} onChange={(e) => setType(e.target.value)}>
        <option value="title">제목</option>
        <option value="content">내용</option>
      </select>

      <input
        type="text"
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
        onKeyPress={handleKeyPress}
        placeholder="검색어를 입력하세요"
      />

      <button onClick={handleSearch}>검색</button>
    </div>
  );
};

export default Searchbar;