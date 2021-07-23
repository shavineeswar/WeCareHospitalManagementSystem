<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Admin panel </title>
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
    </style>
</head>
<body>
   <ul>

        <li><a class="hname">ADMIN PANEL</a></li>
        <li style="float:right"><a class="active" href="#about">LOG OUT</a></li>
    </ul>


    <div class="tab">
        <button class="tablinks" onclick="openCity(event, 'Admin')" id="defaultOpen">Admin</button>
        <button class="tablinks" onclick="openCity(event, 'Doctor')">Doctor</button>
        <button class="tablinks" onclick="openCity(event, 'Nurse')">Nurse</button>
        <button class="tablinks" onclick="openCity(event, 'pharmacist')">Pharmacist</button>
        <button class="tablinks" onclick="openCity(event, 'Accountant')">Accountant</button>
        <button class="tablinks" onclick="openCity(event, 'Receptionist')">Receptionist</button>
        <button class="tablinks" onclick="openCity(event, 'Laboratorist')">Laboratorist</button>
    </div>

    <div id="Admin" class="tabcontent">
        <br>
        <button id="addA"><a href="add.html"> Register New Admin </a></button>
        <h3 class="tname">Admin Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> Admin Id </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><button type='submit'><a href='#'>EDIT</a></button></td>
                <td><button type='submit'><a href='#'>DELETE</a></button></td>
            </tr>
        </table>
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
            <c:forEach var="doctor" items="${listDoctor}">
            <tr>
                <td><c:out value="${doctor.Did}" /></td>
                <td><c:out value="${doctor.Fullname}" /></td>
                <td><c:out value="${doctor.Username}" /></td>
                <td><c:out value="${doctor.Password}" /></td>
                <td><c:out value="${doctor.Email}" /></td>
                <td><c:out value="${doctor.Phone}" /></td>
                <td><c:out value="${doctor.Specialization}" /></td>
                <td><button type='submit'><a href='edit?id=<c:out value='${doctor.Did}' />'>EDIT</a></button></td>
                <td><button type='submit'><a href='delete?id=<c:out value='${doctor.Did}' />'>DELETE</a></button></td>
            </tr>
            </c:forEach>
        </table>
    </div>

    <div id="Nurse" class="tabcontent">
        <br>
        <button id="addv"><a href="addvehi.php"> Register New Nurse </a></button>
        <h3 class="tname">Nurse Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>

                <th> Phone no </th>
                <th> Department </th>
                <th> position </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <tr>

                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><button type='submit'><a href='#'>EDIT</a></button></td>
                <td><button type='submit'><a href='#'>DELETE</a></button></td>
            </tr>
        </table>
    </div>
    <div id="pharmacist" class="tabcontent">
        <br>
        <button id="addv"><a href="addvehi.php"> Register New pharmacist</a></button>
        <h3 class="tname">pharmacist Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>

                <th> Phone no </th>
                <th> position </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <tr>

                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><button type='submit'><a href='#'>EDIT</a></button></td>
                <td><button type='submit'><a href='#'>DELETE</a></button></td>
            </tr>
        </table>
    </div>
    <div id="Accountant" class="tabcontent">
        <br>
        <button id="addv"><a href="addvehi.php"> Register New Accountant</a></button>
        <h3 class="tname">Accountant Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>

                <th> Phone no </th>
                <th> position </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <tr>

                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><button type='submit'><a href='#'>EDIT</a></button></td>
                <td><button type='submit'><a href='#'>DELETE</a></button></td>
            </tr>
        </table>
    </div>
    <div id="Receptionist" class="tabcontent">
        <br>
        <button id="addv"><a href="addvehi.php"> Register New Receptionist</a></button>
        <h3 class="tname">Receptionist Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>

                <th> Phone no </th>
                <th> position </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <tr>

                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><button type='submit'><a href='#'>EDIT</a></button></td>
                <td><button type='submit'><a href='#'>DELETE</a></button></td>
            </tr>
        </table>
    </div>
    <div id="Laboratorist" class="tabcontent">
        <br>
        <button id="addv"><a href="addvehi.php"> Register New Laboratorist</a></button>
        <h3 class="tname">Laboratorist Details</h3>
        <table border="1" width="100%">
            <tr>
                <th> ID </th>
                <th> Full Name </th>
                <th> Username </th>
                <th> Password </th>
                <th> Email </th>

                <th> Phone no </th>
                <th> position </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
            <tr>

                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><button class="sbtn" type='submit'><a href='#'>EDIT</a></button></td>
                <td><button class="sbtn" type='submit'><a href='#'>DELETE</a></button></td>
            </tr>
        </table>
    </div>
    <script>
        function openCity(evt, cityName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(cityName).style.display = "block";
            evt.currentTarget.className += " active";
        }

        // Get the element with id="defaultOpen" and click on it
        document.getElementById("defaultOpen").click();
    </script>


</body>
</html>