import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDateTime;

import org.apache.jasper.tagplugins.jstl.core.Url;

import com.google.gson.Gson;
//pass a random # 

//# of threads should equal the # of users

public class Quote extends Thread {
	
	private static String content;

	public static String getContent() {
		return content;
	}

	public static void setContent(String content) {
		Quote.content = content;
	}

	public Quote(String cont) {
		this.content = cont;
		this.start();
	}
	
	public static void main(String[] args) throws IOException {
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
			//System.out.println(json_result);
			
			RandomQuote rq = null;
			Gson gson = new Gson();
			rq = gson.fromJson(json_result, RandomQuote.class);
			content = rq.getContent();
			Quote q = new Quote(content);
			
			}
		else {
			System.out.println("Connection of API is not OK");
		}
		
		//needs to be as many "threads" in the pool as there are, profiles
		
		//where to create the new cached thread pool
		
	}
	
	public void run() {
	
		while(true) {
			while(Util.getCurrentTime() == "08:00:00") {
				System.out.println(Quote.getContent());
				try {
					//sleep for a day
					Thread.sleep(86400000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		//need to be able to send this quote to the front end
	}
	
}

