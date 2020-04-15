<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel = "stylesheet" type = "text/css" href = "style.css"/>
    </head>
    <style>
        body{
            background-image: url("./img/login-bg.png");
            background-repeat:no-repeat;   
            background-size: cover;
        }
    </style>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-orange">
            <a class="navbar-brand title" href="./About.jsp" >CSCI-201 Project: Good Morning</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav title">
                        <a class="nav-item nav-link" href="./About.jsp">About us</a>
                        <a class="nav-item nav-link" href="./MoodBoard.jsp">Moodboard</a>
                        <a class="nav-item nav-link active" href="./Login.jsp">Login <span class="sr-only">(current)</span></a>
                        <a class="nav-item nav-link" href="./SignUp.jsp">Signup </a>
                        
                        
                </div>
            </div>
          </nav>
        <div class="space"></div>
        <div id = "login-header" class="container">
            <div class="row justify-content-center">
                <img src="img/sun-icon.png" alt="sun-icon">
            </div>
            <div class="row justify-content-center removeMargin projectName">
                <p>Good Morning</p>
            </div>
        </div>
        
        
        <form action="Login" method="POST">
            <div class="form-group">
              <input type="text" class="form-control manIconBox input-bg set-width-30 center input-border" id="username" placeholder="USER NAME" name="username">
            </div>
            <div class="form-group">
              <input type="password" class="form-control passwordBox input-bg set-width-30 center input-border" id="exampleInputPassword1" placeholder="PASSWORD" name="password">
            </div>
            <button type="submit" class="btn btn-outline-primary btn-color btn-border center">LOG IN</button>
            <div id="error">
			      <%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%></div>
          </form>
        <div class="textAlignCenter">
            <a href="./SignUp.jsp" class="center link-color">Sign up</a>
        </div>
    </body>
    
</html>