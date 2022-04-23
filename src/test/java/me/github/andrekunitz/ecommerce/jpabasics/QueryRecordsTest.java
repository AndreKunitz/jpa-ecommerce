package me.github.andrekunitz.ecommerce.jpabasics;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Product;

public class QueryRecordsTest extends EntityManagerTest {

	@Test
	public void findByIdTest() {
		Product product = entityManager.find(Product.class, 1);
//		#getReference is executed only when attribute is used.
//		Product product = entityManager.getReference(Product.class, 1);

		Assert.assertNotNull(product);
		Assert.assertEquals("Kindle", product.getName());
	}

	@Test
	public void updateReference() {
		Product product = entityManager.find(Product.class, 1);
		product.setName("Samson microfone");

		entityManager.refresh(product);

		Assert.assertNotNull(product);
		Assert.assertEquals("Kindle", product.getName());
	}
}
