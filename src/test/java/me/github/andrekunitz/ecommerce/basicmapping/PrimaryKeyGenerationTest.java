package me.github.andrekunitz.ecommerce.basicmapping;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Category;

public class PrimaryKeyGenerationTest extends EntityManagerTest {

	@Test
	public void keyGenerationStrategyTest() {
		Category category = new Category();
		category.setName("Eletronics");

		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Category categoryVerification = entityManager.find(Category.class, category.getId());
		Assert.assertNotNull(categoryVerification);
	}
}
