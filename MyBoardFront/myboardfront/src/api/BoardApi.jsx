import axios from "axios";
const API_BASE_URL = "http://localhost:8081/api";

export const getBoardList = async (page = 1, size = 10, type = "", keyword = "") => {
  try {
    const response = await axios.get(`${API_BASE_URL}/board/list`, {
      params: { page, size, type, keyword },
    });
    return response.data; // Page 객체 전체 리턴
  } catch (error) {
    console.error("게시글 목록 불러오기 실패:", error);
    throw error;
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

export const getBoard = async (id) => {
  try {
    const response = await axios.get(`${API_BASE_URL}/board/detail`, {
      params: { id },
    });
    return response.data;
  } catch (error) {
    console.error("게시글 조회 실패 : ", error);
    throw error;
  }
};

export const deleteBoard = async(id) => {
  try{
    const response = await axios.delete(`${API_BASE_URL}/board/delete`,{
      params:{id},
    });
    return response.data;
  }catch(error){
    console.error("게시글 삭제 실패 : " , error);
    throw error;
  }
}

export const updateBoard = async(boardDto) => {
  try{
    const response = await axios.put(`${API_BASE_URL}/board/update`, boardDto)
    return response.data;
  }catch(error){
    console.error("게시글 수정 실패 : " , error);
    throw error;
  }
}