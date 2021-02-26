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

    public Guest findById(long id) {
        System.out.println("----- FIND BY ID -----");
        return em.find(Guest.class, id);
    }

    public void updateAge(Guest guest, int newAge) {
        System.out.println("----- UPDATE -----");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        guest.setAge(newAge);
        transaction.commit();
    }


    public void deleteGuest(Guest guest) {
        System.out.println("----- DELETE -----");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(guest);
        transaction.commit();
    }
}
