import {BrowserRouter as Router, Routes, Route, Navigate} from "react-router-dom";
import './App.css'
import Navi from './layout/Navi'
import BoardListPage from "./page/BoardListPage";
import NoticePage from "./page/NoticePate";
import BoardInsertPage from "./page/BoardInsertPage";
function App() {
  return (
    <Router>
    <div className="App">
      <Navi/>
      <Routes>
        <Route path="/" element={<Navigate to="/board" replace />} />
        <Route path="/board" element ={<BoardListPage/>}/>
        <Route path="/notice" element ={<NoticePage/>}/>
        <Route path="/write" element = {<BoardInsertPage/>}/>
      </Routes>
    </div>
    </Router>
  )
}

export default App
