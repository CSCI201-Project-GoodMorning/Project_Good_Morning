<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 %>
 <%@page import="java.util.ArrayList" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
<%

	ArrayList<String> picURLs = (ArrayList<String>)session.getAttribute("sixPicURLs");
	ArrayList<String> interests_for_api	= (ArrayList<String>)session.getAttribute("interests");
	
	boolean login = false;
	if (session.getAttribute("userid")!=null) login = true;
%>
    </style> 
    <body <%if(login){ %> onload="connectToServer()" onclick="removeAll()" <%} %>>
        <nav class="navbar navbar-expand-lg navbar-light bg-orange">
            <a class="navbar-brand title" href="./About.jsp" >CSCI-201 Project: Good Morning</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav title">
                        <a class="nav-item nav-link" href="./About.jsp">About us<span class="sr-only">(current)</span></a>
                        <a class="nav-item nav-link active" href="./MoodBoard.jsp">Moodboard</a>
                        <% if (!login){ %>
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
                <p>Mood Board</p>
            </div>
        </div>

<!-- test -->
<!-- 
<form name="chatform" onsubmit="return sendMessage();">
			<input type="text" name="message" value="Type Here!" /><br />
			<input type="submit" name="submit" value="Send Message" />
		</form>
		<br />
		<div id="mychat"></div> -->
		
        <div class="container">
        	
            <div class="row">
              <div class="col-4">
              	<%if (!login){ %>
              	
              		<img class='img-fluid' src='https://picsum.photos/300/300?random=1'>
              	<%}else {%>
                	<img class="img-fluid" src="<%=picURLs.get(0) %>">
                <%} %>
              </div>
              <div class="col-4 addBorderRL">
                <%if (!login){ %>
              	
              		<img class='img-fluid' src='https://picsum.photos/300/300?random=2'>
              	<%}else {%>
                	<img class="img-fluid" src="<%=picURLs.get(1) %>">
                <%} %>
              </div>
              <div class="col-4">
                <%if (!login){ %>
              	
              		<img class='img-fluid' src='https://picsum.photos/300/300?random=3'>
              	<%}else {%>
                	<img class="img-fluid" src="<%=picURLs.get(2) %>">
                <%} %>
              </div>
            </div>
            <div class="row">
                <div class="col-4 addBorderTB">
                  <%if (!login){ %>
              	
              		<img class='img-fluid' src='https://picsum.photos/300/300?random=4'>
              	<%}else {%>
                	<img class="img-fluid" src="<%=picURLs.get(3) %>">
                <%} %>
                </div>
                <div class="col-4 addBorderTB addBorderRL">
                  <%if (!login){ %>
              	
              		<img class='img-fluid' src='https://picsum.photos/300/300?random=5'>
              	<%}else {%>
                	<img class="img-fluid" src="<%=picURLs.get(4) %>">
                <%} %>
                </div>
                <div class="col-4 addBorderTB">
                  <%if (!login){ %>
              	
              		<img class='img-fluid' src='https://picsum.photos/300/300?random=6'>
              	<%}else {%>
                	<img class="img-fluid" src="<%=picURLs.get(5) %>">
                <%} %>
                </div>
              </div>
              <div class="row">
                <div id = "api-photo-1" class="col-4">
                  <%if (!login){ %><img class='img-fluid' src='https://picsum.photos/300/300?random=7'><%} %>
                </div>
                <div id = "api-photo-2" class="col-4 addBorderRL">
              		 <%if (!login){ %><img class='img-fluid' src='https://picsum.photos/300/300?random=8'><%} %>
                </div>
                <div id = "api-photo-3" class="col-4">
                 	<%if (!login){ %><img class='img-fluid' src='https://picsum.photos/300/300?random=9'><%} %>
                </div>
              </div>
          </div>

        <div class="space-sm"></div>
     
        
    
        <%if (session.getAttribute("userid")== null) {%><a href="SignUp.jsp" class="btn btn-info center set-width-30" role="button">Sign up as a member now</a>
        <%}else{ %>
        <form action="MoodBoardServlet" Method="GET">
        	<button class="btn btn-info center set-width-30" role="submit">Send a personalized Good Morning email</button>
        </form>
        <%} %>
    </body>
    <script>
    	<%if (login){%>
	      displayPhoto();  

	    
	  function displayPhoto(){
	        $.ajax({
	            method:"GET",
	            url:"https://api.unsplash.com/search/photos?orientation=squarish&query="+"<%=interests_for_api.get(0) %>"+"&client_id=9oq6Z9FdubF6e10dKETpZumlrGsuAtd0ov1bI7gUORA",
	        })
	        .done(function(response){
	        	console.log(response.results[0].urls.regular);
		        $("#api-photo-1").append("<img class= 'img-fluid' src="+response.results[0].urls.full+"/>");
	            $("#api-photo-2").append("<img class='img-fluid' src="+response.results[1].urls.full+"/>");
	            $("#api-photo-3").append("<img class='img-fluid' src="+response.results[2].urls.full+"/>");
	        })
	        .fail(function(){
	            console.log("ERROR");
	        });
	        
	    } 
	  var socket;
		function connectToServer() {
			socket = new WebSocket("ws://localhost:8080/CSCI201finalprojectelaine/ws");
			socket.onopen = function(event) {
				console.log("connected");
			}
			socket.onmessage = function(event) {
				/* document.getElementById("mychat").innerHTML += event.data + "<br />"; */
			/* 	alert(event.data); */
				randomPopup(event.data);
			}
			socket.onclose = function(event) {
				/* document.getElementById("mychat").innerHTML += "Disconnected!"; */
			}
		}
		function sendMessage() {
			/* socket.send("Miller: " + document.chatform.message.value); */
			return false;
		}
		function randomPopup(text){
		    var popup = document.createElement("div");
		    popup.innerHTML = text;
		    popup.classList.add("popup");
		    popup.style.top = getRandom(0,window.innerHeight-50) + "px";
		    popup.style.backgroundColor = "rgba(255, 150, 21, 0.5)";
		    popup.style.borderRadius = "25px";
		/*     popup.style.height = "20px"; */
		    popup.style.height = "auto";
		    popup.style.width = "15%";
		    popup.style.position = "fixed";
		    
		    if (getRandomBool()){
		    	popup.style.left = 0;
		    }
		    else{
		    	popup.style.right = 0;
		    }
		    var pos = document.querySelector("body");
		    pos.appendChild(popup);
		    
		}
		function getRandom (n,m) {
		    var num = Math.floor(Math.random()*(m-n)+n+1);
		    return num;
		}
		function getRandomBool(){
			if (Math.round(Math.random()) ==1){
				return true;
			}
			else{
				return false;
			}
		}
		function removeAll(){
			var popups = document.querySelectorAll(".popup");
			for (let i = 0; i < popups.length;i++){
				popups[i].remove();
          }
		}

		
	    <%}%>
    
    </script>
</html>