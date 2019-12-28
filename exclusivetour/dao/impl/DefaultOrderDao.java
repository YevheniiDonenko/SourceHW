package exclusivetour.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exclusivetour.dao.OrderDao;
import exclusivetour.dbunits.DbHelper;
import exclusivetour.models.OrderData;

public class DefaultOrderDao implements OrderDao {
	public static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id=?";
	private static final String SELECT_ORDERS_BY_USER = "SELECT o.order_id, o.tour_id, o.user_id "
			+ "FROM orders o \r\n" + "JOIN user u ON o.user_id = u.user_id\r\n" + "WHERE u.user_id = ?";
	private static final String SET_ORDER = "INSERT INTO orders (user_id, tour_id, number_of_person)"
			+ "VALUES (?, ?, ?);";
	private static final String UPDATE_ORDER = "UPDATE orders user_id = ?, tour_id = ?, number_of_person=? WHERE order_id=?";
	public static final String SELECT_ALL_ORDERS = "SELECT order_id, user_id, tour_id FROM orders";

	private static DefaultOrderDao instance;
	private DbHelper dbHelper;

	private DefaultOrderDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static OrderDao getInstance() {
		if (instance == null) {
			instance = new DefaultOrderDao();
		}
		return instance;
	}

	@Override
	public OrderData getOrderById(int orderId) {
		try {
			OrderData orderData = null;
			try (Connection connection = dbHelper.getConnection();
					PreparedStatement statement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
				statement.setInt(1, orderId);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						orderData = new OrderData();
						orderData.setOrderId(rs.getInt("order_id"));
						orderData.setUserId(rs.getInt("user_id"));
						orderData.setTourId(rs.getInt("tour_id"));
						orderData.setNumberOfPerson(rs.getInt("number_of_person"));
					}
				}
			}
			return orderData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<OrderData> getAllOrders() {
		List<OrderData> orders = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ORDERS)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setOrderId(rs.getInt("order_id"));
				orderData.setUserId(rs.getInt("user_id"));
				orderData.setTourId(rs.getInt("tour_id"));
				orderData.setNumberOfPerson(rs.getInt("number_of_person"));
				orders.add(orderData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return orders;
	}

	@Override
	public List<OrderData> getUserOrders(int userId) {
		List<OrderData> orders = new ArrayList<OrderData>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_ORDERS_BY_USER)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setOrderId(rs.getInt("order_id"));
				orderData.setUserId(rs.getInt("user_id"));
				orderData.setTourId(rs.getInt("tour_id"));
				orderData.setNumberOfPerson(rs.getInt("number_of_person"));
				orders.add(orderData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return orders;
	}

	@Override
	public boolean setOrder(int userId, int tourId, int numberOfPerson) {
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SET_ORDER)) {
			statement.setInt(1, userId);
			statement.setInt(2, tourId);
			statement.setInt(3, numberOfPerson);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOrder(int orderId, int userId, int tourId, int numberOfPerson) {
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER)) {
			statement.setInt(1, orderId);
			statement.setInt(2, userId);
			statement.setInt(3, tourId);
			statement.setInt(4, numberOfPerson);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
