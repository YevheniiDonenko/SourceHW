package exclusivetour.models;

public class NutritionData {
	private int nutritionId;
	private String nutritionType;

	public int getNutritionId() {
		return nutritionId;
	}

	public void setNutritionId(int nutritionId) {
		this.nutritionId = nutritionId;
	}

	public String getNutritionType() {
		return nutritionType;
	}

	public void setNutritionType(String nutritionType) {
		this.nutritionType = nutritionType;
	}

	@Override
	public String toString() {
		return "NutritionData [nutritionId=" + nutritionId + ", nutritionType=" + nutritionType + "]";
	}

}
