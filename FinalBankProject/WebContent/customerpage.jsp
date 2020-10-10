<!DOCTYPE html>
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
    width: 40%;
}


</style>
</head>

<body style="background:url(customer.jpg);background-size:cover;">
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
</body>
</html>
