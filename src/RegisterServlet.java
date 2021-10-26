

import datamodel.User;
import util.UtilDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		response.setContentType("text/html");

		if (UtilDB.lookupUser(userName).size() > 0) {
			userRegistrationFailed(response.getWriter(), userName);
		}
		else {
			UtilDB.createUser(userName, userPass);
			userRegistrationSuccess(response.getWriter(), userName);
		}
	}

	void userRegistrationSuccess(PrintWriter out, String userName) {
		String title = "User Registered";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
				"transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<ul>");
		User registeredUser = UtilDB.lookupUser(userName).get(0);
		System.out.println("[DBG] " + registeredUser.getId() + ", " //
				+ registeredUser.getUserName() + ", "
				+ registeredUser.getUserPass());

		out.println("<li>" + registeredUser.getId() + ", " //
				+ registeredUser.getUserName() + ", " //
				+ registeredUser.getUserPass() + "</li>");
		out.println("</ul>");
		out.println("<a href=\"/login.html\">Login</a> <br>");
		out.println("</body></html>");
	}

	void userRegistrationFailed(PrintWriter out, String userName) {
		String title = "Username: \"" + userName + "\" is Already Taken";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
				"transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<a href=\"/register.html\">Register</a> <br>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
