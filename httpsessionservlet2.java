package Phase2_servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class httpsessionservlet2
 */
@WebServlet("/httpsessionservlet2")
public class httpsessionservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public httpsessionservlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		String age=(String)session.getAttribute("age");
		String email=(String)session.getAttribute("email");
		String country=(String)session.getAttribute("country");
		
		
		 out.println("\nUsername: "+username);

		 out.println("\nPassword: "+password);

		 out.println("\nage: "+age);

		 out.println("\nemail: "+email);

		 out.println("\nCountry: "+country);
		 
		 out.println("\nsession creation time" + session.getCreationTime());
	     out.println("\nsession last accessed time" +session.getLastAccessedTime());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
