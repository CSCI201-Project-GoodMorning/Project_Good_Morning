import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Url;

import com.google.gson.Gson;

public class Quote extends Thread {
	
	private static String content;
	
	//list of 5 quotes to be accessed by the front end user
	private static List<String> q_list;
	
	//HTTP session from which we set the 5 quotes as individual attributes
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public static List<String> getQ_list() {
		return q_list;
	}

	public void setQ_list(List<String> q_list2) {
		this.q_list = q_list2;
	}
	
	public static String getContent() {
		return content;
	}

	public static void setContent(String content) {
		Quote.content = content;
	}

	//as soon as the quote object is instantiated
	//before the thread begins running, the api is called and its quote list is set
	//attribute is NOT set until the thread begins running
	public Quote(Session s) throws IOException {
		
	
//		for(int i=0;i<5;i++) {
//			//get a random quote string returned by the call API function
//			content = q.call_API();
//			//add that quote to the list of 5 quotes private variable
//			list_of_quotes.add(content);
//		}
//		this.setQ_list(list_of_quotes);
		//set this sesson = to the session you pass in the thread constructor
		this.session = s;
	}
	
	public static String call_API() throws IOException {
		
		String url_API = "https://api.quotable.io/random";
		URL url = null;
		
		url = new URL(url_API);
		HttpURLConnection connection =(HttpURLConnection) url.openConnection();

		//set up connection

			connection.setRequestMethod("GET");
			connection.connect();

		int status = 0;
		status = connection.getResponseCode();
		
		String readLine = null;
		
		if (status == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();
				while ((readLine = in.readLine()) != null) {
					response.append(readLine);
					} 

			String json_result = response.toString();
			
			RandomQuote rq = null;
			Gson gson = new Gson();
			rq = gson.fromJson(json_result, RandomQuote.class);
			content = rq.getContent();
			return content;
			
			}
		else {
			System.out.println("Connection of API is not OK");
			return "Error with Quotes";
		}

	}
	
	public void run() {

		while (true) {
			//get a new set of 5 quotes every 2 minutes

//			this.session.setAttribute("quote1",this.q_list.get(0));
//			this.session.setAttribute("quote2",this.q_list.get(1));
//			this.session.setAttribute("quote3",this.q_list.get(2));
//			this.session.setAttribute("quote4",this.q_list.get(3));
//			this.session.setAttribute("quote5",this.q_list.get(4));
//			print quote
			try {
				call_API();

				session.getBasicRemote().sendText(content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//sleep for 2 minutes
			try {
				Thread.sleep(10000);
//				List<String> list_of_quotes = null;
//				Quote q=null;
//				String content ="";
//				for(int i=0;i<5;i++) {
//					//get a new quote string with every API call
//					content = q.call_API();
//					//add that quote to your list of quotes
//					list_of_quotes.add(content);
//				}
//				this.setQ_list(list_of_quotes);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	

		
	}

	
}

