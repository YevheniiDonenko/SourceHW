package exclusivetour.dao;

import java.util.List;

import exclusivetour.models.OrderData;

public interface OrderDao {
	OrderData getOrderById(int orderId);

	List<OrderData> getAllOrders();

	List<OrderData> getUserOrders(int userId);

	boolean setOrder(int userId, int tourId, int numberOfPerson);

	boolean updateOrder(int orderId, int userId, int tourId, int numberOfPerson);

}
