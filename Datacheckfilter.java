package Phase2_servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Datacheckfilter
 */
@WebFilter("/Datacheckfilter")
public class Datacheckfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Datacheckfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		PrintWriter out=response.getWriter();
		String name1=request.getParameter("name");
		String age1=request.getParameter("age");
		
		if(name1.equals("admin")&&age1.equals("30"))
		{
			out.println("\nDatachecker passed to servlet");
		chain.doFilter(request, response);
		}
		else{
			out.println("\nDatachecker blocks because name and age are not valid");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
