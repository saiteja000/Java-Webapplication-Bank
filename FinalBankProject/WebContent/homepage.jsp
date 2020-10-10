<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color:white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #000;
}
.mph {
    width: 200px;
    height: 50px;
    font-weight: bold;
    position: relative;
    font-size: 150%;
    color:blue;
    animation: mymove 10s infinite;
}
#div1 {animation-timing-function: banking on the go;}
@keyframes mymove {
    from {left: 0px;}
    to {left: 1150px;}
}
</style>
</head>
<body style=background:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJtRMbDAni6oASTDAVSPL3ZSTVur87PkKao7UYET9dKALNm1t3);background-size:cover;">
<div style = "float:left; width : 5%;">
<img src='mphasisicon.png' alt="logo" height="100" width="100"></div>
<h1 style="color:blue;font-size:300%;float:left;"><b><i> Banking On Fingertips</i></b></h1>
<div style="float:left;width:100%;">
<ul>
<li><a href='loginpage.jsp'><b>Login</b></a></li>
<li><a href='about.jsp'><b>About</b></a></li>
<li><a href='contactus.jsp'><b>Contact Us</b></a></li>
</ul>
</div>
<br/>
<div class="mph" id="div1">Bank at your fingertips!</div>
<div style="float:left;width:100%;">
<img src='bankhome.jpg' alt="image" height="480" width="1350">
</div>

</body>
</html>