<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>
        
        body{
	margin: 0;
	padding: 0;
	background: #fff;

	color: #000;
	font-family: Arial;
	font-size: 15px;
}
h1{
        font-family: courier;     
            }
.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url("mphbackgrnd.jpg");
	background-size: cover;
	-webkit-filter: blur(1px);
	z-index: 0;
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(12% - 35px);
	left: calc(55% - 255px);
	z-index: 2;
}

.header div{
	float: left;
	color: #ffffff;
	font-family: Garamond;
	font-size: 65px;
	font-weight: 200;
}

.header div span{
	color: #ffffff !important;
}

.login{
    transition: box-shadow .10s;
	position: absolute;
	top: calc(40% - 75px);
	left: calc(20% - 50px);
	height: 300px;
	width: 350px;
	padding: 10px;
	z-index: 2;
  
     border-radius: 25px;
}
          
  
.login:hover {
  box-shadow: 10px 10px 100px rgba(0,0,0,.9); 
}
            
.login input[type=text]{
	width: 250px;
	height: 40px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
    margin  :4px
}

.login input[type=password]{
	width: 250px;
	height: 40px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	 margin  :4px
}

.login input[type=submit]{
	width: 250px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	 margin  :4px
}

.login input[type=button]:hover{
	opacity: 0.8;
}

.login input[type=button]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=button]:focus{
	outline: none;
}

            
            
.login1{
    transition: box-shadow .10s;
	position: absolute;
	top: calc(40% - 75px);
	left: calc(60% - 50px);
	height: 300px;
	width: 350px;
	padding: 10px;
	z-index: 2;
   
     border-radius: 25px;
}
          
  

            
.login1 input[type=text]{
	width: 250px;
	height: 40px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
    margin  :4px
}

.login1 input[type=password]{
	width: 250px;
	height: 40px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	 margin  :4px
}

.login1 input[type=submit]{
	width: 250px;
	height: 35px;
	background: LightGray;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #000;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	 margin  :4px
}

.login1 input[type=button]:hover{
	opacity: 0.8;
}

.login1 input[type=button]:active{
	opacity: 0.6;
}

.login1 input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login1 input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login1 input[type=button]:focus{
	outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}
        
        </style>
        
</head>
<body>
 <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><img src="mphasisicon.png" alt="icon" width=50px height=60px><b>Bank</b></div>
		</div>
		<br>
		
		
		<div class="login1"><div style="float:right;width:20%;">
		<form action="Bank" method="post">
                <center><h1> Customer Login</h1></center>
                <br>
                <br>
                
				<center><input type="text" placeholder="Customer Id" name="customer_id" pattern= [M]{1}[L]{1}[A]{1}[0-9]{5} title = "  Customer ID must be MLA & 5 digits
    " required><br><br>
				<input type="password" placeholder="Password" name="password"><br><br>
				<input type="submit" value="CusLogin" name="action">
				
				</center>
               </form>
               </div>
		</div>
      
    
</body>
</html>