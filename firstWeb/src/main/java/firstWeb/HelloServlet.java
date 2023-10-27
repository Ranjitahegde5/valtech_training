package firstWeb;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
       
    /**
     * @throws IOException 
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
//    public HelloServlet() throws ServletException, IOException {
//        // TODO Auto-generated constructor stub
//    	doGet(null, null);
//    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	System.out.println("Init of the Hello Servlet");
    	System.out.println("Driver Class = "+config.getInitParameter("driver-class"));
    	System.out.println("Jdbc Url = "+config.getInitParameter("jdbc-url"));
    	System.out.println("Username = "+config.getInitParameter("username"));
    	System.out.println("Password = "+config.getInitParameter("password"));
    	}
    
//    @Override
//    public void destroy() {
//    	// TODO Auto-generated method stub
//    	System.out.println("Destroy of the Hello Servlet="+count);}
//   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
