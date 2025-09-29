import "../css/BoardInsertPage.css";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { insertBoard } from "../api/BoardApi";

const BoardInsertPage = () => {
    const navigate = useNavigate();
    const handleClickCancel = () => {
        navigate(-1);
    }
    const [title, setTitle] = useState("");
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [content, setContent] = useState("");
    
    const handleReset = () => {
         setTitle("");
        setName("");
        setPassword("");
        setContent("");
    }

    const handleSubmit = async () => {
        try{
            await insertBoard({title, name, content, password});
            alert("글 등록 성공")
            navigate("/board");
        }catch(error){
            alert("글 등록 실패")
        }
    }

    return(
        <div className="BoardInsertPage">
            <h2>글쓰기</h2>

            <div className="title">
                <label>제목 :</label>
                <input type="text" 
                    value = {title}
                    onChange={(e) => setTitle(e.target.value)}
                />
            </div>

            <div className="name">
                <label>이름 :</label>
                <input type="text" 
                    value = {name}
                    onChange={(e) => setName(e.target.value)}
                />
            </div>

            <div className="name">
                <label>비밀번호 :</label>
                <input type="password" 
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </div>

            <div className="content">
                <label>내용 :</label>
                <textarea 
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                />
            </div>

            <div className="btnGroup">
                <button className="submitBtn" onClick={handleSubmit}>등록</button>
                <button className="cancelBtn" onClick={handleReset}>다시작성</button>
                <button className="cancelBtn" onClick={handleClickCancel}>취소</button>
            </div>
        </div>
    )
}

export default BoardInsertPage;