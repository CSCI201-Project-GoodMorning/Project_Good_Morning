package mail;

import javax.mail.MessagingException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import mail.getContent;


public class Mail {
	
	public static void main(String[] args) throws MessagingException, SQLException, IOException {

	  //create arraylist that will hold contents of each email to be sent
	  ArrayList<EmailContents> emails = getContent.getEmailContent();	
	   
	  //send emails
      for(int i = 0; i<emails.size(); i++) {
    	  SendEmail.SendEmail(emails.get(i));
      }     	
	}
}
