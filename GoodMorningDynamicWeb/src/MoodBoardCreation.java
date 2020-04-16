import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import config.Constants;

public class MoodBoardCreation {
	public static void main(String []args) {
		MoodBoardCreation m = new MoodBoardCreation();
		ArrayList<String> urls = m.moodBoardURLS(17);
		for(int i=0;i<urls.size(); i++) {
			System.out.println(urls.get(i));
		}
	}
	public ArrayList<String> moodBoardURLS(int userID) {
		//get user ID from servlet??
		//int userID = 0;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> preferences = new ArrayList<String>();
        ArrayList<String> finalURLS = new ArrayList<String>();
		try {
			//3306 is default port so don't need to include
			conn = DriverManager.getConnection(Constants.CREDENTIALS_STRING);
			st = conn.createStatement();
			//access user's preferences list from database
			rs = st.executeQuery("SELECT * FROM USERS WHERE userID='" + userID + "'");
			while(rs.next()) {
				//create list of preferences that are true
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
			}
			//generate 3 random numbers from 0 to length of preferences list
			int prefs = preferences.size();
			System.out.println("size of prefs is " + prefs);
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int i=0; i<prefs; i++) {
				nums.add(i);
			}
			Collections.shuffle(nums);

			//	
			
			
	        int num1 = nums.get(0); 
	        int num2 = nums.get(1); 
	        int num3 = nums.get(2);
	        
	        ArrayList<String> picURLS = new ArrayList<String>();
	        System.out.println("3 preferenecs are " + preferences.get(num1) + " " + preferences.get(num2) + " " + preferences.get(num3));
	        //for each preference, use preference ID to select 3 random picture IDs that match the preference
			rs = st.executeQuery("SELECT photoURL FROM PICTURES WHERE attribute='" + preferences.get(num1) + "'");
			while(rs.next()) {
				String url = rs.getString("photoURL");
				picURLS.add(url);
			}
			Collections.shuffle(picURLS);
			for(int i=0; i<2; i++) {
				finalURLS.add(picURLS.get(i));
			}
			picURLS.clear();
			rs = st.executeQuery("SELECT photoURL FROM PICTURES WHERE attribute='" + preferences.get(num2) + "'");
			while(rs.next()) {
				String url = rs.getString("photoURL");
				picURLS.add(url);
			}
			Collections.shuffle(picURLS);
			for(int i=0; i<2; i++) {
				finalURLS.add(picURLS.get(i));
			}
			picURLS.clear();
			rs = st.executeQuery("SELECT photoURL FROM PICTURES WHERE attribute='" + preferences.get(num3) + "'");
			while(rs.next()) {
				String url = rs.getString("photoURL");
				picURLS.add(url);
			}
			Collections.shuffle(picURLS);
			for(int i=0; i<2; i++) {
				finalURLS.add(picURLS.get(i));
			}
			picURLS.clear();
			//post the 9 pictures to the userID's mood board
			//what output does she want and the size of the outputs
			
		} catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		}
		return finalURLS;
	}
	
//	return preference list with random order
	public ArrayList<String> randomInterests(int userID) {
		//get user ID from servlet??
		//int userID = 0;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> preferences = new ArrayList<String>();
//		ArrayList<String> three_interests = new ArrayList<String>();

		try {
			//3306 is default port so don't need to include
			conn = DriverManager.getConnection(Constants.CREDENTIALS_STRING);
			st = conn.createStatement();
			//access user's preferences list from database
			rs = st.executeQuery("SELECT * FROM USERS WHERE userID='" + userID + "'");
			while(rs.next()) {
				//create list of preferences that are true
				boolean prefSoccer = rs.getBoolean("prefSoccer");
				if(prefSoccer) {
					preferences.add("sports");
				}
				boolean prefDance = rs.getBoolean("prefDance");
				if(prefDance) {
					preferences.add("dance");
				}
				boolean prefSinging = rs.getBoolean("prefSinging");
				if(prefSinging) {
					preferences.add("song");
				}
				boolean prefPolitics = rs.getBoolean("prefPolitics");
				if(prefPolitics) {
					preferences.add("politics");
				}
				boolean prefFashion = rs.getBoolean("prefFashion");
				if(prefFashion) {
					preferences.add("fashion");
				}
				boolean prefLiterature = rs.getBoolean("prefLiterature");
				if(prefLiterature) {
					preferences.add("book");
				}
				boolean prefVolunteer = rs.getBoolean("prefVolunteer");
				if(prefVolunteer) {
					preferences.add("people");
				}
				boolean prefTravel = rs.getBoolean("prefTravel");
				if(prefTravel) {
					preferences.add("travel");
				}
				boolean prefCooking = rs.getBoolean("prefCooking");
				if(prefCooking) {
					preferences.add("food");
				}
			}
			//generate 1 random number from 0 to length of preferences list

//			ArrayList<Integer> nums = new ArrayList<Integer>();
//			for(int i=0; i<prefs; i++) {
//				nums.add(i);
//			}
			Collections.shuffle(preferences);
//	        int num1 = nums.get(0); 
//	        int num2 = nums.get(1); 
//	        int num3 = nums.get(2);
//	        three_interests.add(preferences.get(num1));
//	        three_interests.add(preferences.get(num2));
//	        three_interests.add(preferences.get(num3));
			
		} catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		}
		return preferences;
	}
}
