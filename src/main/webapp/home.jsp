<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Details</title>
  <script>
    function showStudentName(name) {
      alert("Student Name: " + name);
    }
  </script>
</head>
<body>
<h1>Welcome to Home Page</h1>

<h2>Student List</h2>
<table border="1">
  <thead>
  <tr>
    <th>Department</th>
    <th>Student ID</th>
    <th>Marks</th>
    <th>Pass %</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="student" items="${students}">
    <tr>
      <td>${student.department}</td>
      <td>
        <a href="javascript:void(0);" onclick="showStudentName('${student.name}')">
            ${student.studentID}
        </a>
      </td>
      <td>${student.marks}</td>
      <td>${passPercentages[student.department]}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
