import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
			req.getRequestDispatcher("login.html").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
		
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		String Email=req.getParameter("email");
		String Password=req.getParameter("password");
		if(DAO.authenticate(Email, Password)) {
			System.out.println("Authenticated");
			try {
				PrintWriter write=res.getWriter();
				write.println("<h1 style=\"text-align: center;\">Welcome "+DAO.getUser(Email)+"</h1>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Wrong Credentials");
			try {
				PrintWriter write=res.getWriter();
				write.println("<h1 style=\"text-align: center;\">Wrong Credentials</h1>");
				write.println("	<form action=\"register\" method=\"get\" style=\"text-align: center;\">\r\n"
						+ "		<button type=\"submit\" style=\"background-color: #0099ff; color: white; padding: 10px 20px; margin: 10px;font-size:16px\">Sign Up</button>\r\n"
						+ "	</form>\r\n"
						+ "	<form action=\"login\" method=\"get\" style=\"text-align: center;\">\r\n"
						+ "		<button type=\"submit\" style=\"background-color: #45a049; color: white; padding: 10px 20px; margin: 10px;font-size:16px\">Try to Log In again</button>\r\n"
						+ "	</form>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
