package mail;

import javax.mail.MessagingException;
import java.sql.*;

public class Mail {
	public static void main(String[] args) throws MessagingException, SQLException {
	  Connection conn = null;
	  Statement st = null;
	  ResultSet rs = null;
	  try {
		  conn = DriverManager.getConnection("jdbc:mysql://localhost/gmdata?user=root&password=root");
		  String tag = "isAnimal";
		  rs = st.executeQuery("SELECT * from gmdata.pictures where attribute='" + tag + "'");
		  String photoURL = rs.getString("photoURL");
		  System.out.println(photoURL);
	  }finally {
		  try {
			  if (rs != null) {
				  rs.close();
			  }
			  if (st != null) {
				  st.close();
			  }
			  if (conn != null) {
				  conn.close();
			  }
		  } catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	  }
		
	  String[] recepients = new String[2];	
      recepients[0] = "marcosm9@usc.edu";
      recepients[1] = "henrycikanek14@gmail.com";
      for(int i = 0; i<recepients.length; i++) {
    	  SendEmail.SendEmail(recepients[i]);
      }     	
	}
}
