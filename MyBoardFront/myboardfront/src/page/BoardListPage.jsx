import React,{useEffect, useState} from "react";
import { getBoardList } from "../api/BoardApi";
import "../css/BoardListPage.css"
import BoardList from "../components/BoardList"
import WriteButton from "../components/WriteButton";

const BoardListPage =()=> {
    const [boardData, setBoardData] = useState([]);
    useEffect(() => {
        getBoardList().then((data) => setBoardData(data))
    },[]);
    return(
        <div className="BoardListPage">
            <BoardList BoardList={boardData} />
            <WriteButton/>
        </div>
    )
}

export default BoardListPage;