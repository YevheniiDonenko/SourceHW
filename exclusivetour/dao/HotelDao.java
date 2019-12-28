package exclusivetour.dao;

import java.util.List;

import exclusivetour.models.HotelData;

public interface HotelDao {
	List<HotelData> getHotelsByCity(int cityId);
	List<HotelData> getHotelsByNutrition(int nutritionId);
	List<HotelData> getHotelsByCityAndStars(int cityId, int hotelStars);
	
}
