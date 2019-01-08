<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Student Registration Form</title>
</head>
<body>
     <form:form action="processForm" modelAttribute="student">

         First name: <form:input path="firstName" />

         <br><br>

         Last name:
         <form:input path="lastName" />

         <br><br>

         Country:

         <form:select path="country">
             <form:option value="Brazil" label="Brazil"></form:option>
             <form:option value="France" label="France"></form:option>
             <form:option value="Germany" label="Germany"></form:option>
             <form:option value="India" label="India"></form:option>
         </form:select>

         <br><br>

         <input type="submit" value="Submit" />

     </form:form>

</body>
</html>