<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
div.scrollmenu {
    background-color: #333;
    overflow: auto;
    white-space: nowrap;
}

div.scrollmenu a {
    display: inline-block;0
    color: white;
    text-align: center;
    padding: 14px;
    text-decoration: none;
}

div.scrollmenu a:hover {
    background-color: #777;
}
body {font-family: Arial, Helvetica, sans-serif;}

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
    color: black;
    padding: 12px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 40%;
}
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
    color: blue;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
.container{
    color:white;
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
    background-color:light black;
    align:center;
    color: black;
    padding: 12px 20px;
    margin: 8px 0;
    border-color:lightblack;
    cursor: pointer;
    width: 60%;
}



</style>
</head>

<body>
<!-- navigation bar -->
<center>
<h1 style="color:black;"><i> Welcome to Mphasis Bank</i></h1></center>
<ul>
  <li><a href="customerpage.jsp">Home</a></li>
 <li><a href="customerdeposit.jsp">Deposit</a></li>
 <li><a href="customerwithdraw.jsp">Withdraw</a></li>
  <li><a href="customertransfer.jsp">Funds Transfer</a></li>
  <li><a href="customerchangepassword.jsp">Change Password</a></li>
   <li><a href="customerministatement.jsp">Mini Statement</a></li>
   <li><a href="customerforeclosefd.jsp">Fore Close</a></li>
   <li><a href="customerdetails.jsp">View Details</a></li>
 <li><a href="viewbalance.jsp">View Balance</a></li>
 <li><a href="viewfd.jsp">View FD</a></li>
    <li><a href="customerlogout.jsp">Logout</a></li>
</ul>
<!-- Page Content -->
<div style="margin-left:25%">
 <form action="Bank" method="post">
<div class="w3-container w3-teal">
<h1></h1>
<h1></h1>
<br>
<br>
<br>
</div>
<font face="verdana" color="black">
Account No : <input type ="text" value =<%=session.getAttribute("customer")%> name="senderaccount"  readonly >
<br/>
<br/>
Amount :&emsp;&emsp;<input type ="text" name="amount" id ="amount">
<br/>
<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<button type ="submit" name ="action" value="Deposit"> <b>DEPOSIT</b>
</button>
</font>
</form>
</div>
</body>
</html>