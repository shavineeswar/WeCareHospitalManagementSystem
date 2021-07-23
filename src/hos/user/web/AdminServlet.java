package hos.user.web;


import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hos.user.dao.AdminDAO;
import hos.user.model.Admin;



/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
    	adminDAO =new AdminDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		
		try {
			switch (action) {
			
			case "/anew":
				showAdmNewForm(request, response);
				break;
			case "/ainsert":
				insertAdmin(request, response);
				break;
			case "/adelete":
				deleteAdmin(request, response);
				break;
			case "/aedit":
				showAdmEditForm(request, response);
				break;
			case "/aupdate":
				updateAdmin(request, response);
				break;	
			case "/alist":
				listAdmin(request, response);
				break;	
		
			}		
				
				
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}
	
	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Admin> listadmin = adminDAO.selectAllAdmin();
		request.setAttribute("listadmin", listadmin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Adminlist.jsp");
		dispatcher.forward(request, response);
	}
	private void showAdmNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminform.jsp");
		dispatcher.forward(request, response);
	}

	private void showAdmEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Aid = request.getParameter("Aid");
		Admin existingAdmin = adminDAO.selectAdmin(Aid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminform.jsp");
		request.setAttribute("admin", existingAdmin);
		dispatcher.forward(request, response);
		
	}
	
	private void insertAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String Aid = request.getParameter("Aid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		
		Admin admin=new Admin(Aid, FullName,Username, Password,Email);
		adminDAO.insertAdmin(admin);
		response.sendRedirect("alist");
		
	}
	
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String Aid = request.getParameter("Aid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		
		Admin admin = new Admin(Aid, FullName, Username,Password, Email);
		
		adminDAO.updateAdmin(admin);
		response.sendRedirect("alist");
	}
	
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String Aid = request.getParameter("Aid");
		adminDAO.deleteAdmin(Aid);
		response.sendRedirect("alist");

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
