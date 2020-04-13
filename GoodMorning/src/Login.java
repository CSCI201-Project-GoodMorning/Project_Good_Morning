

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	public static final String CREDENTIALS_STRING = "jdbc:mysql://localhost:3306/gmData?user=root&password=root";
	static Connection connection = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//get all parameters from Login.jsp
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String error = "";
			String next = "/MoodBoard.jsp";
			if (username.equals("")) {
				error += "Please input a user name.";
				next = "/Login.jsp";
				request.setAttribute("error", error);
				System.out.println("no username");
			}
			if (password.equals("")) {
				error += "Please input a password.";
				next = "/Login.jsp";
				request.setAttribute("error", error);
				System.out.println("no username");
			}
			
			//no errors, check that username and password exists
			int id = -1;
			if (error.equals("")) {
				try {
					PreparedStatement ps = null;
					ResultSet rs = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(CREDENTIALS_STRING);
					String insert = "SELECT * FROM users WHERE username = ? AND passcode = ?;";
					ps = (PreparedStatement) connection.prepareStatement(insert);
					ps.setString(1, username);
					ps.setString(2, password);
					rs = ps.executeQuery();
					Boolean foundMatch = false;
					while (rs.next() && !foundMatch) {
						String uname = rs.getString("username");
						String pword = rs.getString("passcode");
						if (uname.equals(username) && pword.equals(password)) {
							id = rs.getInt("userID");
							foundMatch = true;
						}
					}
					if(!foundMatch){
						error += "Username or Password is not correct.";
						next = "/Login.jsp";
						request.setAttribute("error", error);
						System.out.println("no username");
					}
					else{
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						session.setAttribute("userid", id);
						request.setAttribute("username", username);
						request.setAttribute("password", password);
						request.setAttribute("userid", id);
					}
				}
				catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				} 
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
