<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<link href="css/log.css" rel="stylesheet"/>
</head>
<body>
<div class="box">
        <h2><align="center">Login</h2><br>
        <form action="<%=request.getContextPath()%>/acclog" method="post" >
            <div class="inputbox">
                <input type="text"  name="Username" required><br>
                    <label>Username</label>  
            </div>
            <div class="inputbox">
                <input type="text" name="Password" required>
                <label>Password</label>    
            </div>
            <input type="submit" name=""  value="submit">


        </form>
    </div>
</body>
</html>