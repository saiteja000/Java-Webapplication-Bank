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
.container{
    color:white;
    font-size:120%;
}
body {font-family: Times New Roman, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password],input[type=date] {
    width: 60%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    cursor:pointer;
}
button {
    background-color:light black;
    align:center;
    color: black;
    padding: 12px 20px;
    margin: 8px 0;
    border-color:lightblack;
    cursor: pointer;
    width: 40%;
}


</style>
</head>

<body style="background:url(https://www.businessnewsdaily.com/images/i/000/007/769/original/backgroundSOMMAI.jpg?1420665236);background-size:cover;">
<center>
<h1 style="color:white;"><i> Welcome to Mphasis Bank</i></h1></center>
<ul>
  <li><a href="managerpage.jsp">Home</a></li>
 
  <li class="dropdown">
    <a href="#" class="dropbtn">Open Account</a>
    <div class="dropdown-content">
      <a href="managereopensbaccount.jsp">Open Savings Account</a>
      <a href="manageropenfdaccount.jsp">Open Fixed Account</a>
    </div>
  </li>
   <li class="dropdown">
    <a href="#" class="dropbtn">Close Account</a>
    <div class="dropdown-content">
      <a href="managerclosesbaccount.jsp">Close Savings Account</a>
      <a href="managerclosefdaccount.jsp">Close Fixed Account</a>
    </div>
  </li>
   <li><a href="managerministatement.jsp">Statement</a></li>
   <li><a href="addstaff.jsp">Add Staff</a></li>
   <li><a href="removestaff.jsp">Remove Staff</a></li>
    <li><a href='employeelogout.jsp'>Logout</a></li>
</ul>
<div style="margin-left:25%">
<form action="ManagerController" method="post">
<div class="container"> 
<br/>
<br/>
<br/>
<font face="verdana" color="black">
<b>Employee Id : </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type ="text" readonly="readonly"  name="EmpId" id ="EmpId" >
<br/>
<br/>

<button type ="submit" name ="action" value="removestaff"><b>REMOVE EMPLOYEE</b></button>
</font>
<br/>
<br/>
</div>
</form>
</div>
</body>
</html>