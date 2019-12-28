package exclusivetour.models;

import java.util.Date;

public class TourData {
	private int tourId;
	private String tourName;
	private double price;
	private Date departureDate;
	private String departureCity;
	private int days;
	private int countryId;
	private int cityId;
	private int hotelId;
	private int nutritionId;

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getNutritionId() {
		return nutritionId;
	}

	public void setNutritionId(int nutritionId) {
		this.nutritionId = nutritionId;
	}

	@Override
	public String toString() {
		return "TourData [tourId=" + tourId + ", tourName=" + tourName + ", price=" + price + ", departureDate="
				+ departureDate + ", departureCity=" + departureCity + ", days=" + days + ", countryId=" + countryId
				+ ", cityId=" + cityId + ", hotelId=" + hotelId + ", nutritionId=" + nutritionId + "]";
	}

}
