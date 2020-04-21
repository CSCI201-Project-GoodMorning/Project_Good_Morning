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
    <head>
   
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
                        <a class="nav-item nav-link" href="./About.jsp">About us<span class="sr-only">(current)</span></a>
                        <a class="nav-item nav-link" href="./MoodBoard.jsp">Moodboard</a>
                        <a class="nav-item nav-link" href="./Login.jsp">Login</a>
                        <a class="nav-item nav-link active" href="./SignUp.jsp">Signup</a>
                        
                        
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
            <div class="col bg-blue banner-size textAlignCenter align-middle addBorderTB title">
                <p>Quiz</p>
            </div>
        </div>
     
        
        
        <div class="container">
            <form method="POST" action="Quiz">
                <div id = "question1" class="addBgWhite addPadding questionBoxStyle">
                    <div>
                        <span class="numberMarkerStyle textAlignCenter">1</span><span>How are you feeling today?</span>
                    </div>
                    <div class="btn-group-toggle textAlignCenter" data-toggle="buttons">
                        <label class="btn  active radios">
                            <input type="radio" name="feeling"  value = "happy" checked><img src="img/smile.png">
                        </label>
                        <label class="btn radios">
                            <input type="radio" name="feeling" value = "sad" > <img src="img/sad.png">
                        </label>
                        <label class="btn radios">
                            <input type="radio" name="feeling" value = "angry" > <img src="img/angry.png">
                        </label>
                    </div>
                </div>

                <div class="addBgWhite addMarginTB addPadding questionBoxStyle">
                    <div>
                        <span class="numberMarkerStyle textAlignCenter">2 </span><span>Select all of your interests</span>
                    </div>
                    <div class="row btn-group-toggle addMarginTB" data-toggle="buttons">
                        <label class="col-3 addMargin btn btnStyle checkboxes">
                          <input type="checkbox" name = "interests" value="soccer"  > Soccer
                        </label>
                        <label class="col-3 addMargin btn  btnStyle checkboxes">
                          <input type="checkbox" name = "interests" value="politics"> Politics
                        </label>
                        <label class="col-3 addMargin btn btnStyle checkboxes">
                          <input type="checkbox" name = "interests" value="volunteering" > Volunteering
                        </label>
                      </div>

                      <div class="row btn-group-toggle addMarginTB" data-toggle="buttons">
                        <label class="col-3 addMargin btn btnStyle checkboxes">
                          <input type="checkbox" name = "interests" value="dance" > Dance
                        </label>
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                          <input type="checkbox" name = "interests" value="fashion"> Fashion
                        </label>
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                          <input type="checkbox" name = "interests" value="traveling" > Traveling
                        </label>
                      </div>

                      <div class="row btn-group-toggle addMarginTB " data-toggle="buttons">
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                          <input type="checkbox" name = "interests" value="singing" > Singing
                        </label>
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                          <input type="checkbox" name = "interests" value="literature" > Literature
                        </label>
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                          <input type="checkbox" name = "interests" value="cooking"> Cooking
                        </label>
                      </div>
                      
                </div>
                
                <div class="addBgWhite addPadding addMarginTB questionBoxStyle">
                    <span class="numberMarkerStyle textAlignCenter">3 </span><span>What is the biggest source of stress in your life?</span>
                    <div class="row btn-group-toggle addMarginTB" data-toggle="buttons">
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                            <input type="radio" name="stress" value="work"> Work
                        </label>
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                            <input type="radio" name="stress" value="school"> School
                        </label>
                        <label class="col-3 addMargin btn btnstyle checkboxes">
                            <input type="radio" name="stress" value="relationships"> Relationships
                        </label>
                        </div>
                </div>

                <div class="addBgWhite addPadding addMarginTB questionBoxStyle">
                        <span class="numberMarkerStyle textAlignCenter">4 </span><span>What images or places bring you joy?</span>
                        <div class="row btn-group-toggle addMarginTB" data-toggle="buttons">
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="animals"> Animals
                            </label>
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="water"> Water
                            </label>
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="museum"> Museum
                            </label>
                          </div>
                          <div class="row btn-group-toggle addMarginTB" data-toggle="buttons">
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="food"> Food
                            </label>
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="architecture"> Architecture
                            </label>
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="art"> Art
                            </label>
                          </div>
                          <div class="row btn-group-toggle addMarginTB" data-toggle="buttons">
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="sky"> Sky (sunsets)
                            </label>
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="flowers"> Flowers
                            </label>
                            <label class="col-3 addMargin btn btnstyle checkboxes">
                              <input type="checkbox" name="joy" value="mountains"> Mountains
                            </label>
                          </div>
                 </div>

                 <div class="addBgWhite addPadding addMarginTB questionBoxStyle">
                  <span class="numberMarkerStyle textAlignCenter">5 </span><span>What time of the day do you want to receive an email that makes you happy?</span>
                 
                 <div class="form-group row">
                 
                  <div class="col-3 center">
                    
                    <input class="form-control" name = "time" type="time" value="08:00" >
                    
                  </div>

                </div>      
                 </div>
    



                    <div class="row addMarginTB">
                        <div class="col-12">
                            <button type="submit" class="btn btn-outline-primary btn-color btn-border center">Submit</button>
                        </div>
                    
                    </div>
                </div>
                <div id="error">
			      <%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%></div>
            </form>
        
        </div>
    </body>
    <script>

      let imageRadios = document.querySelectorAll(".radios");
      for (let i = 0; i < imageRadios.length;i++){
        imageRadios[i].onclick = function(event){
              
        
                this.classList.add("selected");
              
                console.log("here")
                for (let j = 0; j < imageRadios.length;j++){
                  if (i != j){
                    imageRadios[j].classList.remove("selected");
                    
                  }
                }
        }
      }
      let checkboxes = document.querySelectorAll(".checkboxes");
      for (let i = 0; i < checkboxes.length; i++){
        checkboxes[i].onclick = function(){
          if (this === event.target) {
            /* click was on label */
            if (this.classList.contains("selected")){
              this.classList.remove("selected");
              console.log("here");
            }
            else{
              this.classList.add("selected");
              console.log("not here");
            }
          }
         
        }
      }
    </script>
</html>