import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import javax.mail.MessagingException;
//import javax.xml.ws.spi.http.HttpContext;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
//import Mail.getContentIndividual;

public class BasicHttpMailServer {

	  public static void main(String[] args) throws IOException {
	      HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
	      com.sun.net.httpserver.HttpContext context = server.createContext("/");
	      context.setHandler(arg0 -> {
			try {
				handleRequest(arg0);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	      server.start();
	  }

	  private static void handleRequest(HttpExchange exchange) throws IOException, MessagingException {
		  com.sun.net.httpserver.HttpContext asdf = exchange.getHttpContext();
		  asdf.getAttributes();
	      
	      EmailContents email = getContentIndividual.getContent(5);
	      SendEmail.SendTheEmail(email);
	  }
	}
