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
  
        *{
            box-sizing: border-box;
        }
        body{
            background-color: #ffebee;
            /* font-family: body; */
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
                        <a class="nav-item nav-link active" href="./About.jsp">About us<span class="sr-only">(current)</span></a>
                        <a class="nav-item nav-link" href="./MoodBoard.jsp">Moodboard</a>
                        <% if (session.getAttribute("userid") == null){ %>
	                        <a class="nav-item nav-link" href="./Login.jsp">Login</a>
	                        <a class="nav-item nav-link" href="./SignUp.jsp">Signup</a>
	                     <%} else{ %>
	                    	 <a class="nav-item nav-link" href="./Logout.jsp">Logout</a>
	                    <%  } %>
                        
                        
                </div>
            </div>
        </nav>

        <div class="relative" id = "signup-icon">
            <img src="img/sun-icon.png" alt="sun-icon">
            <div class="icon-absolute">
                <p class="projectName">Good Morning</p>
            </div>
        </div>
                
         
        <div class="space container-fluid removePad ">
            <div class="space"></div>
            <div class="col bg-blue banner-size textAlignCenter">
                <p>Welcome!</p>
            </div>
        </div>
     
        
        <div class="set-width-60 center">
            <p>Good Morning is a mental-health platform designed to help you get out of bed in the morning and start your day with energy! Good Morning provides you with a personalized mood board tailored to your interests and sends you special daily emails with motivational quotes relating to the specific sources of stress in your life. Join our community!

            </p>
           
        </div>
        <div class="space-sm"></div>
        
        <a href="MoodBoard.jsp" class="btn btn-info center set-width-30" role="button"><%= (session.getAttribute("userid") == null)?("Click to view sample MoodBoard"):("Back to your personalized MoodBoard")%></a>
    </body>
    
</html>