import { useState } from "react";
import { postUser } from "../api/userApi";

export default function UserCreate() {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [introduce, setIntroduce] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      name,
      age,
      introduce
    };

    try {
      const response = await postUser(data);
      alert("등록 성공!");
      console.log(response.data);
    } catch (err) {
      alert("등록 실패");
      console.error(err);
    }
  };

  return (
    <div>
      <h2>유저 등록</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>이름</label>
          <input value={name} onChange={(e) => setName(e.target.value)} />
        </div>

        <div>
          <label>나이</label>
          <input type="number" value={age} onChange={(e) => setAge(e.target.value)} />
        </div>

        <div>
          <label>소개</label>
          <textarea value={introduce} onChange={(e) => setIntroduce(e.target.value)} />
        </div>

        <button type="submit">등록하기</button>
      </form>
    </div>
  );
}