package exclusivetour.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exclusivetour.dao.TourDao;
import exclusivetour.dbunits.DbHelper;
import exclusivetour.models.TourData;

public class DefaultTourDao implements TourDao {

	private static final String GET_TOURS_FOR_USER = "SELECT t.tour_name, t.tour_name, t.price"
			+ " FROM tours t \r\n JOIN orders o ON t.tour_id = o.tour_id\r\n" + "WHERE o.user_id = ?";
	public static final String SELECT_ALL_TOURS = "SELECT tour_id, tour_name, price, departure_city, "
			+ "days, coutry_id, city_id, hotel_id, nutrition_id FROM tours";
	private static final String SET_TOUR = "INSERT INTO tours (name_tour, tour_description,"
			+ "date_tour, price, id_city, id_hotel)" + "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_TOUR = "UPDATE tours tour_name = ?, price = ?, departure_date = ?,"
			+ "departure_city = ?, days = ?, coutry_id = ?, city_id = ?, hotel_id = ?, nutrition_id = ? WHERE tour_id = ?";
	private static final String GET_TOURS_BY_CITY = "SELECT  t.tour_id, t.tour_name,"
			+ " t.price, t.departure_date, t.departure_city, t.days, t.coutry_id, t.city_id, t.hotel_id, t. nutrition_id"
			+ " FROM tours t \r\n JOIN  cities c ON c.city_id = t.city_id\r\n" + "WHERE c.city_id = ?";
	private static final String GET_TOURS_BY_COUNTRY = "SELECT  t.tour_id, t.tour_name,\"\r\n"
			+ "t.price, t.departure_date, t.departure_city, t.days, t.coutry_id, t.city_id, t.hotel_id, t. nutrition_id"
			+ "JOIN  cities c ON c.city_id = t.city_id\r\n" + "JOIN country con ON con.country_id=c.country_id\r\n"
			+ "WHERE con.country_id = ?";
	private static final String SELECT_TOUR_BY_PRICE = "SELECT * FROM tours t \r\n" + "WHERE t.price BETWEEN ? AND ?";
	private static final String GET_TOURS_BY_NUTRITION = "SELECT  t.tour_id, t.tour_name,\"\r\n"
			+ "t.price, t.departure_date, t.departure_city, t.days, t.coutry_id, t.city_id, t.hotel_id, t. nutrition_id"
			+ "JOIN cities c ON c.city_id = t.city_id\r\n" + "JOIN countries con ON con.country_id=c.country_id\r\n"
			+ "JOIN nutrition nut ON nut.nutrition_id=" + "WHERE nut.nutrition_id = ?";

	private static DefaultTourDao instance;
	private DbHelper dbHelper;

	private DefaultTourDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static DefaultTourDao getInstance() {
		if (instance == null) {
			instance = new DefaultTourDao();
		}
		return instance;
	}

	@Override
	public List<TourData> getAllTours() {
		List<TourData> tours = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TOURS)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourId(rs.getInt("tour_id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getDouble("price"));
				tourData.setDepartureDate(rs.getDate("departure_date"));
				tourData.setDepartureCity(rs.getString("departure_city"));
				tourData.setDays(rs.getInt("days"));
				tourData.setCountryId(rs.getInt("coutry_id"));
				tourData.setCityId(rs.getInt("city_id"));
				tourData.setHotelId(rs.getInt("hotel_id"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<TourData> getTourByUser(int userId) {
		List<TourData> tours = new ArrayList<TourData>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement ps = connection.prepareStatement(GET_TOURS_FOR_USER)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourId(rs.getInt("tour_id"));
				tourData.setTourName(rs.getString("tour_name"));
				tours.add(tourData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<TourData> getTourByCity(int cityId) {
		List<TourData> tours = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_TOURS_BY_CITY)) {
			statement.setInt(1, cityId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourId(rs.getInt("tour_id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setDepartureDate(rs.getDate("departure_date"));
				tourData.setDepartureCity(rs.getString("departure_city"));
				tourData.setDays(rs.getInt("date"));
				tourData.setCountryId(rs.getInt("coutry_id"));
				tourData.setHotelId(rs.getInt("hotel_id"));
				tourData.setNutritionId(rs.getInt("nutrition_id"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<TourData> getTourByCoutry(int coutryId) {
		List<TourData> tours = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_TOURS_BY_COUNTRY)) {
			statement.setInt(1, coutryId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourId(rs.getInt("tour_id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setDepartureDate(rs.getDate("departure_date"));
				tourData.setDepartureCity(rs.getString("departure_city"));
				tourData.setDays(rs.getInt("date"));
				tourData.setCountryId(rs.getInt("coutry_d"));
				tourData.setHotelId(rs.getInt("hotel_id"));
				tourData.setNutritionId(rs.getInt("nutrition_id"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<TourData> getTourByNutrition(int nutritionId) {
		List<TourData> tours = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_TOURS_BY_NUTRITION)) {
			statement.setInt(1, nutritionId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourId(rs.getInt("tour_id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setDepartureDate(rs.getDate("departure_date"));
				tourData.setDepartureCity(rs.getString("departure_city"));
				tourData.setDays(rs.getInt("date"));
				tourData.setCountryId(rs.getInt("coutry_id"));
				tourData.setHotelId(rs.getInt("hotel_id"));
				tourData.setNutritionId(rs.getInt("nutrition_id"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<TourData> getTourByPrice(double minPrice, double maxPrice) {
		List<TourData> tours = new ArrayList<>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_TOUR_BY_PRICE)) {
			statement.setDouble(1, minPrice);
			statement.setDouble(2, maxPrice);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourId(rs.getInt("tour_id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setDepartureDate(rs.getDate("departure_date"));
				tourData.setDepartureCity(rs.getString("departure_city"));
				tourData.setDays(rs.getInt("date"));
				tourData.setCountryId(rs.getInt("coutry_id"));
				tourData.setHotelId(rs.getInt("hotel_id"));
				tourData.setNutritionId(rs.getInt("nutrition_id"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public boolean setTour(String tourName, double tourPrice, Date departureDate, String departureCity, int days,
			int coutryId, int cityId, int hotelId, int nutritionId) {
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(SET_TOUR)) {
			statement.setString(1, tourName);
			statement.setDouble(2, tourPrice);
			statement.setDate(3, departureDate);
			statement.setString(4, departureCity);
			statement.setInt(5, days);
			statement.setInt(6, coutryId);
			statement.setInt(7, cityId);
			statement.setInt(8, hotelId);
			statement.setInt(9, nutritionId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTour(int id, String tourName, double tourPrice, Date departureDate, String departureCity,
			int days, int coutryId, int cityId, int hotelId, int nutritionId) {
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TOUR)) {
			statement.setInt(1, id);
			statement.setString(2, tourName);
			statement.setDouble(3, tourPrice);
			statement.setDate(4, departureDate);
			statement.setString(5, departureCity);
			statement.setInt(6, days);
			statement.setInt(7, coutryId);
			statement.setInt(8, cityId);
			statement.setInt(9, hotelId);
			statement.setInt(10, nutritionId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
