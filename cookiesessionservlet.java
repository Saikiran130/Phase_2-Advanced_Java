package Phase2_servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookiesesssionservlet
 */
@WebServlet("/cookiesessionservlet")
public class cookiesessionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookiesessionservlet() {
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
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String user=request.getParameter("username");  
		    String pass=request.getParameter("password");
		  
		    Cookie ck=new Cookie("username",user);	
		    Cookie ck1=new Cookie("password",pass);//creating cookie object  
		    response.addCookie(ck);		
		    response.addCookie(ck1);//adding cookie in the response  
		  
		    //creating submit button  
		    out.print("<form action='cookiesessionservlet2' method='post'>");  
		    out.print("<input type='submit' value='go'>");  
		    out.print("</form>");  
		          
		    out.close();  
	}

}
