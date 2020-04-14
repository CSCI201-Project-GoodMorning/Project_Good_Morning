package mail;

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
  
public class SendEmail  
{ 
  
	private static Message prepareMessage(Session session, String sender, String recipient) {
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient) );
			message.setSubject("Good Morning!:)");
			message.setText("This will be a quote!");
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
	
   public static void SendEmail(String recipient) throws MessagingException  
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
     
      Message message = prepareMessage(session, sender, recipient);
      Transport.send(message);
      System.out.println("Message sent Successfully");
   }


} 
