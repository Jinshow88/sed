// src/App.js
import axios from "axios";
import { useEffect, useState } from "react";

export default function App() {
  const [users, setUsers] = useState([]);

  // ▼ 입력값 상태
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [introduce, setIntroduce] = useState("");

  // ▼ 유저 목록 가져오기
  const loadUsers = async () => {
    try {
      const response = await axios.get("/api/user/get");
      const data = response.data.userList;
      setUsers(data || []);
    } catch (error) {
      console.error("목록 조회 실패:", error);
      alert("유저 목록 불러오기 실패");
    }
  };

  useEffect(() => {
    loadUsers();
  }, []);

  // ▼ 회원 등록하기
  const handleSubmit = async (e) => {
    e.preventDefault(); // 폼 기본 제출 막기(새로고침 방지)

    try {
      await axios.post("/api/user/create", {
        name: name,
        age: Number(age),         // 숫자로 변환
        introduce: introduce,
      });

      alert("회원 등록 성공!");

      // 입력창 비우기
      setName("");
      setAge("");
      setIntroduce("");

      // 목록 다시 불러오기
      loadUsers();
    } catch (error) {
      console.error("등록 실패:", error);
      alert("회원 등록 실패");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>회원 등록</h2>

      {/* 등록 폼 */}
      <form onSubmit={handleSubmit} style={{ marginBottom: "30px" }}>
        <div>
          <label>이름 : </label>
          <input
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div>
          <label>나이 : </label>
          <input
            type="number"
            value={age}
            onChange={(e) => setAge(e.target.value)}
            required
          />
        </div>

        <div style={{display:"flex", justifyContent:"center"}}>
          <label 
          style={{color:"blue"}}>
            소개 : 
          </label>
          <textarea
            value={introduce}
            onChange={(e) => setIntroduce(e.target.value)}
            rows={3}
            required
              style={{
    color: "blue",
    backgroundColor: "#f0f8ff",
    border: "1px solid #888"
  }}
          />
        </div>

        <button type="submit" style={{ marginTop: "10px" }}>
          등록하기
        </button>
      </form>

      <hr />

      <h2>회원 목록</h2>
      {users.length === 0 ? (
        <p>등록된 회원이 없습니다.</p>
      ) : (
        users.map((user) => (
          <div key={user.id} style={{ marginBottom: "10px" }}>
            <h3>
              {user.name} ({user.age})
            </h3>
            <p>{user.introduce}</p>
          </div>
        ))
      )}
    </div>
  );
}