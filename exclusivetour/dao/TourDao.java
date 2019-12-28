package exclusivetour.dao;

import java.sql.Date;
import java.util.List;

import exclusivetour.models.TourData;

public interface TourDao {
	List<TourData> getAllTours();
	List<TourData> getTourByUser(int userId);	
	List<TourData> getTourByCity(int cityId);
	List<TourData> getTourByCoutry(int coutryId);
	List<TourData> getTourByNutrition(int nutritionId);
	List<TourData> getTourByPrice(double minPrice, double maxPrice);
	
	boolean setTour(String tourName, double tourPrice, Date departureDate,
			String departureCity, int days, int coutryId, int cityId,
			int hotelId, int nutritionId);
	
	boolean updateTour(int id, String tourName, double tourPrice, Date departureDate,
			String departureCity, int days, int coutryId, int cityId,
			int hotelId, int nutritionId);
	
}
