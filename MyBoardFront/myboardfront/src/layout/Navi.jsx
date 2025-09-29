import { Link, useLocation } from "react-router-dom";
import "../css/Navi.css";

const Navi = () => {
    const location = useLocation();
    const path = location.pathname;
    
    return(
       <div className="Navi">
      <div className={`a ${path === "/board" ? "action" : ""}`}>
        <Link to="/board">게시판</Link>
      </div>
      
      <div className={`a ${path === "/notice" ? "action" : ""}`}>
        <Link to="/notice">공지사항</Link>
      </div>
    </div>
    )
}

export default Navi;