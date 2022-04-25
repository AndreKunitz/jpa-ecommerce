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

public class RemoveEntityWithRelationshipTest extends EntityManagerTest {

	@Test
	public void removeRelatedEntity() {
		Order order = entityManager.find(Order.class, 1);

		Assert.assertFalse(order.getLineItems().isEmpty());

		entityManager.getTransaction().begin();
		order.getLineItems().forEach(i -> entityManager.remove(i));
		entityManager.remove(order);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Order orderVerification = entityManager.find(Order.class, 1);
		Assert.assertNull(orderVerification);
	}

}
