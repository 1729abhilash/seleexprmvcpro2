<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  
    <title>Document</title>
</head>
<body>
    <h1 align="center">Please register here</h1>
    <div align="center">
    <form:form action="registration-success" method="get" modelAttribute="userReg">
    <label >User:</label>
   <form:input path="name"></form:input>
<br>
   <label >UserName:</label>
   <form:input path="userName"></form:input>
<br>

   <label>password:</label>
   <form:input path="password"></form:input>
   <br>
   <label >country</label>
   <form:select path="countryName">
       <form:option value="Ind" label="INDIA"></form:option>
       <form:option value="USA" label="USA"></form:option>
       <form:option value="PAK" label="PAKINSTAN"></form:option>
      
   </form:select>
   <br>
   <label>hobbies:</label>
   Cricket:<form:checkbox path="hobbies" value="cricket"/>
   Readding:<form:checkbox path="hobbies" value="reading"/>
   Travel:<form:checkbox path="hobbies" value="travel"/>
   <br>
   <label>Gender:</label>
   Male:<form:radiobutton path="gender" value="male"/>
   female:<form:radiobutton path="gender" value="female"/>
   <br>
   <label>Age</label>
    <form:input path="age"/>
        <br>
   <div align="center">
    <h1>Communication</h1>
    <label>Email</label>
    <form:input path="communicationDto.email"></form:input>
    <br>
    <label>Phone</label>
    <form:input path="communicationDto.phone"></form:input>
  </div>
  <br>
   <input type="submit">
  
</form:form>
</div>
    
</body>
</html>