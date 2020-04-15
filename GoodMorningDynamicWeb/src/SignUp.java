import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import config.*;
/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
//	public static final String CREDENTIALS_STRING = "jdbc:mysql://localhost:3306/gmData?user=root&password=root";
	static Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		HttpSession session = request.getSession();
		ResultSet rs = null;
		PreparedStatement ps = null;
		String name = request.getParameter("signup_name");
		String username = request.getParameter("signup_username");
		String email = request.getParameter("signup_email");
		String password = request.getParameter("signup_password");
		String phone = request.getParameter("signup_phone");
		String confirmpassword = request.getParameter("signup_confirm");
		//printData(name, username, email, password, phone, confirmpassword);

		String error = "";
		String next = "/Quiz.jsp";

		//error checking
		System.out.println(name);
		if (name.equals("")) {
			error += "Name cannot be empty.";
			next = "/SignUp.jsp";
		}

		if (username.equals("")) {
			error += "User Name cannot be empty.";
			next = "/SignUp.jsp";
		}

		if (email.equals("")) {
			error += "Email cannot be left empty.";
			next = "/SignUp.jsp";
		}

		if (password.equals("")) {
			error += "Password cannot be left empty.";
			next = "/SignUp.jsp";
		}
		
		if (phone.equals("")) {
			error += "Phone number cannot be left empty.";
			next = "/SignUp.jsp";
		}
		
		if (confirmpassword.equals("")) {
			error += "Must confirm password.";
			next = "/SignUp.jsp";
		}
		
		if (confirmpassword.equals(password) == false) {
			error += "Passwords do not match. Please try again.";
			next = "/SignUp.jsp";
		}
		
	    //check that there are no duplicate usernames
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(Constants.CREDENTIALS_STRING);
			String sql = "SELECT * FROM users WHERE username = ?;";
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				error += "User Name is taken.";
				next = "/SignUp.jsp";
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 

		//if there are no errors, save info to database
		 int registereduser = 0;
	     int id = -1;
		 if (error.equals("")) 
		 {
			
			registereduser = 1;
			try {
			
				
				
				String sql = "insert into users (username, fullName, registeredUser, email, passcode) values('" + username + "', '" + name + "', '" + registereduser + "', '" + email + "', '" + password + "')";
//	            System.out.println(sql);
	           
//				st = conn.createStatement();
//				
//				  
//				  
//				 rs = st.executeQuery("select ClassName,count(ID) as number from Grades group by ClassName;");
				ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            ps.executeUpdate();
	          
	            rs = ps.getGeneratedKeys();
	            if(rs != null && rs.next()){
	            	id = rs.getInt(1);
	            	System.out.println("Id: " + id);
	            }
	        }
			catch (SQLException e) {
				e.printStackTrace();
			} 

			session.setAttribute("name", name);
			session.setAttribute("username", username);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			session.setAttribute("userid", id);
			session.setAttribute("registereduser", registereduser);
			request.setAttribute("name", name);
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("userid", id);
			request.setAttribute("registereduser", registereduser);

		
			
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
	
	    private void printData(String name, String username, String email, String password, String phone, String confirmpassword) {
			System.out.println("Name = " + name);
			System.out.println("User Name = " + username);
			System.out.println("Email = " + email);
			System.out.println("Password = " + password);
			System.out.println("Phone = " + phone);
			System.out.println("Confirmed Password = " + confirmpassword);

        }


}




	
	

