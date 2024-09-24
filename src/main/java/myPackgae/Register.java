package myPackgae;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String dob = request.getParameter("dob");
		String password = request.getParameter("password");
		
//		making the connection to database 
		String url = "jdbc:mysql://localhost:3306/register";
		String user = "root";
		String pass = "";
		
		
		try {
	
//		loading the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			connection to database 
			Connection con = DriverManager.getConnection(url,user,pass);
			
			PreparedStatement st = con.prepareStatement("INSERT INTO `data`(`name`, `email`, `number`, `bod`, `password`) VALUES (?,?,?,?,?);");
			st.setString(1,name);
			st.setString(2,email);
			st.setString(3,number);
			st.setString(4,dob);
			st.setString(5,password);
			
			int rw = st.executeUpdate();
//			if value return is greater than 0 then it data is inserted successfully otherwise not 
			
			if(rw > 0) {
				request.setAttribute("status","success");
				request.getRequestDispatcher("process.jsp").forward(request,response);
			}
			else {
				request.setAttribute("status","fail");
				request.getRequestDispatcher("process.jsp").forward(request,response);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("error",e);
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
