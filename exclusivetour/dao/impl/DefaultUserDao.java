package exclusivetour.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exclusivetour.dbunits.DbHelper;
import exclusivetour.models.UserData;
import exclusivetour.dao.UserDao;

public class DefaultUserDao implements UserDao {
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
	private static final String SELECT_ALL_USERS = "SELECT user_id, login, password, first_name, last_name, age, email, phone, role_id FROM users";
	private static final String SELECT_CLIENT = "SELECT u.user_id, u.first_name, u.last_name " + "FROM users u \r\n"
			+ "JOIN role r ON r.role_id=u.role_id WHERE r.role_id = 1;";
	private static final String SET_USER = "INSERT INTO users (login, password, first_name"
			+ "last_name, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_USER = "UPDATE users login = ?, password = ?, "
			+ "first_name = ?, last_name = ?, age = ?, email = ?, phone = ?, role_id = ? WHERE user_id = ?";
	private static DefaultUserDao instance;
	private DbHelper dbHelper;

	private DefaultUserDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static UserDao getInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	@Override
	public UserData getUserById(int id) {
		try {
			UserData userData = null;
			try (Connection connection = dbHelper.getConnection();
					PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)) {
				statement.setInt(1, id);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						userData = new UserData();
						userData.setId(rs.getInt("user_id"));
						userData.setLogin(rs.getString("login"));
						userData.setPassword(rs.getString("password"));
						userData.setFirstName(rs.getString("first_name"));
						userData.setLastName(rs.getString("last_name"));
						userData.setAge(rs.getInt("age"));
						userData.setEmail(rs.getString("email"));
						userData.setPhone(rs.getLong("phone"));
						userData.setRole(rs.getInt("role_id"));
					}
				}
			}
			return userData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<UserData> getAllUsers() {
		List<UserData> users = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS)) {

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				UserData userData = new UserData();
				userData.setId(rs.getInt("user_id"));
				userData.setFirstName(rs.getString("first_name"));
				userData.setLastName(rs.getString("last_name"));
				userData.setAge(rs.getInt("age"));
				userData.setEmail(rs.getString("email"));
				userData.setPhone(rs.getLong("phone"));
				users.add(userData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return users;
	}

	@Override
	public List<UserData> getClient() {
		List<UserData> users = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				UserData userData = new UserData();
				userData.setId(rs.getInt("user_id"));
				userData.setFirstName(rs.getString("first_name"));
				userData.setLastName(rs.getString("last_name"));
				users.add(userData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return users;
	}

	@Override
	public boolean updateUser(int id, String login, String password, String firstName, String lastName, int age,
			String email, long phone, int roleId) {
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
			statement.setInt(1, id);
			statement.setString(2, login);
			statement.setString(3, password);
			statement.setString(4, firstName);
			statement.setString(5, lastName);
			statement.setInt(6, age);
			statement.setString(7, email);
			statement.setLong(8, phone);
			statement.setInt(9, roleId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean setUser(String login, String password, String firstName, String lastName, int age, String email,
			long phone) {
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SET_USER)) {
			statement.setString(1, login);
			statement.setString(2, password);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setInt(5, age);
			statement.setLong(6, phone);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
