package me.github.andrekunitz.ecommerce.relationships;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import me.github.andrekunitz.ecommerce.EntityManagerTest;
import me.github.andrekunitz.ecommerce.model.Category;
import me.github.andrekunitz.ecommerce.model.Client;
import me.github.andrekunitz.ecommerce.model.Order;
import me.github.andrekunitz.ecommerce.model.OrderLineItem;
import me.github.andrekunitz.ecommerce.model.OrderStatus;
import me.github.andrekunitz.ecommerce.model.Product;

public class AutoRelationshipTest extends EntityManagerTest {

	@Test
	public void verifyRelationship() {
		Category parentCategory = new Category();
		parentCategory.setName("Eletronics");

		Category childCategory = new Category();
		childCategory.setName("Smartphone");
		childCategory.setParentCategory(parentCategory);

		entityManager.getTransaction().begin();
		entityManager.persist(parentCategory);
		entityManager.persist(childCategory);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Category childCategoryVerification = entityManager.find(Category.class, childCategory.getId());
		Assert.assertNotNull(childCategoryVerification.getParentCategory());

		Category parentCategoryVerification = entityManager.find(Category.class, parentCategory.getId());
		Assert.assertFalse(parentCategoryVerification.getChildCategories().isEmpty());
	}
}
