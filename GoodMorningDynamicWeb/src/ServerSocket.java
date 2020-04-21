import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

//import javax.servlet.http.HttpSession;
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

	private static Vector<Session> sessionVector = new Vector<Session>();
	@OnOpen
	public void open(Session session) throws IOException {
		System.out.println("Connection made!");
		if (!sessionVector.contains(session))
			sessionVector.add(session);	
		//create instance of a quote for every instance of a web socket (ie a user)
		//pass session into quote constructor
		//call API in the constructor of the quote to get the list of 5 quotes
		
		for(Session s : sessionVector) {
			s.getBasicRemote().sendText("someone joins in ~");
		}
		Quote q = new Quote(session);
		q.start();
		while (true) {
			
			try {
				System.out.println(sessionVector.size());
				session.getBasicRemote().sendText("There are currently "+sessionVector.size()+" active users");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//
//		sessionVector.add(session);
//
//		for(int i=1;i<6;i++) {
//			((Session) session).getBasicRemote().sendText((String) session.getAttribute("quote"+i));
//		}

	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println(message);
		for(Session s : sessionVector) {
			s.getBasicRemote().sendText(message);
		}
	}
	
	@OnClose
	public void close(Session session) {
		System.out.println("Disconnecting!");
		sessionVector.remove(session);
	}
	
	@OnError
	public void error(Throwable error) {
		System.out.println("Error!");
	}
}