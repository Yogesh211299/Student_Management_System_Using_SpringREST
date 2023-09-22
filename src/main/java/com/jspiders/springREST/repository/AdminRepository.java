package com.jspiders.springREST.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springREST.pojo.AdminPojo;
@Repository
public class AdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("springREST");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

	}

	public static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}

	}

	public AdminPojo createAdmin(AdminPojo pojo) {
		openConnection();
		transaction.begin();

		manager.persist(pojo);

		transaction.commit();
		closeConnection();
		return pojo;

	}

	public AdminPojo loginAdmin(AdminPojo pojo) {

		openConnection();
		transaction.begin();
		AdminPojo admin = manager.find(AdminPojo.class, pojo.getUsername());
		if (admin != null) {
			if (admin.getPassword().equals(pojo.getPassword())) {
                 transaction.commit();
                 closeConnection();
                 return admin;
			}
		}
		transaction.commit();
        closeConnection();
		return null;
	}

}
