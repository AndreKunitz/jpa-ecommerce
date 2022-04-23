package me.github.andrekunitz.ecommerce.jpabasics;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Product;

public class TransactionalOperationsTest extends EntityManagerTest {

	@Test
	public void insertFirstObject() {
		Product product = new Product();
		product.setId(2);
		product.setName("Canon Camera");
		product.setDescription("The best definition for your photos.");
		product.setPrice(new BigDecimal(5000));

		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product verifiedProduct = entityManager.find(Product.class, product.getId());
		Assert.assertNotNull(verifiedProduct);
	}

	@Test
	public void openAndCloseTransaction() {
//		Product product = new Product();

		entityManager.getTransaction().begin();

//		entityManager.persist(product);
//		entityManager.merge(product);
//		entityManager.remove(product);

		entityManager.getTransaction().commit();
	}
}
