package hos.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hos.user.model.Doctor;

public class DoctorDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1998Jayamini";
	
	private static final String INSERT_Doctors_SQL = "INSERT INTO doctor" + "  (Did, FullName, Username, Password, Email, Phone, Specialization) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Doctor_BY_ID = "select Did,FullName,Username,Password,Email,Phone,Specialization from doctor where Did =?";
	private static final String SELECT_ALL_Doctors = "select * from doctor";
	private static final String DELETE_Doctors_SQL = "delete from doctor where Did = ?;";
	private static final String UPDATE_Doctors_SQL = "update doctor set FullName = ?,Username= ?, Password =?, Email =?, Phone =?, Specialization =? where Did = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//create doctor
	
	public void insertUser(Doctor doctor) throws SQLException {
		System.out.println(INSERT_Doctors_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Doctors_SQL)) {
			preparedStatement.setString(1, doctor.getDid());
			preparedStatement.setString(2, doctor.getFullname());
			preparedStatement.setString(3, doctor.getUsername());
			preparedStatement.setString(4, doctor.getPassword());
			preparedStatement.setString(5, doctor.getEmail());
			preparedStatement.setString(6, doctor.getPhone());
			preparedStatement.setString(7, doctor.getSpecialization());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update doctor
	
	public boolean updateUser(Doctor doctor) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Doctors_SQL);) {
			statement.setString(7, doctor.getDid());
			statement.setString(1, doctor.getFullname());
			statement.setString(2, doctor.getUsername());
			statement.setString(3, doctor.getPassword());
			statement.setString(4, doctor.getEmail());
			statement.setString(5, doctor.getPhone());
			statement.setString(6, doctor.getSpecialization());
		

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select doc by id
	public Doctor selectDoctor(String Did) {
		Doctor doctor = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Doctor_BY_ID);) {
			preparedStatement.setString(1, Did);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Did1 = rs.getString("Did");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Specialization = rs.getString("Specialization");
				doctor = new Doctor(Did1, Fullname, Username, Password, Email, Phone,Specialization);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
	//select doctors
	
	public List<Doctor> selectAllDoctors() {
		
		 List<Doctor> doctor = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Doctors);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Did =rs.getString("Did");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Specialization = rs.getString("Specialization");
				doctor.add( new Doctor(Did, Fullname, Username, Password, Email, Phone,Specialization));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
	//delete user
	
	public boolean deleteDoctor(String Did) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Doctors_SQL);	){
			statement.setString(1, Did);
			rowDeleted = statement.executeUpdate() > 0 ;
		}
		
		return rowDeleted;
	}
	
}
