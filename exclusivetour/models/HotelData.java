package exclusivetour.models;

public class HotelData {
	private int hotelId;
	private String hotelName;
	private int hotelStars;
	private int cityId;
	private int coutryId;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCoutryId() {
		return coutryId;
	}

	public void setCoutryId(int coutryId) {
		this.coutryId = coutryId;
	}

	public int getHotelStars() {
		return hotelStars;
	}

	public void setHotelStars(int hotelStars) {
		this.hotelStars = hotelStars;
	}

	@Override
	public String toString() {
		return "HotelData [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelStars=" + hotelStars + ", cityId="
				+ cityId + ", coutryId=" + coutryId + "]";
	}
}
