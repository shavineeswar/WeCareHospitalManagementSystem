<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<link href="css/list.css" rel="stylesheet"/>


</head>
<body>
 <ul>

        <li><a class="hname">ADMIN PANEL</a></li>
        <li style="float:right"><a class="active" href="Hhome.jsp">LOG OUT</a></li>
    </ul>


    <div class="tab">
        <button class="tablinks" ><a href="<%=request.getContextPath()%>/alist">Admin</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/list">Doctor</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listnurse">Nurse</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listph">Pharmacist</button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listacc">Accountant</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listrec">Receptionist</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listlab">Laboratorist</a></button>
    </div>

 <div id="Doctor" class="tabcontent">
        <br>
        <button id="addD"><a href="<%=request.getContextPath()%>/anew"> Register New Admin </a></button>
        <h3 class="tname">Admin Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="admin" items="${listadmin}">
            <tr>
                <td><c:out value="${admin.aid}" /></td>
                <td><c:out value="${admin.fullName}" /></td>
                <td><c:out value="${admin.username}" /></td>
                <td><c:out value="${admin.password}" /></td>
                <td><c:out value="${admin.email}" /></td>
                <td><button type='submit'><a href="aedit?aid=<c:out value='${admin.aid}' />">EDIT</a></button></td>
                <td><button type='submit'><a href="adelete?aid=<c:out value='${admin.aid}' />">DELETE</a></button></td>
            </tr>
            </c:forEach>
            <!-- } -->
        </table>
    </div>
</body>
</html>