package me.github.andrekunitz.ecommerce.basicmapping;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Client;
import me.github.andrekunitz.ecommerce.model.Gender;

public class EnumerationMappingTest extends EntityManagerTest {

	@Test
	public void enumTest() {
		Client client = new Client();
		client.setName("José Mineiro");
		client.setGender(Gender.MALE);

		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Client clientVerification = entityManager.find(Client.class, client.getId());
		Assert.assertNotNull(clientVerification);
	}
}
