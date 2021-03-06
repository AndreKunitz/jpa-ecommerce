package me.github.andrekunitz.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EntityManagerTest {

	protected static EntityManagerFactory entityManagerFactory;

	protected EntityManager entityManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("Ecommerce-PU");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManagerFactory.close();
	}

	@Before
	public void setUp() throws Exception {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}
}
