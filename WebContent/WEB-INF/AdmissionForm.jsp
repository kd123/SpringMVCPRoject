<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
  <h1>${hedderMessage}</h1>
  <h3>Student Admission Form</h3>
  <form:errors path="student1.*"/>
  <form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">
  <table>
  <tr>
   <td>Student Name : </td><td><input type="text" name="studentName"/></td>
   </tr>
   <tr>
    <td>College : </td><td><input type="text" name="college"/></td>
    </tr>
   <tr>
   <td>Student Mobile : </td><td><input type="text" name="mobile"/></td>
   </tr>
   <tr>
   <td>Student DOB :</td><td> <input type="text" name="studentDOB"/></td>
   </tr>
   <tr>
   <td>Student Skills :</td>
   <td> 
   <select name="skills" multiple>
     <option value="Java"> JAVA</option>
     <option value="Spring">Spring Framework</option>
     <option value="Python">Python</option>
     </select>                             
   </td>
   </tr>
   <tr>
   <td>Student Address:</td></tr>
   <tr>
     <td>Country:<input type="text" name="address.country"/></td>
     <td>City:<input type="text" name="address.city"/></td>
     <td>Street:<input type="text" name="address.street"/></td>
     <td>Pincode:<input type="text" name="address.pincode"/></td>
    </tr>
    <tr>
    <td><input type="submit" value="Submit"></td>
    </tr>
    </table>
  </form>
</body>
</html>