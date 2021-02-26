package pl.pozadr.hotelreservation.repository;

import pl.pozadr.hotelreservation.model.Guest;
import pl.pozadr.hotelreservation.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ReservationRepository {
    private EntityManager em;

    public ReservationRepository(EntityManager em) {
        this.em = em;
    }

    public void createReservation(Guest guest) {
        Reservation reservation = new Reservation(guest);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(reservation);
        transaction.commit();
    }

    public Reservation findById(long id) {
        System.out.println("----- RESERVATION FIND BY ID -----");
        return em.find(Reservation.class, id);
    }
}
