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

.form-holder {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
      min-height: 100vh;
}

.form-holder .form-content {
    position: relative;
    text-align: center;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 60px;
}

.form-content .form-items {
    border: 3px solid #fff;
    padding: 40px;
    display: inline-block;
    width: 100%;
    min-width: 540px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    text-align: center;
    -webkit-transition: all 0.4s ease;
    transition: all 0.4s ease;
    margin-top:200px;
}

.form-content h2 {
    color: #fff;
    text-align: center;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 15px;
}
.form-body{
	margin-top:-80px;
}
h1{
	color: #fff;
    text-align: center;
    font-size: 50px;
    font-weight: 600;
    margin-top:20px;
    margin-bottom:-200px
}
.labels{
color: #fff;
    text-align: left;
    font-size: 17px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}
p {
    width: 100%;
    padding: 9px 20px;
    text-align: left;
    border: 0;
    outline: 0;
    border-radius: 6px;
    background-color: #fff;
    font-size: 20px;
    font-weight: 300;
    color: black;
    -webkit-transition: all 0.3s ease;
    transition: all 0.3s ease;
    margin-top: 16px;
    }
    
.labels{
color: #fff;
    text-align: left;
    font-size: 20px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}
.btn-primary{
    background-color: #6C757D;
    outline: none;
    border: 0px;
     box-shadow: none;
     margin-top:20px;
     margin-left:auto;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}

.form{
font-size:22px;
}
.form1{
font-size:20px;
}

input[type=radio] {
    width:5%;
    height: 1.4em;
	}
	sup{
	color:red;
	font-size:20px;
	}

</style>
</head>
<body >
<nav class="navbar navbar-light" style="background-color:#a5b4cc;">
  <div class="container-fluid">
    <a class="navbar-brand">AMS</a>
   
  </div>
</nav>
<div class="container">
<h1>AUDIT MANAGEMENT SYSTEM</h1>
<div class="form-body">
        <div class="row">
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
<h2>Project Name: ${newrequest.projectName}</h2>
<h2>Manager Name: ${newrequest.managerName}</h2>
<h2>Owner Name: ${newrequest.ownerName}</h2>
<form:form method="POST" action="/aud/submit" modelAttribute="AuditDetail" class="form">
<<form:label class="labels" path="AuditType">Audit Type</form:label> 
<form:select path="AuditType" class="form1" id="mySelect" onchange="check(this);" required="required">
<form:option value="" label="Select one"/>
<form:option value="SOX" label="SOX"/>
<form:option value="Internal" label="Internal"/>
</form:select>

 <div id="0" style="display:none;">
 <div>
  <p>Have all Change requests followed SDLC before PROD move? <sup>*</sup></p>
  <form:radiobutton class="inputs" path="Q1" value="yes" required="required"/> 
  <form:label class="labels" path="Q1">Yes</form:label>
 <form:radiobutton class="inputs" path="Q1" value="no" required="required"/>
 <form:label class="labels" path="Q1">No</form:label>
  </div>
   <div>
  <p>Have all Change requests been approved by the application owner?<sup>*</sup></p>
<form:radiobutton path="Q2" value="yes" required="required"/>
<form:label class="labels" path="Q2">Yes</form:label>
 <form:radiobutton path="Q2" value="no" required="required"/>
 <form:label class="labels" path="Q2">No</form:label>
  </div>
   <div>
  <p>For a major change, was there a database backup taken before and after PROD move?<sup>*</sup></p>
<form:radiobutton path="Q3" value="yes" required="required"/>
<form:label class="labels" path="Q3">Yes</form:label>
 <form:radiobutton path="Q3" value="no" required="required"/>
 <form:label class="labels" path="Q3">No</form:label>
  </div>
   <div>
  <p>Has the application owner approval obtained while adding a user to the system?<sup>*</sup></p>
 <form:radiobutton path="Q4" value="yes" required="required"/>
 <form:label class="labels" path="Q4">Yes</form:label>
 <form:radiobutton path="Q4" value="no" required="required"/>
 <form:label class="labels" path="Q4">No</form:label>
  </div>
   <div>
  <p>Is data deletion from the system done with application owner approval?<sup>*</sup></p>
 <form:radiobutton path="Q5" value="yes" required="required"/>
 <form:label class="labels" path="Q5">Yes</form:label>
 <form:radiobutton path="Q5" value="no" required="required"/>
 <form:label class="labels" path="Q5">No</form:label>
  </div>
  <button class="btn btn-primary" type="submit" value="submit">Submit</button>
 </div>
 
 
 
 <div id="1" style="display:none;">
 <div>
  <p>Have all Change requests followed SDLC before PROD move?<sup>*</sup></p>
 <form:radiobutton class="inputs" path="Q1" value="yes" required="required"/> 
  <form:label class="labels" path="Q1">Yes</form:label>
 <form:radiobutton class="inputs" path="Q1" value="no" required="required"/>
 <form:label class="labels" path="Q1">No</form:label>
  </div>
  <div>
  <p>Have all Change requests been approved by the application owner?<sup>*</sup></p>
 <form:radiobutton path="Q2" value="yes" required="required"/>
<form:label class="labels" path="Q2">Yes</form:label>
 <form:radiobutton path="Q2" value="no" required="required"/>
 <form:label class="labels" path="Q2">No</form:label>
  </div>
  <div>
  <p>Are all artifacts like CR document, Unit test cases available?<sup>*</sup></p>
 <form:radiobutton path="Q3" value="yes" required="required"/>
<form:label class="labels" path="Q3">Yes</form:label>
 <form:radiobutton path="Q3" value="no" required="required"/>
 <form:label class="labels" path="Q3">No</form:label>
  </div>
  <div>
  <p>Is the SIT and UAT sign-off available?<sup>*</sup></p>
  <form:radiobutton path="Q4" value="yes" required="required"/>
 <form:label class="labels" path="Q4">Yes</form:label>
 <form:radiobutton path="Q4" value="no" required="required"/>
 <form:label class="labels" path="Q4">No</form:label>
  </div>
  <div>
  <p>Is data deletion from the system done with application owner approval?<sup>*</sup></p>
 <form:radiobutton path="Q5" value="yes" required="required"/>
 <form:label class="labels" path="Q5">Yes</form:label>
 <form:radiobutton path="Q5" value="no" required="required"/>
 <form:label class="labels" path="Q5">No</form:label>
  </div>
 <button class="btn btn-primary" type="submit" value="submit" >Submit</button>
 </div>
 
 </form:form>
 </div>
 </div>
 </div>
 </div>
 </div>
 </div>
 

 <script>
 function check(nameSelect)
 {
 document.getElementById("0").style.display = "none";
 document.getElementById("1").style.display = "none";
     if(nameSelect){
         var a=document.getElementById("mySelect").value;
         console.log(a);
         if(a=="SOX"){
         document.getElementById("0").style.display = "block";
         }
         else if(a=="Internal"){
         document.getElementById("1").style.display = "block";
         }
     }
     else{
       document.getElementById("0").style.display = "none";
     }

 }

</script>
</body>
</html>