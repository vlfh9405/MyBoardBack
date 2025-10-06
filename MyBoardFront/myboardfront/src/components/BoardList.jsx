import React from "react";
import { useNavigate } from "react-router-dom";
import "../css/BoardList.css";

const BoardList = ({ boardList }) => {
  const navigate = useNavigate();

  const handleClickPage = (id) => {
    navigate(`/board/${id}`);
  };

  if (!boardList || boardList.length === 0) {
    return <p>게시글이 없습니다.</p>;
  }

  return (
    <div className="BoardList">
    <table className="BoardListTable">
      <thead>
        <tr>
          <th>ID</th>
          <th>제목</th>
          <th>작성자</th>
          <th>등록일</th>
        </tr>
      </thead>
      <tbody>
        {boardList.map((item) => (
          <tr key={item.id} onClick={() => handleClickPage(item.id)}>
            <td>{item.id}</td>
            <td>{item.title}</td>
            <td>{item.name}</td>
            <td>{item.regDate.slice(0, 10)}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
  );
};

export default BoardList;