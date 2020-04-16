

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import config.Constants;

/**
 * Servlet implementation class Quiz
 */
@WebServlet("/Quiz")
public class Quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//connecting to database: change for your database
//	public static final String CREDENTIALS_STRING = "jdbc:mysql://localhost:3306/gmData?user=root&password=root";
	static Connection connection = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		//get all parameters from SignUp.jsp
    	
    	//creating session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int id = (int) session.getAttribute("userid");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String feeling = request.getParameter("feeling");
		String[] interests = request.getParameterValues("interests");
		String stress  = request.getParameter("stress");
		String[] joy = request.getParameterValues("joy");
		String time = request.getParameter("time");
		String error = "";
		String next = "/MoodBoard.jsp";

		//error checking
		if (feeling == null || feeling.equals("")) {
			//this one does not work, need to fix
			error += "Feeling not selected.";
			next = "/Quiz.jsp";
			System.out.println("feeling not selected.");
		}

		if (interests == null) {
			error += "Interest not selected";
			next = "/Quiz.jsp";
		}

		if (stress == null) {
			error += "Stress not selected.";
			next = "/Quiz.jsp";
		}

		if (joy == null) {
			error += "No images selected.";
			next = "/Quiz.jsp";
		}
		if (time==null || time.equals("")) {
			error += "No time selected.";
			next = "/Quiz.jsp";
		}
		
		//no fields empty, save to database
		 if (error.equals("")) 
		 {
			 //Convert to array to hash set to save time instead of iteration
			 HashSet<String> joySet = new HashSet<>(Arrays.asList(joy));
			 HashSet<String> interestSet = new HashSet<>(Arrays.asList(interests));
			  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(Constants.CREDENTIALS_STRING);
				String sql = null;
				if(joySet.contains("animals")){
					sql = "UPDATE users SET prefAnimal = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("water")){
					sql = "UPDATE users SET prefWater = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("museum")){
					sql = "UPDATE users SET prefMuseum = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("food")){
					sql = "UPDATE users SET prefFood = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("architecture")){
					sql = "UPDATE users SET prefArchitecture = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("art")){
					sql = "UPDATE users SET prefArt = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("sky")){
					sql = "UPDATE users SET prefSky = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("flowers")){
					sql = "UPDATE users SET prefFlower = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("mountains")){
					sql = "UPDATE users SET prefMountains = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("soccer")){
					sql = "UPDATE users SET prefSoccer = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("politics")){
					sql = "UPDATE users SET prefPolitics = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("volunteering")){
					sql = "UPDATE users SET prefVolunteer = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("dance")){
					sql = "UPDATE users SET prefDance = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(joySet.contains("fashion")){
					sql = "UPDATE users SET prefFashion = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("traveling")){
					sql = "UPDATE users SET prefTravel = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("singing")){
					sql = "UPDATE users SET prefSinging = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("literature")){
					sql = "UPDATE users SET prefLiterature = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				if(interestSet.contains("cooking")){
					sql = "UPDATE users SET prefCooking = 1 WHERE username = '" + username + "'";
					ps = connection.prepareStatement(sql);
					ps.executeUpdate();
				}
				sql = "UPDATE users SET emailPrefDaily = 1 WHERE username = '" + username + "'";
				ps = connection.prepareStatement(sql);
				ps.executeUpdate();
				//insert into emails table
				
				
				
				
				
				
				
				
//				bug here!, todo: photo url and goodmorning message, change following later
				String photoURL = "photo";
				String goodMorningMessage = "Good Morning";
				
				
				
				
				
			
				
				
				sql = "UPDATE users SET emailTimePreference = '"+time+"' WHERE username = '"+username+"'";
				System.out.println(sql);
				
				ps = connection.prepareStatement(sql);
				ps.executeUpdate();
				
				
				
//				create moodboard
				MoodBoardCreation m = new MoodBoardCreation();
				ArrayList<String> picURLs = m.moodBoardURLS(id);
				ArrayList<String> interests_for_api = m.randomInterests(id);
				session.setAttribute("sixPicURLs", picURLs);
				session.setAttribute("interests", interests_for_api);
				for (String i:interests_for_api) {
					System.out.println(i);
				}
		    }
			catch (SQLException | ClassNotFoundException e) {
		    	e.printStackTrace();
		    } 
		
	    }
		 else{
			 request.setAttribute("error", error);
		 }
		 
		 RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);

			try {
				dispatch.forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}

	}
}
