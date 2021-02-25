package pl.pozadr.hotelreservation.repository;

import pl.pozadr.hotelreservation.model.Guest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GuestRepository {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public void createGuest(String name, int age) {
        System.out.println("----- CREATE -----");
        Guest newGuest = new Guest(name, age);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        System.out.println("----- Persisting in new transaction -----");
        em.persist(newGuest);
        System.out.println("New Guest ID " + newGuest.getId());

        System.out.println("----- Closing transaction -----");
        transaction.commit();
    }


}
