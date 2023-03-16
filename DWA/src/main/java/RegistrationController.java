import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
			req.getRequestDispatcher("register.html").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		String Name=req.getParameter("name");
		String Phone=req.getParameter("phone");
		String DOB=req.getParameter("DOB");
		String Email=req.getParameter("email");
		String Password=req.getParameter("password");
		
		System.out.println(new User(Name,Phone,DOB,Email,Password));
		
		boolean result=DAO.insert(new User(Name,Phone,DOB,Email,Password));
		
		try {
			PrintWriter write=res.getWriter();
			if(result) {
//				write.println("<h1>User Added</h1>");
				write.println("	<h1 style=\"text-align: center;\">User Added</h1>\r\n"
						+ "<form action=\"login\" method=\"get\" style=\"text-align: center;\">\r\n"
						+ "	<button type=\"submit\" style=\"font-weight: bold; font-size: 1.2em; margin-top: 20px;background-color: #45a049\">Log In</button>\r\n"
						+ "</form>\r\n"
						+ "");
//				req.getRequestDispatcher("login.html").forward(req, res);
			}
			else {
				write.println("<div style=\"text-align: center;\">\r\n"
						+ "    <h1>User with this email "+Email +"Exists</h1>\r\n"
						+ "    <form action=\"login\" method=\"get\">\r\n"
						+ "        <button type=\"submit\" style=\"background-color: #45a049; color: white; padding: 10px 20px; margin: 10px; font-size:18px\">Log In</button>\r\n"
						+ "    </form>\r\n"
						+ "    <form action=\"register\" method=\"get\">\r\n"
						+ "        <button type=\"submit\" style=\"background-color: #0099ff; color: white; padding: 10px 20px; margin: 10px;font-size:18px\">Sign Up using Different Email</button>\r\n"
						+ "    </form>\r\n"
						+ "</div>\r\n"
						+ "");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
	}

}
