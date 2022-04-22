package me.github.andrekunitz.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import me.github.andrekunitz.model.Product;

public class InitPersistenceUnit {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Ecommerce-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, 1);
		System.out.println(product.getName());

		entityManager.close();
		entityManagerFactory.close();
	}
}
