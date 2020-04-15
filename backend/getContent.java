package mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;


public class getContent {
	
	//gets a randomized preference for user each day
	private static String getPreference(ResultSet rs) throws SQLException {
		ArrayList<String> preferences = new ArrayList<String>();
		String preference = null;
		
		//get this users preferences
		boolean prefAnimal = rs.getBoolean("prefAnimal");
		if(prefAnimal) {
			preferences.add("isAnimal");
		}
		boolean prefFood = rs.getBoolean("prefFood");
		if(prefFood) {
			preferences.add("isFood");
		}
		boolean prefSky = rs.getBoolean("prefSky");
		if(prefSky) {
			preferences.add("isSky");
		}
		boolean prefWater = rs.getBoolean("prefWater");
		if(prefWater) {
			preferences.add("isWater");
		}
		boolean prefArchitecture = rs.getBoolean("prefArchitecture");
		if(prefArchitecture) {
			preferences.add("isArchitecture");
		}
		boolean prefFlower = rs.getBoolean("prefFlower");
		if(prefFlower) {
			preferences.add("isFlower");
		}
		boolean prefMuseum = rs.getBoolean("prefMuseum");
		if(prefMuseum) {
			preferences.add("isMuseum");
		}
		boolean prefArt = rs.getBoolean("prefArt");
		if(prefArt) {
			preferences.add("isArt");
		}
		boolean prefMountains = rs.getBoolean("prefMountains");
		if(prefMountains) {
			preferences.add("isMountains");
		}
		
		//generate a random number from 0 to length of preference list
		int prefs = preferences.size();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<prefs; i++) {
			nums.add(i);
		}

		//this is todays preference
		Collections.shuffle(nums);
        int num = nums.get(0); 
        
      //this is todays preference
        preference = preferences.get(num);
		
		return preference;
	}
	
	//gets a photo based on pref of the day
	private static String getPhoto(String preference) throws SQLException {
		ArrayList<String> picURLS = new ArrayList<String>();
		String finalurl = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rset= null;
		
		//establish second connection
		connection = DriverManager.getConnection("jdbc:mysql://localhost/gmData?user=root&password=root&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
		statement = connection.createStatement();
		rset = statement.executeQuery("SELECT photoURL FROM PICTURES WHERE attribute='" + preference + "'");
		
		//gather all pic urls for the preference
		while(rset.next()) {
			String url = rset.getString("photoURL");
			picURLS.add(url);
		}
		
		//shuffle set of picURLS
		Collections.shuffle(picURLS);
		
		//get the first of the list
		finalurl = picURLS.get(0);
		
		return finalurl;
	}
	
	//gets content for each user who has selected to recieve emails
	public static ArrayList<EmailContents> getEmailContent() throws SQLException{
		 Connection conn = null;
		 Statement st = null;
		 ResultSet rs = null;
		 ArrayList<EmailContents> emails = new ArrayList<EmailContents>();
		 
		  try {
			  
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/gmData?user=root&password=root&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
			  st = conn.createStatement();
			  //get all users who wish to be emailed daily
			  rs = st.executeQuery("SELECT * FROM USERS WHERE emailPrefDaily='" + 1 + "'");
			  while(rs.next()) {
				  EmailContents email = new EmailContents(null, null, "There Will Come a Day this is a quote", null);
				  
				  //get and set email address for current user
				  String emailAddress = rs.getString("email");
				  email.setEmailAddress(emailAddress);
				  
				  //get and set name for current user
				  String name = rs.getString("fullName");
				  email.setName(name);
				  
				  //select a randomized preference
				  String preference = getPreference(rs);
				  
				  //then using preference query a photo for each user that matches said preference
				  String photoURL = getPhoto(preference);
				  email.setPhotURL(photoURL);
				  
				  //need to use quotes api to get quote based on preference
				  
				  
				  //add to email list
				  emails.add(email);
			  }
			  	  
		  } catch (SQLException sqle) {
			  System.out.println(sqle.getMessage());
			  
		  } finally {
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
		 
		 return emails;
	}


}
