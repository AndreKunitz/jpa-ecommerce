package me.github.andrekunitz.ecommerce.jpabasics;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Product;

public class TransactionalOperationsTest extends EntityManagerTest {

	@Test
	public void openAndCloseTransaction() {
//		Product product = new Product();

		entityManager.getTransaction().begin();

//		entityManager.persist(product);
//		entityManager.merge(product);
//		entityManager.remove(product);

		entityManager.getTransaction().commit();
	}

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

		Product productVerification = entityManager.find(Product.class, product.getId());
		Assert.assertNotNull(productVerification);
	}

	@Test
	public void removeObject() {
		Product product = entityManager.find(Product.class, 3);

		entityManager.getTransaction().begin();
		entityManager.remove(product);
		entityManager.getTransaction().commit();

//		entityManager.clear(); -> Not needed, since #remove already removes the object from entity manager memory.

		Product productVerification = entityManager.find(Product.class, product.getId());
		Assert.assertNull(productVerification);
	}

	@Test
	public void updateObject() {
		Product product = new Product();
		product.setId(1);
		product.setName("Kindle Paperwhite");
		product.setDescription("Meet the new Kindle.");
		product.setPrice(new BigDecimal(599));

		entityManager.getTransaction().begin();
		entityManager.merge(product);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product productVerification = entityManager.find(Product.class, product.getId());
		Assert.assertNotNull(productVerification);
		Assert.assertEquals("Kindle Paperwhite", product.getName());
	}

	@Test
	public void updateManagedObject() {
		Product product = entityManager.find(Product.class, 1);

		entityManager.getTransaction().begin();
		product.setName("Kindle Paperwhite 2° gen.");
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product productVerification = entityManager.find(Product.class, product.getId());
		Assert.assertEquals("Kindle Paperwhite 2° gen.", product.getName());
	}
}
