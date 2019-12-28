package exclusivetour.models;

public class CoutryData {
	private int coutryId;
	private int coutryName;

	public int getCoutryId() {
		return coutryId;
	}

	public void setCoutryId(int coutryId) {
		this.coutryId = coutryId;
	}

	public int getCoutryName() {
		return coutryName;
	}

	public void setCoutryName(int coutryName) {
		this.coutryName = coutryName;
	}

	@Override
	public String toString() {
		return "CoutryData [coutryId=" + coutryId + ", coutryName=" + coutryName + "]";
	}
}
