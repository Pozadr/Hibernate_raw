package pl.pozadr.hotelreservation;

import pl.pozadr.hotelreservation.model.Guest;
import pl.pozadr.hotelreservation.model.Reservation;
import pl.pozadr.hotelreservation.repository.GuestRepository;
import pl.pozadr.hotelreservation.repository.ReservationRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public static void main(String[] args) {
        GuestRepository guestRepository = new GuestRepository(em);
        ReservationRepository reservationRepository = new ReservationRepository(em);

        guestRepository.createGuest("Adam", 90);
        Guest guest = guestRepository.findById(1L);
        System.out.println("Find guest by id: " + guest);
        guestRepository.updateAge(guest, 40);
        System.out.println("Updated guest: " + guest);
        // guestRepository.deleteGuest(guest);

        reservationRepository.createReservation(guest);
        Reservation reservation = reservationRepository.findById(2L);
        System.out.println("Find reservation by id: " + reservation);
    }
}
