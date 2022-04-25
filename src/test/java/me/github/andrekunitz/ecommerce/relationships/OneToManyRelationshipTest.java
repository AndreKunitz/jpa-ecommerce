package me.github.andrekunitz.ecommerce.relationships;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Client;
import me.github.andrekunitz.ecommerce.model.Order;
import me.github.andrekunitz.ecommerce.model.OrderLineItem;
import me.github.andrekunitz.ecommerce.model.OrderStatus;
import me.github.andrekunitz.ecommerce.model.Product;

public class OneToManyRelationshipTest extends EntityManagerTest {

	@Test
	public void verifyRelationship() {
		Client client = entityManager.find(Client.class, 1);

		Order order = new Order();
		order.setStatus(OrderStatus.AWAITING);
		order.setOrderDate(LocalDateTime.now());
		order.setTotal(BigDecimal.TEN);

		order.setClient(client);

		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Client clientVerification = entityManager.find(Client.class, order.getId());
		Assert.assertFalse(clientVerification.getOrders().isEmpty());
	}

	@Test
	public void verifyOrderLineItemOneToManyRelationship() {
		Client client = entityManager.find(Client.class, 1);
		Product product = entityManager.find(Product.class, 1);

		Order order = new Order();
		order.setStatus(OrderStatus.AWAITING);
		order.setOrderDate(LocalDateTime.now());
		order.setTotal(BigDecimal.TEN);
		order.setClient(client);

		OrderLineItem orderLineItem = new OrderLineItem();
		orderLineItem.setProductPrice(product.getPrice());
		orderLineItem.setQuantity(1);
		orderLineItem.setOrder(order);
		orderLineItem.setProduct(product);

		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.persist(orderLineItem);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Order orderOneToManyVerification = entityManager.find(Order.class, order.getId());
		Assert.assertFalse(orderOneToManyVerification.getLineItems().isEmpty());
	}
}
