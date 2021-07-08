<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
*, body {
    font-family: 'Poppins', sans-serif;
    font-weight: 400;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    -moz-osx-font-smoothing: grayscale;
}

html, body {
    height: 100%;
    background-color: #152733;
}
h2{
	color: #fff;
    text-align: center;
    font-size: 35px;
    font-weight: 600;
    margin-bottom: 15px;
}
h1{
	color: #fff;
    text-align: center;
    font-size: 50px;
    font-weight: 600;
    margin-top:20px;
}
h3{
	color: #fff;
    text-align: center;
    font-size: 30px;
    font-weight: 600;
    margin-bottom: 15px;
}


.sc-gauge  { width:200px; height:200px; margin:0px auto; }
.sc-background { position:relative; height:100px; margin-bottom:10px; background-color: red; border-radius:150px 150px 0 0; overflow:hidden; text-align:center; }
.sc-mask { position:absolute; top:20px; right:20px; left:20px; height:80px; background-color:black; border-radius:150px 150px 0 0 }
.sc-percentage { position:absolute; top:100px; left:-200%; width:400%; height:400%; margin-left:100px; background-color:green; }
.sc-percentage { transform:rotate(0deg); transform-origin:top center; }
.sc-percentage1 { position:absolute; top:100px; left:-200%; width:400%; height:400%; margin-left:100px; background-color:green; }
.sc-percentage1 { transform:rotate(0deg); transform-origin:top center; }

.sc-percentage1 { transform:rotate(180deg); transform-origin:top center; }
.sc-min { float:left; }
.sc-max { float:right; }
.sc-value { position:absolute; top:50%; left:0; width:100%;  font-size:30px; font-weight:700; color:white }
</style>
</head>
<body onload="check(this)">
<nav class="navbar navbar-light" style="background-color:#a5b4cc;">
  <div class="container-fluid">
    <a class="navbar-brand">AMS</a>
    
  </div>
</nav>
<div class="container">
<h1>PROJECT EXECUTION</h1>
<p id="status">${Status}</p>
<div id="0" style="display:none;">
<div class="sc-gauge">
    <div class="sc-background">
      <div class="sc-percentage"></div>
      <div class="sc-mask"></div>
      <span class="sc-value">Status</span>
    </div>
</div>
        </div>
<div id="1" style="display:none;">
<div class="sc-gauge">
    <div class="sc-background">
      <div class="sc-percentage1"></div>
      <div class="sc-mask"></div>
      <span class="sc-value">Status</span>
    </div>
</div>
</div>
<h2><u>Remedial Action Duration</u></h2>
<h3>${Duration}</h3>
</div>
<script>
function check(nameSelect){
	var res=document.getElementById("status").outerHTML.substring(15);
	if(res==="Red</p>"){
		document.getElementById("0").style.display = "block";
	}
	else{
		document.getElementById("1").style.display = "block";
	}
}
</script>
</body>
</html>