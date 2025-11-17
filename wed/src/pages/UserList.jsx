import { useEffect, useState } from "react";
import { getUsers, deleteUser } from "../api/userApi";

export default function UserList() {
  const [users, setUsers] = useState([]);

  const loadUsers = async () => {
    const res = await getUsers();
    setUsers(res.data.userList);  // Spring에서 response.setUserList()로 보냄
  };

  const handleDelete = async (id) => {
    await deleteUser(id);
    alert("삭제 완료");
    loadUsers(); // 삭제 후 갱신
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return (
    <div>
      <h2>유저 목록</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th><th>이름</th><th>나이</th><th>소개</th><th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {users.map((u) => (
            <tr key={u.id}>
              <td>{u.id}</td>
              <td>{u.name}</td>
              <td>{u.age}</td>
              <td>{u.introduce}</td>
              <td>
                <button onClick={() => handleDelete(u.id)}>삭제</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}