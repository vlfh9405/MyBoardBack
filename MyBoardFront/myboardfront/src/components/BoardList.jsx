import React from "react";
import "../css/BoardList.css"; 

const BoardList = ({ BoardList }) => {
  return (
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
        {BoardList.map((item) => (
            console.log(item),
          <tr key={item.id}>
            <td>{item.id}</td>
            <td>{item.title}</td>
            <td>{item.name}</td>
            <td>{item.regDate.slice(0,10)}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default BoardList;
