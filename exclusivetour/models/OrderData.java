package exclusivetour.models;

public class OrderData {
	private int orderId;
	private int userId;
	private int tourId;
	private int numberOfPerson;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	@Override
	public String toString() {
		return "OrderData [orderId=" + orderId + ", userId=" + userId + ", tourId=" + tourId + ", numberOfPerson="
				+ numberOfPerson + "]";
	}
}
