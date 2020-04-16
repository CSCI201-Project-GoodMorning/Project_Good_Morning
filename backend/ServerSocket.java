import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/ws")
public class ServerSocket {

	private static Vector<HttpSession> sessionVector = new Vector<HttpSession>();
	
	@OnOpen
	public void open(HttpSession session) throws IOException {
		System.out.println("Connection made!");

		
		//create instance of a quote for every instance of a web socket (ie a user)
		//pass session into quote constructor
		//call API in the constructor of the quote to get the list of 5 quotes
		Quote q = new Quote(session);

		sessionVector.add(session);

		for(int i=1;i<6;i++) {
			((Session) session).getBasicRemote().sendText((String) session.getAttribute("quote"+i));
		}

	}
	
	@OnMessage
	public void onMessage(String message, HttpSession session) {
		System.out.println(message);
		for(HttpSession s : sessionVector) {
			//s.getBasicRemote().sendText(message);
		}
	}
	
	@OnClose
	public void close(HttpSession session) {
		System.out.println("Disconnecting!");
		sessionVector.remove(session);
	}
	
	@OnError
	public void error(Throwable error) {
		System.out.println("Error!");
	}
}