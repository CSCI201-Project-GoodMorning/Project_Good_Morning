import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Mail.getContentDaily;


public class getContentIndividual {
	
	//will recieve some input about user from frontend
	public static EmailContents getContent(int userid) throws IOException {
		EmailContents email	= new EmailContents(null, null, "This will be a Quote", null);
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		  try {
			  
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/gmData?user=root&password=root&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
			  st = conn.createStatement();
			  //get all users who wish to be emailed daily
			  rs = st.executeQuery("SELECT * FROM USERS WHERE userID='" + userid + "'");
			  while(rs.next()) {
				  
				  //get and set email address for current user
				  String emailAddress = rs.getString("email");
				  email.setEmailAddress(emailAddress);
				  
				  //get and set name for current user
				  String name = rs.getString("fullName");
				  email.setName(name);
				  
				  //select a randomized preference
				  String preference = getContentDaily.getPreference(rs);
				  
				  //then using preference query a photo for each user that matches said preference
				  String photoURL = getContentDaily.getPhoto(preference);
				  email.setPhotURL(photoURL);
				  
				  //need to use quotes api to get quote based on preference
				  Quote q=null;
				  String content = q.call_API();
				  email.setQuote(content);
				  
			  }
			  	  
		  } catch (SQLException sqle) {
			  System.out.println(sqle.getMessage());
		  }
		return email;
		
	}
}

