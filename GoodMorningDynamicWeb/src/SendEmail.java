import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*;

import javax.activation.*; 
  
public class SendEmail  
{ 
  
	private static Message prepareMessage(Session session, String sender, EmailContents toSend) throws IOException {
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toSend.getEmailAddress()) );
			message.setSubject("Good Morning! :) ");
			
			//Pull Html Template and add Quote as body
			File emailTemplate = new File("EmailTemplate.html");
			StringBuilder contentBuilder = new StringBuilder();
		    try (BufferedReader br = new BufferedReader(new FileReader("EmailTemplate.html"))) 
		    {
		 
		        String sCurrentLine;
		        while ((sCurrentLine = br.readLine()) != null) 
		        {
		            contentBuilder.append(sCurrentLine).append("\n");
		        }
		    } 
		    catch (IOException e) 
		    {
		        e.printStackTrace();
		    }
			String htmlString = contentBuilder.toString();
			htmlString = htmlString.replace("$body", toSend.getQuote());
			message.setContent(htmlString, "text/html; charset=utf-8");

			return message;
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
   public static void SendTheEmail(EmailContents toSend) throws MessagingException, IOException  
   {     
  
      // email ID of goodmorning. 
      String sender = "goodmorning2020CSCI@gmail.com";
      String password = "Goodmorning6!";
  
      //set properties
      Properties properties = new Properties(); 
      properties.put("mail.smtp.host", "smtp.gmail.com"); 
      properties.put("mail.smtp.port","587");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.auth", true);
      
      // creating session object to get properties 
      Session session = Session.getInstance(properties, new Authenticator() {
    	  protected PasswordAuthentication getPasswordAuthentication() {
    		  return new PasswordAuthentication(sender, password);
    	  }
      }); 
     
      Message message = prepareMessage(session, sender, toSend);
      Transport.send(message);
      System.out.println("Message sent Successfully");
   }


} 
