// App.js
import React, { useState } from "react";
import StudentForm from "./StudentForm";
import StudentList from "./StudentList";

function App() {

  const [students, setStudents] = useState([]);

  // Add Student
  const addStudent = (name) => {
    if (name.trim() !== "") {
      setStudents([...students, name]);
    }
  };

  // Delete Student
  const deleteStudent = (index) => {
    const updatedList = students.filter((_, i) => i !== index);
    setStudents(updatedList);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "40px" }}>
      <h1>Student Record Management</h1>

      <StudentForm addStudent={addStudent} />

      <StudentList
        students={students}
        deleteStudent={deleteStudent}
      />
    </div>
  );
}

export default App;