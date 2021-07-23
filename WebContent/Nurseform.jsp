<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nurse</title>
<link href="css/form.css" rel="stylesheet"/>
</head>
<body>
<br><br><br><br>
    <div class="wrap">
        <div class="frm">
          
            	<c:if test="${nurse != null }">
			  <h1>Update Nurse</h1><br><br>
			</c:if>
			<c:if test="${nurse == null }">
			  <h1>Register Nurse</h1><br><br>
			</c:if>

			<c:if test="${nurse != null }">
			<form action="updatenurse" method="post" onsubmit="return Validate()" name="vform">
			</c:if>
			<c:if test="${nurse == null }">
			<form action="insertnurse" method="post" onsubmit="return Validate()" name="vform">
			</c:if>


                <div id="lid_div">
                <c:if test="${nurse != null}">
                    <label>ID</label> <br>
                    <input type="hidden" value="<c:out value='${nurse.nid}' />" name="Nid" class="textInput">
                   </c:if> 
                    <c:if test="${nurse == null}">
                    <label>ID</label> <br>
                    <input type="text" value="<c:out value='${nurse.nid}' />" name="Nid" class="textInput">
                   </c:if>
                </div>
                <div id="nm_div">
                    <label>Full Name</label> <br>
                    <input type="text" value="<c:out value='${nurse.fullName}' />" name="FullName" class="textInput">
                </div>
                <div id="ph_div">
                    <label>Phone Number</label> <br>
                    <input type="text" value="<c:out value='${nurse.phone}' />" name="Phone" class="textInput">
                </div>
                <div id="p_div">
                    <label>Department</label> <br>
                    <input type="text" value="<c:out value='${nurse.department}' />" name="Department" class="textInput">
                </div>
				<div id="p_div">
                    <label>Position</label> <br>
                    <input type="text" value="<c:out value='${nurse.position}' />" name="Position" class="textInput">
                </div>
                <div id="email_div">
                    <label>Email</label> <br>
                    <input type="text" value="<c:out value='${nurse.email}' />" name="Email" class="textInput">
                    <div id="email_error"></div><br>
                </div>
                <div id="username_div">
                    <label>Username</label> <br>
                    <input type="text" value="<c:out value='${nurse.username}' />" name="Username" class="textInput">
                    <div id="name_error"></div>
                </div>
                <div id="password_div">
                    <label>Password</label> <br>
                    <input type="password" value="<c:out value='${nurse.password}' />" name="Password" class="textInput">
                </div>

                <div id="pass_confirm_div">
                    <label>Confirm Password </label> <br>
                    <input type="password" name="password_confirm" class="textInput">
                    <div id="password_error"></div>
                </div>
        </div>
        <div>
                  <input type="submit" name="register" value="Register" class="btn">
                  </form>
        </div>
		

    </div>
</body>
<script>
    // SELECTING ALL TEXT ELEMENTS
    var username = document.forms['vform']['Username'];
    var email = document.forms['vform']['Email'];
    var password = document.forms['vform']['Password'];
    var password_confirm = document.forms['vform']['password_confirm'];
    // SELECTING ALL ERROR DISPLAY ELEMENTS
    var name_error = document.getElementById('name_error');
    var email_error = document.getElementById('email_error');
    var password_error = document.getElementById('password_error');
    // SETTING ALL EVENT LISTENERS
    username.addEventListener('blur', nameVerify, true);
    email.addEventListener('blur', emailVerify, true);
    password.addEventListener('blur', passwordVerify, true);
    // validation function
    function Validate() {
        // validate username
        if (username.value == "") {
            username.style.border = "1px solid red";
            document.getElementById('username_div').style.color = "red";
            name_error.textContent = "Username is required";
            username.focus();
            return false;
        }
        // validate username
        if (username.value.length < 3) {
            username.style.border = "1px solid red";
            document.getElementById('username_div').style.color = "red";
            name_error.textContent = "Username must be at least 3 characters";
            username.focus();
            return false;
        }
        // validate email
        if (email.value == "") {
            email.style.border = "1px solid red";
            document.getElementById('email_div').style.color = "red";
            email_error.textContent = "Email is required";
            email.focus();
            return false;
        }
        // validate password
        if (password.value == "") {
            password.style.border = "1px solid red";
            document.getElementById('password_div').style.color = "red";
            password_confirm.style.border = "1px solid red";
            password_error.textContent = "Password is required";
            password.focus();
            return false;
        }
        // check if the two passwords match
        if (password.value != password_confirm.value) {
            password.style.border = "1px solid red";
            document.getElementById('pass_confirm_div').style.color = "red";
            password_confirm.style.border = "1px solid red";
            password_error.innerHTML = "The two passwords do not match";
            return false;
        }
    }
    // event handler functions
    function nameVerify() {
        if (username.value != "") {
            username.style.border = "1px solid #5e6e66";
            document.getElementById('username_div').style.color = "#5e6e66";
            name_error.innerHTML = "";
            return true;
        }
    }

    function emailVerify() {
        if (email.value != "") {
            email.style.border = "1px solid #5e6e66";
            document.getElementById('email_div').style.color = "#5e6e66";
            email_error.innerHTML = "";
            return true;
        }
    }

    function passwordVerify() {
        if (password.value != "") {
            password.style.border = "1px solid #5e6e66";
            document.getElementById('pass_confirm_div').style.color = "#5e6e66";
            document.getElementById('password_div').style.color = "#5e6e66";
            password_error.innerHTML = "";
            return true;
        }
        if (password.value === password_confirm.value) {
            password.style.border = "1px solid #5e6e66";
            document.getElementById('pass_confirm_div').style.color = "#5e6e66";
            password_error.innerHTML = "";
            return true;
        }
    }
</script>


</html>