package firstWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().print("User name= "+request.getParameter("name") +" Pass word = "+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if name and pass is wrong show the login page again with msg...
	 * if name is less than 4 chars then add msg and login page
	 * if pass is less than 8 chars then add msg and login page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		if("root".equals(name) && "root".equals(pass)) {
			request.setAttribute("message", "Hi root.. how have you been");
		} else {
		  request.setAttribute("message", "Only root is a valid user");
		}
		
//		String message;
//		if (name.length() < 4 || pass.length() < 8 || !("root".equals(name) && "root".equals(pass))) {
//	        message = "Invalid username or password. Please try again.";
//	        // Set the error message in the request attribute
//	        request.setAttribute("message", message);
//	        // Forward the request back to the login page
//	        request.getRequestDispatcher("login.jsp").forward(request, response);
//	    }  else {
//	        message = "Only root is a valid user";
//	    }
//
	   
		//request.setAttribute("message", message);
		
		request.getRequestDispatcher("loginresults.jsp").forward(request, response);
	}

}
