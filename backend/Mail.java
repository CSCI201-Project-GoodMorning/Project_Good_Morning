package Mail;

import javax.mail.MessagingException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Mail.getContentDaily;


public class Mail {
	
	public static void main(String[] args) throws MessagingException, SQLException, IOException {

	  //create arraylist that will hold contents of each email to be sent
//	  ArrayList<EmailContents> emails = getContentDaily.getEmailContent();	
//	   
//	  //send emails
//      for(int i = 0; i<emails.size(); i++) {
//    	  SendEmail.SendEmail(emails.get(i));
//      }    
		
		int id = 5;
		EmailContents email = getContentIndividual.getContent(id);
		SendEmail.SendTheEmail(email);
	}
}


