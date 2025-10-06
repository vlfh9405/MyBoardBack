import React, {useState, useEffect} from "react";
import { useNavigate, useLocation, useParams } from "react-router-dom";
import { getBoard,updateBoard } from "../api/BoardApi";
import "../css/BoardUpdate.css";


const BoardUpdatePage = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const params = useParams();
    const stateBoard = location.state;
    const [board, setBoard] = useState(stateBoard || null);
    const [title, setTitle] = useState(stateBoard?.title || "");
    const [content, setContent] = useState(stateBoard?.content || "");
    const [name, setName] = useState(stateBoard?.name || "");

    useEffect(() => {
    if (!board && params.id) {
        const fetchBoard = async () => {
        try {
            const data = await getBoard(params.id);
            setBoard(data);
            setTitle(data.title);
            setContent(data.content);
            setName(data.name);
        } catch (error) {
            console.error("게시글 불러오기 실패:", error);
        }
    };
    fetchBoard();
    }
    }, [board, params.id]);
    
     const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await updateBoard({ id: board.id, title, content, name });
      alert("글 수정 완료!");
      navigate(`/board/${board.id}`);
    } catch (error) {
      console.error("글 수정 실패:", error);
    }
  };

  if (!board) return <div>로딩 중...</div>;

  return (
    <div className="BoardUpdatePage">
      <h2>게시글 수정</h2>
      <form onSubmit={handleSubmit}>
        <div className="formGroup">
          <label>제목</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div className="formGroup">
          <label>작성자</label>
          <input
            type="text"
            value={name}
            readOnly
          />
        </div>
        <div className="formGroup">
          <label>내용</label>
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            required
          ></textarea>
        </div>
        <div className="btnGroup">
          <button type="submit" className="submitBtn">
            수정
          </button>
          <button
            type="button"
            className="cancelBtn"
            onClick={() => navigate(-1)}
          >
            취소
          </button>
        </div>
      </form>
    </div>
  );
};
export default BoardUpdatePage;