import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getBoard, deleteBoard } from "../api/BoardApi";
import "../css/BoardDetail.css";

const BoardDetail = () => {
  const { id } = useParams(); // URL의 /board/:id
  const [board, setBoard] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchBoard = async () => {
      try {
        const data = await getBoard(id);
        setBoard(data);
      } catch (error) {
        console.error("게시글 불러오기 오류:", error);
      }
    };
    fetchBoard();
  }, [id]);
  if (!board) return <div>로딩 중...</div>;
//  삭제 핸들러
  const handleDelete = async() => {
    if(window.confirm("정말 삭제 하시겠습니까?")){
        try{
            await deleteBoard(id);
            alert("삭제 완료");
            navigate("/board");
        }catch(error){
            alert("삭제 실패" + error);
        }
    }
  };

  return (
    <div className="BoardDetailPage">
    <h1>{board.id}번 글 상세 페이지</h1>
    <h2>제목 : {board.title}</h2>
    <div className="board-info">
        <h2>작성자 : {board.name}</h2>
        <h2>등록일 : {board.regDate?.slice(0,10)}</h2>
    </div>
    <div className="board-content">{board.content}</div>
    <div className="btnGroup">
        <button className="deleteBtn" onClick={handleDelete}>삭제</button>
        <button className="modifyBtn" onClick={() => navigate("/board/update", {state:board})}>수정</button>
        <button className="backBtn" onClick={() => navigate("/board")}>목록으로</button>
    </div>
    </div>
  );
};

export default BoardDetail;