package hos.user.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hos.user.dao.DoctorDAO;
import hos.user.model.Doctor;

import hos.user.dao.AdminDAO;
import hos.user.model.Admin;

import hos.user.dao.NurseDAO;
import hos.user.model.Nurse;

import hos.user.dao.AccountantDAO;
import hos.user.model.Accountant;

import hos.user.dao.LaboratoristDAO;
import hos.user.model.Laboratorist;

import hos.user.dao.PharmacistDAO;
import hos.user.model.Pharmacist;

import hos.user.dao.ReceptionistDAO;
import hos.user.model.Receptionist;

import hos.user.model.LoginBean;
import hos.user.dao.ALoginDAO;
import hos.user.dao.NurseloginDAO;
import hos.user.dao.*;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DoctorDAO doctorDAO;
       private AdminDAO adminDAO;
       private NurseDAO nurseDAO;
       private AccountantDAO accountantDAO;
       private LaboratoristDAO laboratoristDAO;
       private PharmacistDAO pharmacistDAO;
       private ReceptionistDAO receptionistDAO;
       private ALoginDAO loginDao;
       private NurseloginDAO nurseloginDAO;
       private PharmacistloginDAO pharmacistloginDAO;
       private LaboratoristloginDAO laboratoristloginDAO;
       private ReceptionistloginDAO receptionistloginDAO;
       private AccountantloginDAO accountantloginDAO;
       public void init() {
    	   doctorDAO = new DoctorDAO();
    	   adminDAO = new AdminDAO();
    	   nurseDAO = new NurseDAO();
    	   accountantDAO = new AccountantDAO();
    	   laboratoristDAO = new LaboratoristDAO();
    	   pharmacistDAO = new PharmacistDAO();
    	   receptionistDAO = new ReceptionistDAO();
    	   loginDao = new ALoginDAO();
    	   nurseloginDAO = new NurseloginDAO();
    	   pharmacistloginDAO = new PharmacistloginDAO();
    	   laboratoristloginDAO = new LaboratoristloginDAO();
    	   receptionistloginDAO = new ReceptionistloginDAO();
    	   accountantloginDAO = new AccountantloginDAO();
   	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewDocform(request,response);
			break;
		case "/insert":
			try {
				insertDoctor(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteDoctor(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/edit":
			try {
				showEditDocForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateDoctor(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/list":
			try {
				listDoctor(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		
		case "/anew":
			showNewAdminform(request,response);
			break;
		case "/ainsert":
			try {
				insertAdmin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/adelete":
			try {
				deleteAdmin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/aedit":
			try {
				showAdminEditForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/aupdate":
			try {
				updateAdmin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/alist":
			try {
				listAdmin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		
			
		case "/newnurse":
			showNewNurseform(request,response);
			break;
		case "/insertnurse":
			try {
				insertNurse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deletenurse":
			try {
				deleteNurse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/editnurse":
			try {
				showNurseEditForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/updatenurse":
			try {
				updateNurse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/listnurse":
			try {
				listNurse(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
			
			
		case "/newacc":
			showNewAccform(request,response);
			break;
		case "/insertacc":
			try {
				insertAccountant(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteacc":
			try {
				deleteAccountant(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/editacc":
			try {
				showEditAccForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/updateacc":
			try {
				updateAccountant(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/listacc":
			try {
				listAccountant(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case "/newlab":
			showNewLabform(request,response);
			break;
		case "/insertlab":
			try {
				insertLaboratorist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deletelab":
			try {
				deleteLaboratorist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/editlab":
			try {
				showEditLabForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/updatelab":
			try {
				updateLaboratorist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/listlab":
			try {
				listLaboratorist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		
			
			
		case "/newph":
			showNewPharmacistform(request,response);
			break;
		case "/insertph":
			try {
				insertPharmacist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteph":
			try {
				deletePharmacist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/editph":
			try {
				showEditPharmacistForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/updateph":
			try {
				updatePharmacist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/listph":
			try {
				listPharmacist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
			
			
		case "/newrec":
			showNewReceptionistform(request,response);
			break;
		case "/insertrec":
			try {
				insertReceptionist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleterec":
			try {
				deleteReceptionist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/editrec":
			try {
				showEditReceptionistForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/updaterec":
			try {
				updateReceptionist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/listrec":
			try {
				listReceptionist(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "/adminlog":
			try {
				adminlogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case "/nurselog":
			try {
				nurselogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/acclog":
			try {
				Accountantlogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/lablog":
			try {
				Labologin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/phlog":
			try {
				pharlogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/relog":
			try {
				Reclogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}
	
	private void listDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Doctor> listDoctor = doctorDAO.selectAllDoctors();
		request.setAttribute("listDoctor", listDoctor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Alist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewDocform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Docform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditDocForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Did = request.getParameter("did");
		Doctor existingDoctor = doctorDAO.selectDoctor(Did);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Docform.jsp");
		request.setAttribute("doctor", existingDoctor);
		dispatcher.forward(request, response);

	}
	
	private void insertDoctor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String Did = request.getParameter("Did");
		String Fullname = request.getParameter("Fullname");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Specialization = request.getParameter("Specialization");
		
		
		Doctor newDoctor = new Doctor(Did,Fullname,Username,Password,Email,Phone,Specialization);
		
		doctorDAO.insertUser(newDoctor);
		
		response.sendRedirect("list");
		
		
	}
	
	private void updateDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Did = request.getParameter("Did");
		String Fullname = request.getParameter("Fullname");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Specialization = request.getParameter("Specialization");
		
		
		Doctor doctor = new Doctor(Did,Fullname,Username,Password,Email,Phone,Specialization);
		
		doctorDAO.updateUser(doctor);
		
		response.sendRedirect("list");
		
		
	}

	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Did = request.getParameter("did");
				
		doctorDAO.deleteDoctor(Did);
		response.sendRedirect("list");
		
	}
	
	/**
	 * Servlet implementation for Admin
	 */
	
	
	

	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Admin> listadmin = adminDAO.selectAllAdmin();
		request.setAttribute("listadmin", listadmin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Adminlist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewAdminform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showAdminEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Aid = request.getParameter("aid");
		Admin existingAdmin = adminDAO.selectAdmin(Aid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminform.jsp");
		request.setAttribute("admin", existingAdmin);
		dispatcher.forward(request, response);
	}
	
	private void insertAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
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
		
		String Aid = request.getParameter("aid");
		adminDAO.deleteAdmin(Aid);
		response.sendRedirect("alist");
		
	}
	
	
	/**
	 * Servlet implementation for nurse
	 */
	
	
	private void listNurse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Nurse> listNurse = nurseDAO.selectAllNurse();
		request.setAttribute("listNurse", listNurse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Nurselist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewNurseform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Nurseform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showNurseEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Nid = request.getParameter("nid");
		Nurse existingNurse = nurseDAO.selectNurse(Nid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Nurseform.jsp");
		request.setAttribute("nurse", existingNurse);
		dispatcher.forward(request, response);

	}
	
	private void insertNurse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String Nid = request.getParameter("Nid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Department = request.getParameter("Department");
		String Position = request.getParameter("Position");
		
		Nurse newNurse = new Nurse(Nid,FullName,Username,Password,Email,Phone,Department,Position);
		
		nurseDAO.insertNurse(newNurse);
		
		response.sendRedirect("listnurse");
		
		
	}
	
	private void updateNurse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Nid = request.getParameter("Nid");
		String Fullname = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Department = request.getParameter("Department");
		String Position = request.getParameter("Position");
		
		Nurse nurse = new Nurse(Nid,Fullname,Username,Password,Email,Phone,Department,Position);
		
		nurseDAO.updateNurse(nurse);
		
		response.sendRedirect("listnurse");
		
		
	}

	private void deleteNurse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Nid = request.getParameter("nid");
				
		nurseDAO.deleteNurse(Nid);
		response.sendRedirect("listnurse");
		
	}
	

	/**
	 * Servlet implementation for Accountant
	 */
	
	private void listAccountant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Accountant> listAccountant = accountantDAO.selectAllAccountant();
		request.setAttribute("listAccountant", listAccountant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Accountantlist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewAccform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Accountantform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditAccForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Aid = request.getParameter("aid");
		Accountant existingAccountant = accountantDAO.selectAccountant(Aid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Accountantform.jsp");
		request.setAttribute("accountant", existingAccountant);
		dispatcher.forward(request, response);

	}
	
	private void insertAccountant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String Aid = request.getParameter("Aid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Accountant newAccountant = new Accountant(Aid,FullName,Username,Password,Email,Phone,Position);
		
		accountantDAO.insertAccountant(newAccountant);
		
		response.sendRedirect("listacc");
		
		
	}
	
	private void updateAccountant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Aid = request.getParameter("Aid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Accountant accountant = new Accountant(Aid,FullName,Username,Password,Email,Phone,Position);
		
		accountantDAO.updateAccountant(accountant);
		
		response.sendRedirect("listacc");
		
		
	}

	private void deleteAccountant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Aid = request.getParameter("aid");
				
		accountantDAO.deleteAccountant(Aid);
		response.sendRedirect("listacc");
		
	}
	
	
	/**
	 * Servlet implementation for Laboratorist
	 */
	
	private void listLaboratorist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Laboratorist> listlaboratorist = laboratoristDAO.selectAllLaboratorist();
		request.setAttribute("listlaboratorist", listlaboratorist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Laboratoristlist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewLabform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Laboratoristform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditLabForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Lid = request.getParameter("lid");
		Laboratorist existingLaboratorist = laboratoristDAO.selectLaboratorist(Lid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Laboratoristform.jsp");
		request.setAttribute("laboratorist", existingLaboratorist);
		dispatcher.forward(request, response);

	}
	
	private void insertLaboratorist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String Lid = request.getParameter("Lid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Laboratorist newLaboratorist = new Laboratorist(Lid,FullName,Username,Password,Email,Phone,Position);
		
		laboratoristDAO.insertLaboratorist(newLaboratorist);
		response.sendRedirect("listlab");
		
		
	}
	
	private void updateLaboratorist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Lid = request.getParameter("Lid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Laboratorist laboratorist = new Laboratorist(Lid,FullName,Username,Password,Email,Phone,Position);
		
		laboratoristDAO.updateLaboratorist(laboratorist);
		response.sendRedirect("listlab");
		
		
	}

	private void deleteLaboratorist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Lid = request.getParameter("lid");
			
		laboratoristDAO.deleteLaboratorist(Lid);
	
		response.sendRedirect("listlab");
		
	}
	

	/**
	 * Servlet implementation for Pharmacist
	 */
	
	private void listPharmacist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Pharmacist> listPharmacist =  pharmacistDAO.selectAllPharmacist();
		request.setAttribute("listPharmacist", listPharmacist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pharmacistlist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewPharmacistform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pharmacistform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditPharmacistForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String PHid = request.getParameter("pHid");
		Pharmacist existingPharmacist =  pharmacistDAO.selectPharmacist(PHid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pharmacistform.jsp");
		request.setAttribute("pharmacist", existingPharmacist);
		dispatcher.forward(request, response);

	}
	
	private void insertPharmacist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String PHid = request.getParameter("PHid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Pharmacist newPharmacist = new Pharmacist(PHid,FullName,Username,Password,Email,Phone,Position);
		
		pharmacistDAO.insertPharmacist(newPharmacist);
		response.sendRedirect("listph");
		
		
	}
	
	private void updatePharmacist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String PHid = request.getParameter("PHid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Pharmacist pharmacist = new Pharmacist(PHid,FullName,Username,Password,Email,Phone,Position);
		
		pharmacistDAO.updatePharmacist(pharmacist);
		
		response.sendRedirect("listph");
		
		
	}

	private void deletePharmacist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String PHid = request.getParameter("pHid");
				
	
		pharmacistDAO.deletePharmacist(PHid);
		
		response.sendRedirect("listph");
		
	}
	
	
	/**
	 * Servlet implementation for Receptionist
	 */
	
	private void listReceptionist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Receptionist> listReceptionist = receptionistDAO.selectAllReceptionist();
		request.setAttribute("listReceptionist", listReceptionist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Receptionistlist.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewReceptionistform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Receptionistform.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditReceptionistForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String Rid = request.getParameter("rid");
		Receptionist existingReceptionist = receptionistDAO.selectReceptionist(Rid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Receptionistform.jsp");
		request.setAttribute("receptionist", existingReceptionist);
		dispatcher.forward(request, response);

	}
	
	private void insertReceptionist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String Rid = request.getParameter("Rid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Receptionist newReceptionist = new Receptionist(Rid,FullName,Username,Password,Email,Phone,Position);
		
		receptionistDAO.insertReceptionist(newReceptionist);
		
		response.sendRedirect("listrec");
		
		
	}
	
	private void updateReceptionist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Rid = request.getParameter("Rid");
		String FullName = request.getParameter("FullName");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Position = request.getParameter("Position");
		
		
		Receptionist receptionist = new Receptionist(Rid,FullName,Username,Password,Email,Phone,Position);
		
		receptionistDAO.updateReceptionist(receptionist);
		
		response.sendRedirect("listrec");
		
		
	}

	private void deleteReceptionist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String Rid = request.getParameter("rid");
				
		receptionistDAO.deleteReceptionist(Rid);
		
		response.sendRedirect("listrec");
		
	}
	
	
	private void adminlogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (loginDao.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("alist");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Ivalidlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private void nurselogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (nurseloginDAO.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("Success.jsp");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Adminlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void Accountantlogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (accountantloginDAO.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("Success.jsp");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Adminlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void Labologin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (laboratoristloginDAO.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("Success.jsp");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Adminlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void pharlogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (pharmacistloginDAO.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("Success.jsp");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Adminlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void Reclogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (receptionistloginDAO.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("Success.jsp");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Adminlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
