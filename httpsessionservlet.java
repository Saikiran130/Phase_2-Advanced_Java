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
 * Servlet implementation class httpsessionservlet
 */
@WebServlet("/httpsessionservlet")
public class httpsessionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public httpsessionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		session.setAttribute("username", user);
		session.setAttribute("password", pass);
		session.setAttribute("age", age);
		session.setAttribute("email", email);
		session.setAttribute("country", country);
		
		
		out.println("<a href='httpsessionservlet2'>Click here to go next servlet</a>");
		out.close();
		
	}

}
