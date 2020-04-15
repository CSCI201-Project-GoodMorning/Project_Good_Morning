package mail;

public class EmailContents {
	public String name;
	public String emailAddress;
	public String quote;
	public String photURL;
	
	public EmailContents(String name, String emailAddress, String quote, String photoURL) {
		
		this.name = name;
		this.emailAddress = emailAddress;
		this.quote = quote;
		this.photURL = photoURL;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getPhotURL() {
		return photURL;
	}

	public void setPhotURL(String photURL) {
		this.photURL = photURL;
	}
	
	
}
