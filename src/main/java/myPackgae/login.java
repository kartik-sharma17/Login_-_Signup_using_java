package myPackgae;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		doGet(request, response);
		
		String user_name  = request.getParameter("login_email");
		String password  = request.getParameter("password");
		
		
//		making connection to database 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
			
			PreparedStatement st = con.prepareStatement("Select * from data where email = ? and password = ?;");
			st.setString(1,user_name);
			st.setString(2,password);
			
			ResultSet res = st.executeQuery();
			
			if(res.next()) {
				request.setAttribute("login","success");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			else {
				request.setAttribute("login","failure");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}

		
		
		
		
		
		
		
		
		
		
	}

}
