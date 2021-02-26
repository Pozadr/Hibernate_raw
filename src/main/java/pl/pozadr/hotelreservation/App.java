package pl.pozadr.hotelreservation;

import pl.pozadr.hotelreservation.model.Guest;
import pl.pozadr.hotelreservation.model.Reservation;
import pl.pozadr.hotelreservation.repository.GuestRepository;
import pl.pozadr.hotelreservation.repository.ReservationRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public static void main(String[] args) {
        GuestRepository guestRepository = new GuestRepository(em);
        ReservationRepository reservationRepository = new ReservationRepository(em);

        guestRepository.createGuest("Adam", 90);
        guestRepository.createGuest("Karol", 70);
        guestRepository.createGuest("Robert", 40);

        List<Guest> guests = guestRepository.findAll();
        guests.forEach(System.out::println);

        reservationRepository.createReservation(guests);
        Reservation reservation = reservationRepository.findById(4L);
        System.out.println("Find reservation by id: " + reservation);
    }
}
