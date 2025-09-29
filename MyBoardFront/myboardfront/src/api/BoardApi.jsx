import axios from "axios";
const API_BASE_URL = "http://localhost:8081/api"; // 컨트롤러 기준

export const getBoardList = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}/board/list`);
    return response.data;
  } catch (error) {
    console.error("게시글 불러오기 실패:", error);
    return [];
  }
};

export const insertBoard = async (boardDto) => {
    try{
        const response = await axios.post(`${API_BASE_URL}/board/insert`,boardDto)
        return response.data;
    }catch(error){
        console.error("게시글 등록 실패 : ", error);
        throw error;
    }
};

export const getBoard = async(id) => {
    try{

    }catch(error){
        console.log("게시글 조회 실패 : ", error)
        throw error;
    }
}