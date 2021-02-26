package pl.pozadr.hotelreservation.repository;

import pl.pozadr.hotelreservation.model.Guest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class GuestRepository {
    private EntityManager em;

    public GuestRepository(EntityManager em) {
        this.em = em;
    }

    public void createGuest(String name, int age) {
        System.out.println("----- GUEST CREATE -----");
        Guest newGuest = new Guest(name, age);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newGuest);
        //System.out.println("New Guest ID " + newGuest.getId());
        transaction.commit();
    }

    public List<Guest> findAll() {
        System.out.println("----- FIND ALL -----");
        Query query = em.createQuery("SELECT e FROM Guest e");
        return (List<Guest>) query.getResultList();
    }

    public Guest findById(long id) {
        System.out.println("----- GUEST FIND BY ID -----");
        return em.find(Guest.class, id);
    }

    public void updateAge(Guest guest, int newAge) {
        System.out.println("----- GUEST UPDATE -----");
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
