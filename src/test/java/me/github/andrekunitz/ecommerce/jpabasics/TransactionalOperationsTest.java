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
		Assert.assertEquals("Kindle Paperwhite 2° gen.", productVerification.getName());
	}

	@Test
	public void insertObjectWithMerge() {
		Product product = new Product();
		product.setId(4);
		product.setName("Rhode microphone");
		product.setDescription("The best sound quality.");
		product.setPrice(new BigDecimal(1000));

		entityManager.getTransaction().begin();
		entityManager.merge(product);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product productVerification = entityManager.find(Product.class, product.getId());
		Assert.assertNotNull(productVerification);
	}

	@Test
	public void differenceBetweenPersistAndMerge() {
		Product productPersist = new Product();
		productPersist.setId(4);
		productPersist.setName("Smartphone One Plus");
		productPersist.setDescription("The fastest processor.");
		productPersist.setPrice(new BigDecimal(2000));

		entityManager.getTransaction().begin();
		entityManager.persist(productPersist);
		productPersist.setName("Smartphone Two Plus");
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product productVerificationPersist = entityManager.find(Product.class, productPersist.getId());
		Assert.assertNotNull(productVerificationPersist);



		Product productMerge = new Product();
		productMerge.setId(4);
		productMerge.setName("Dell Notebook");
		productMerge.setDescription("The best one.");
		productMerge.setPrice(new BigDecimal(2000));

		entityManager.getTransaction().begin();
		// #merge makes a copy of the object, so you have to get it back in the return to set subsequent changes.
		productMerge = entityManager.merge(productMerge);
		productMerge.setName("Dell Notebook 2");
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product productVerificationMerge = entityManager.find(Product.class, productMerge.getId());
		Assert.assertNotNull(productVerificationMerge);
	}

	@Test
	public void blockOperationWithDatabase() {
		Product product = entityManager.find(Product.class, 1);
		entityManager.detach(product);

		entityManager.getTransaction().begin();
		product.setName("Kindle Paperwhite 2° gen.");
		entityManager.getTransaction().commit();

		entityManager.clear();

		Product productVerification = entityManager.find(Product.class, product.getId());
		Assert.assertEquals("Kindle", productVerification.getName());
	}
}
