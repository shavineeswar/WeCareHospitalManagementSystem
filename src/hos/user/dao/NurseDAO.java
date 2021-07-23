package hos.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import hos.user.model.Nurse;

public class NurseDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1998Jayamini";
	
	private static final String INSERT_Nurse_SQL = "INSERT INTO Nurse" + "  (Nid, FullName, Username, Password, Email, Phone, Department, Position ) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Nurse_BY_ID = "select Nid,FullName,Username,Password,Email,Phone,Department,Position from Nurse where Nid =?";
	private static final String SELECT_ALL_Nurse = "select * from Nurse";
	private static final String DELETE_Nurse_SQL = "delete from Nurse where Nid = ?;";
	private static final String UPDATE_Nurse_SQL = "update Nurse set FullName = ?,Username= ?, Password =?, Email =?, Phone =?, Department =?, Position =? where Nid = ?;";
	
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
	
	public void insertNurse(Nurse nurse) throws SQLException {
		System.out.println(INSERT_Nurse_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Nurse_SQL)) {
			preparedStatement.setString(1, nurse.getNid());
			preparedStatement.setString(2, nurse.getFullName());
			preparedStatement.setString(3, nurse.getUsername());
			preparedStatement.setString(4, nurse.getPassword());
			preparedStatement.setString(5, nurse.getEmail());
			preparedStatement.setString(6, nurse.getPhone());
			preparedStatement.setString(7, nurse.getDepartment());
			preparedStatement.setString(8, nurse.getPosition());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update doctor
	
	public boolean updateNurse(Nurse nurse) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Nurse_SQL);) {
			statement.setString(8, nurse.getNid());
			statement.setString(1, nurse.getFullName());
			statement.setString(2, nurse.getUsername());
			statement.setString(3, nurse.getPassword());
			statement.setString(4, nurse.getEmail());
			statement.setString(5, nurse.getPhone());
			statement.setString(6, nurse.getDepartment());
			statement.setString(7, nurse.getPosition());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select doc by id
	public Nurse selectNurse(String Nid) {
		Nurse nurse = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Nurse_BY_ID);) {
			preparedStatement.setString(1, Nid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Nid1 = rs.getString("Nid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Department = rs.getString("Department");
				String Position = rs.getString("Position");
			
				nurse = new Nurse(Nid1, Fullname, Username, Password, Email, Phone,Department,Position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nurse;
	}
	
	//select doctors
	
	public List<Nurse> selectAllNurse() {
		
		 List<Nurse> nurse = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Nurse);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Nid =rs.getString("Nid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Department = rs.getString("Department");
				String Position = rs.getString("Position");
				nurse.add( new Nurse(Nid, Fullname, Username, Password, Email, Phone,Department,Position));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nurse;
	}
	
	//delete user
	
	public boolean deleteNurse(String Nid) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Nurse_SQL);	){
			statement.setString(1, Nid);
			rowDeleted = statement.executeUpdate() > 0 ;
		}
		
		return rowDeleted;
	}
	
	
	
	
}
