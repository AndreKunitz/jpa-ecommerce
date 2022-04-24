package me.github.andrekunitz.ecommerce.basicmapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Order;
import me.github.andrekunitz.ecommerce.model.OrderDeliveryAddress;
import me.github.andrekunitz.ecommerce.model.OrderStatus;

public class EmbeddedObjectTest extends EntityManagerTest {

	@Test
	public void analyseEmbeddedObject() {
		OrderDeliveryAddress address = new OrderDeliveryAddress();
		address.setPostalCode("00000-000");
		address.setStreet("XXX st.");
		address.setNumber("123");
		address.setNeighborhood("Downtown");
		address.setCity("New York");
		address.setState("NY");

		Order order = new Order();
		order.setOrderDate(LocalDateTime.now());
		order.setStatus(OrderStatus.AWAITING);
		order.setTotal(new BigDecimal(1000));
		order.setDeliveryAddress(address);

		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Order orderVerification = entityManager.find(Order.class, order.getId());
		Assert.assertNotNull(orderVerification);
		Assert.assertNotNull(orderVerification.getDeliveryAddress());
		Assert.assertNotNull(orderVerification.getDeliveryAddress().getPostalCode());
	}
}
