package config;

public class Constants {
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	public static final String DB_NAME = "gmData";
	public static final String CREDENTIALS_STRING 
	= "jdbc:mysql://localhost/"+DB_NAME+"?user="+DB_USERNAME+"&password="+DB_PASSWORD+"&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
}
