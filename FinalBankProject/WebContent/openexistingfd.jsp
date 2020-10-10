<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    color: white;
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
    font-size:70%;
    padding:10px;
}
body {font-family: Times New Roman, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password],input[type=date] {
    width: 60%;
    padding: 6px 6px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color:light black;
    align:center;
    color: black;
    padding: 6px 6px;
    margin: 8px 0;
    border-color:lightblack;
    cursor: pointer;
    width: 100%;
}
.mph{
  position:absolute;
  top:150px;
  left:calc(60% - 50px);
  height:300px;
  width:350px;
  padding:0px ;
  z-index:2;
  border-radius:25px;
  font-size:100%;
  color:white;
}
.mph input[type=text],input[type=password],input[type=date]{
width:250px;
height:40px;
border:1px solid;
font-size:20px;
}
</style>
</head>
<body style="background:url(https://www.businessnewsdaily.com/images/i/000/007/769/original/backgroundSOMMAI.jpg?1420665236);background-size:cover;">
<div class="mph"><div  style="float:right;width:20%;">
<h3>ExistingCustomer</h3>
<form action = "EmployeeController" method = "post">
<br/>
<br/>
<b>CustomerID:</b>&emsp;<input type ="text" name="customer_id" id ="customer_id" required>
<br/>
<b>Amount:</b>&emsp;&emsp;&emsp;<input type ="text" name="amount" id="amount">
<br/>
<b>StartDate: </b>&emsp;&emsp;<input type="date" name="startdate" id="startdate">
<br/>
<b>EndDate:</b>&emsp;&emsp;<input type="date" name="enddate" id ="enddate">
<br/>
<div align="center">
<button type ="submit" name ="action" value="openexistingfd"><b>ADD</b></button>
</div>
</form>
</div>
</div>
</body>
</html>