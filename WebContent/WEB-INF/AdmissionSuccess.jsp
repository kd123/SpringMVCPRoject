<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<h2>${hedderMessage}</h2>
 <h1>Congratulation!! your Application is submitted</h1>
 <h2>${msg}</h2>
 <table>
  <tr>
      <td>Student Name:</td>
     <td>${student1.studentName}</td>
  </tr>
  <tr><td>College Name:</td>
     <td>${student1.college}</td>
     </tr>
     <tr>
      <td>Student Mobile:</td>
     <td>${student1.mobile}</td>
  </tr>
  <tr>
      <td>Student DOB:</td>
     <td>${student1.studentDOB}</td>
  </tr>
  <tr>
      <td>Student Skills:</td>
     <td>${student1.skills}</td>
  </tr>
  <tr>
      <td>Student Address:</td>
      <td>Country: ${student1.address.country}</td>
      <td>City: ${student1.address.city}</td>
      <td>Street: ${student1.address.street}</td>
      <td>Pincode: ${student1.address.pincode}</td>
      </tr>
 </table>
</body>
</html>