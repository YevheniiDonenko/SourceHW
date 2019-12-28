package exclusivetour.models;

public class CityData {
	private int cityId;
	private String cityName;
	private int countryId;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "CityData [cityId=" + cityId + ", cityName=" + cityName + ", countryId=" + countryId + "]";
	}
}
