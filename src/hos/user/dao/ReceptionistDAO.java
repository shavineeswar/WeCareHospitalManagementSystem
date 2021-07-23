package hos.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import hos.user.model.Receptionist;

public class ReceptionistDAO {


	private String jdbcURL = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1998Jayamini";
	
	private static final String INSERT_Receptionist_SQL = "INSERT INTO Receptionist" + "  (Rid, FullName, Username, Password, Email, Phone, Position) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Receptionist_BY_ID = "select Rid,FullName,Username,Password,Email,Phone,Position from Receptionist where Rid =?";
	private static final String SELECT_ALL_Receptionist = "select * from Receptionist";
	private static final String DELETE_Receptionist_SQL = "delete from Receptionist where Rid = ?;";
	private static final String UPDATE_Receptionist_SQL = "update Receptionist set FullName = ?,Username= ?, Password =?, Email =?, Phone =?, Position =? where Rid = ?;";
	
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
	
	public void insertReceptionist(Receptionist receptionist) throws SQLException {
		System.out.println(INSERT_Receptionist_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Receptionist_SQL)) {
			preparedStatement.setString(1, receptionist.getRid());
			preparedStatement.setString(2, receptionist.getFullName());
			preparedStatement.setString(3, receptionist.getUsername());
			preparedStatement.setString(4, receptionist.getPassword());
			preparedStatement.setString(5, receptionist.getEmail());
			preparedStatement.setString(6, receptionist.getPhone());
			preparedStatement.setString(7, receptionist.getPosition());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update doctor
	
	public boolean updateReceptionist(Receptionist receptionist) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Receptionist_SQL);) {
			statement.setString(7, receptionist.getRid());
			statement.setString(1, receptionist.getFullName());
			statement.setString(2, receptionist.getUsername());
			statement.setString(3, receptionist.getPassword());
			statement.setString(4, receptionist.getEmail());
			statement.setString(5, receptionist.getPhone());
			statement.setString(6, receptionist.getPosition());
		

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select doc by id
	public Receptionist selectReceptionist(String Rid) {
		Receptionist receptionist = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Receptionist_BY_ID);) {
			preparedStatement.setString(1, Rid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Rid1 = rs.getString("Rid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				receptionist = new Receptionist(Rid1, Fullname, Username, Password, Email, Phone,Position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return receptionist;
	}
	
	//select doctors
	
	public List<Receptionist> selectAllReceptionist() {
		
		 List<Receptionist> receptionist = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Receptionist);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Rid =rs.getString("Rid");
				String Fullname = rs.getString("FullName");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Phone = rs.getString("Phone");
				String Position = rs.getString("Position");
				receptionist.add( new Receptionist(Rid, Fullname, Username, Password, Email, Phone,Position));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return receptionist;
	}
	
	//delete user
	
	public boolean deleteReceptionist(String Rid) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Receptionist_SQL);	){
			statement.setString(1, Rid);
			rowDeleted = statement.executeUpdate() > 0 ;
		}
		
		return rowDeleted;
	}
	
	
	
}
