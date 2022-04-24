package me.github.andrekunitz.ecommerce.jpabasics;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Client;

public class CrudTest extends EntityManagerTest {

	@Test
	public void findById() {
		Client client = entityManager.find(Client.class, 1);

		Assert.assertNotNull(client);
		Assert.assertEquals("André Kunitz", client.getName());
	}

	@Test
	public void create() {
		Client client = new Client();
		client.setId(3);
		client.setName("Jane Doe");

		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Client clientVerification = entityManager.find(Client.class, client.getId());
		Assert.assertNotNull(clientVerification);
	}

	@Test
	public void update() {
		Client client = entityManager.find(Client.class, 1);

		entityManager.getTransaction().begin();
		client.setName("André Guilherme Kunitz");
		entityManager.getTransaction().commit();

		entityManager.clear();

		Client clientVerification = entityManager.find(Client.class, client.getId());
		Assert.assertEquals("André Guilherme Kunitz", clientVerification.getName());
	}

	@Test
	public void remove() {
		Client client = entityManager.find(Client.class, 2);

		entityManager.getTransaction().begin();
		entityManager.remove(client);
		entityManager.getTransaction().commit();

		Client clientVerification = entityManager.find(Client.class, client.getId());
		Assert.assertNull(clientVerification);
	}
}
