

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MoodBoardServlet
 */
@WebServlet("/MoodBoardServlet")
public class MoodBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoodBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		not created yet
		HttpSession session = request.getSession();
		if (session.getAttribute("sixPicURLs") == null || session.getAttribute("interests") == null) {
			int id = (int)session.getAttribute("userid");
			MoodBoardCreation m = new MoodBoardCreation();
			ArrayList<String> picURLs = m.moodBoardURLS(id);
			ArrayList<String> interests_for_api = m.randomInterests(id);
			session.setAttribute("sixPicURLs", picURLs);
			session.setAttribute("interests", interests_for_api);
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/MoodBoard.jsp");
		try {
			dispatch.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
