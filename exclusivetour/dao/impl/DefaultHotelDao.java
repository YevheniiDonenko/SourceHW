package exclusivetour.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import exclusivetour.dao.HotelDao;
import exclusivetour.dbunits.DbHelper;
import exclusivetour.models.HotelData;

public class DefaultHotelDao implements HotelDao {
	private static final String GET_HOTEL_BY_CITY = "SELECT h.hotel_id, h.hotel_name, h.hotel_stars FROM hotels h \r\n"
			+ "JOIN  tours t ON t.hotel_id = h.hotel_id\r\n" + "WHERE t.city_id = ?;";
	private static final String GET_HOTEL_BY_NUTRITION = "SELECT h.hotel_id, h.hotel_name, h.hotel_stars h\r\n"
			+ "JOIN nutrition t ON h.nutrition_id = t.nutrition_id\r\n" + "WHERE t.nutrition_id = ?";
	private static final String GET_HOTEL_BY_CITY_AND_STARS = "SELECT h.hotel_id, h.hotel_name, hotel_stars FROM hotels h\r\n"
			+ "JOIN hotels h ON h.hotel_stars = h.hotel_stars\r\n" + "WHERE h.hotel_stars = ?, h.city_id = ? ";

	private static DefaultHotelDao instance;
	private DbHelper dbHelper;

	private DefaultHotelDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static HotelDao getInstance() {
		if (instance == null) {
			instance = new DefaultHotelDao();
		}
		return instance;
	}

	@Override
	public List<HotelData> getHotelsByCity(int cityId) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement ps = connection.prepareStatement(GET_HOTEL_BY_CITY)) {
			ps.setInt(1, cityId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setHotelId(rs.getInt("hotel_id"));
				hotelData.setHotelName(rs.getString("hotel_name"));
				hotelData.setHotelStars(rs.getInt("hotel_stars"));
				hotelData.setCityId(rs.getInt("city_id"));
				hotelData.setCoutryId(rs.getInt("coutry_id"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}

	@Override
	public List<HotelData> getHotelsByNutrition(int nutritionId) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement ps = connection.prepareStatement(GET_HOTEL_BY_NUTRITION)) {
			ps.setInt(1, nutritionId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setHotelId(rs.getInt("hotel_id"));
				hotelData.setHotelName(rs.getString("hotel_name"));
				hotelData.setHotelStars(rs.getInt("hotel_stars"));
				hotelData.setCityId(rs.getInt("city_id"));
				hotelData.setCoutryId(rs.getInt("coutry_id"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}

	@Override
	public List<HotelData> getHotelsByCityAndStars(int cityId, int hotelStars) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection connection = dbHelper.getConnection();
				PreparedStatement ps = connection.prepareStatement(GET_HOTEL_BY_CITY_AND_STARS)) {
			ps.setInt(1, cityId);
			ps.setInt(2, hotelStars);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setHotelId(rs.getInt("hotel_id"));
				hotelData.setHotelName(rs.getString("hotel_name"));
				hotelData.setHotelStars(rs.getInt("hotel_stars"));
				hotelData.setCityId(rs.getInt("city_id"));
				hotelData.setCoutryId(rs.getInt("coutry_id"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}
}
