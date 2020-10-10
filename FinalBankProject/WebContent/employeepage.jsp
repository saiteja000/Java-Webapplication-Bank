<!DOCTYPE html>
<html>
<head>
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
    color: green;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

</style>
</head>
<body style="background:url(https://www.businessnewsdaily.com/images/i/000/007/769/original/backgroundSOMMAI.jpg?1420665236);background-size:cover;">
<center>
<h1 style="color:white;"><i> Welcome to Mphasis Bank</i><h1></center>
<ul>
  <li><a href="employeepage.jsp">Home</a></li>
 
  <li class="dropdown">
    <a href="#" class="dropbtn">Open Account</a>
    <div class="dropdown-content">
      <a href="opensbaccount.jsp">Open Savings Account</a>
      <a href="openfdaccount.jsp">Open Fixed Account</a>
    </div>
  </li>
   <li class="dropdown">
    <a href="#" class="dropbtn">Close Account</a>
    <div class="dropdown-content">
      <a href="closesbaccount.jsp">Close Savings Account</a>
      <a href="closefdaccount.jsp">Close Fixed Account</a>
    </div>
  </li>
   <li><a href="openministatement.jsp">Statement</a></li>
    <li><a href="employeelogout.jsp">Logout</a></li>
</ul>
</body>
</html>