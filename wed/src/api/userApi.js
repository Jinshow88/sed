import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api/user"
});

// 1. 유저 등록
export const postUser = (data) => API.post("/create", data);

// 2. 유저 전체 조회
export const getUsers = () => API.get("/get");

// 3. 유저 삭제
export const deleteUser = (id) => API.get(`/delete?id=${id}`);