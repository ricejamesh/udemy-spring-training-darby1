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

             <form:options items="${student.countryOptions}" />

         </form:select>

        <br><br>

        Favorite Language:

        Java <form:radiobutton path="favoriteLanguage" value="Java" />
        C# <form:radiobutton path="favoriteLanguage" value="C#" />
        PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
        Javascript <form:radiobutton path="favoriteLanguage" value="Javascript" />

        <br><br>

        Favorite Name:

        <form:radiobuttons path="favoriteName" items="${student.favoriteNameOptions}" />

        <br><br>

        Operating Systems:

        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Windows <form:checkbox path="operatingSystems" value="Windows" />
        Centos <form:checkbox path="operatingSystems" value="centos" />

        <br><br>

        <input type="submit" value="Submit" />

     </form:form>

</body>
</html>