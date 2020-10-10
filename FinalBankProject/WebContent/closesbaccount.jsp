<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: gray;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #fffff;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color:white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #00000}

.dropdown:hover .dropdown-content {
    display: block;
}
body {font-family: Times New Roman, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 60%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color: light blue;
    align:center;
    color: black;
    padding: 12px 20px;
    margin: 8px 0;
    border-color:lightblack;
    cursor: pointer;
    width: 40%;
}

.container{
  color:white;
  font-size:120%;
}
</style>
</head>

<body style="background:url(https://www.businessnewsdaily.com/images/i/000/007/769/original/backgroundSOMMAI.jpg?1420665236);background-size:cover;">
<center>
<h1 style="color:white;"> <i>Welcome to Mphasis Bank</i></h1></center>
<ul>
  <li><a href="employeepage.jsp">Home</a></li>
 
  <li class="dropdown">
    <a href="#" class="dropbtn">Open Account</a>
    <div class="dropdown-content">
      <a href='opensbaccount.jsp'>Open Savings Account</a>
      <a href='openfdaccount.jsp'>Open Fixed Account</a>
    </div>
  </li>
   <li class="dropdown">
    <a href="#" class="dropbtn">Close Account</a>
    <div class="dropdown-content">
      <a href='closesbaccount.jsp'>Close Savings Account</a>
      <a href='closefdaccount.jsp'>Close Fixed Account</a>
    </div>
  </li>
   <li><a href='openministatement.jsp'>Statement</a></li>
    <li><a href='employeelogout.jsp'>Logout</a></li>
</ul><div style="margin-left:25%">
<form action="EmployeeController" method="post">
<div class="container"> 
<br/>
<br/>


<b>Account Number :</b> <input type ="text" name="account_id" id ="accountnumber" >
<br/>
<br/>
<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type ="submit" name ="action" value="closesbaccount"><b>Close Account</b></button>
</div>
</form>
</div>
</body>
</html>