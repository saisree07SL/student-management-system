const API_URL = "http://localhost:8081/students";

// Load students on page load
window.onload = getStudents;

// GET ALL
function getStudents() {
  fetch(API_URL)
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById("studentList");
      list.innerHTML = "";

      data.forEach(student => {
        list.innerHTML += `
          <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td>
              <button onclick="editStudent(${student.id}, '${student.name}', '${student.email}', '${student.course}')">Edit</button>
              <button onclick="deleteStudent(${student.id})">Delete</button>
            </td>
          </tr>
        `;
      });
    });
}

// ADD
function addStudent() {
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const course = document.getElementById("course").value;

  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, email, course })
  })
  .then(() => {
    clearForm();
    getStudents();
  });
}

// DELETE
function deleteStudent(id) {
  fetch(`${API_URL}/${id}`, {
    method: "DELETE"
  })
  .then(() => getStudents());
}

// EDIT (fill form)
let updateId = null;

function editStudent(id, name, email, course) {
  document.getElementById("name").value = name;
  document.getElementById("email").value = email;
  document.getElementById("course").value = course;

  updateId = id;
}

// UPDATE
function updateStudent() {
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const course = document.getElementById("course").value;

  fetch(`${API_URL}/${updateId}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, email, course })
  })
  .then(() => {
    clearForm();
    getStudents();
    updateId = null;
  });
}

// CLEAR FORM
function clearForm() {
  document.getElementById("name").value = "";
  document.getElementById("email").value = "";
  document.getElementById("course").value = "";
}