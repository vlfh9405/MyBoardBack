import { Link } from "react-router-dom";
import "../css/WriteButton.css";

const WriteButton = () => {
    return (
        <div className="Write">
            <Link to={"/write"}>글쓰기</Link>  
        </div>
    );
}

export default WriteButton;