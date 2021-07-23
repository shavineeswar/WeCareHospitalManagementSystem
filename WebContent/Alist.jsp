<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor</title>

 <style>
        * {
            box-sizing: border-box
        }
        
        body {
            font-family: "Lato", sans-serif;
        }
        /* Style the tab */
        
        .tab {
            float: left;
            border: 1px solid #ccc;
            background-color: #4586a0;
            width: 13%;
            height: 300px;
        }
        /* Style the buttons inside the tab */
        
        .tab button {
            display: block;
            background-color: inherit;
            color: black;
            padding: 22px 16px;
            width: 100%;
            border-color: lavender;
            outline: none;
            text-align: center;
            cursor: pointer;
            transition: 0.3s;
            font-size: 20px;
        }
        /* Change background color of buttons on hover */
        
        .tab button:hover {
            background-color: #ddd;
        }
        /* Create an active/current "tab button" class */
        
        .tab button.active {
            background-color: #ccc;
        }
        /* Style the tab content */
        
        .tabcontent {
            float: left;
            padding: 0px 12px;
            border: 1px solid #ccc;
            width: 87%;
            border-left: none;
            height: 600px;
        }
        
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #4586a0;
        }
        
        li {
            float: left;
        }
        
        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        
        li a:hover:not(.hname) {
            background-color: #ddd;
        }
        
        .active {
            background-color: #519fbe;
        }
        
        .tname {
            margin-bottom: 10px;
            text-decoration: none;
        }
           .tab button a{
        	color:white;
        }
        
        a{
        text-decoration:none;
        }
    </style>

</head>
<body>
  <ul>

        <li><a class="hname">ADMIN PANEL</a></li>
        <li style="float:right"><a class="active" href="Hhome.jsp">LOG OUT</a></li>
    </ul>


    <div class="tab">
        <button class="tablinks"><a href="<%=request.getContextPath()%>/alist">Admin</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/list">Doctor</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listnurse">Nurse</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listph">Pharmacist</button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listacc">Accountant</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listrec">Receptionist</a></button>
        <button class="tablinks"><a href="<%=request.getContextPath()%>/listlab">Laboratorist</a></button>
    </div>

 <div id="Doctor" class="tabcontent">
        <br>
        <button id="addD"><a href="<%=request.getContextPath()%>/new"> Register New Doctor </a></button>
        <h3 class="tname">Doctor Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>
                <th> Phone no </th>
                <th> specialization </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="doctor" items="${listDoctor}">
            <tr>
                <td><c:out value="${doctor.did}" /></td>
                <td><c:out value="${doctor.fullname}" /></td>
                <td><c:out value="${doctor.username}" /></td>
                <td><c:out value="${doctor.password}" /></td>
                <td><c:out value="${doctor.email}" /></td>
                <td><c:out value="${doctor.phone}" /></td>
                <td><c:out value="${doctor.specialization}" /></td>
                <td><button type='submit'><a href='edit?did=<c:out value='${doctor.did}' />'>EDIT</a></button></td>
                <td><button type='submit'><a href='delete?did=<c:out value='${doctor.did}' />'>DELETE</a></button></td>
            </tr>
            </c:forEach>
            <!-- } -->
        </table>
    </div>
</body>
</html>