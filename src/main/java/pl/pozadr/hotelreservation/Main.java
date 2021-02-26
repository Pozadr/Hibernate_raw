package pl.pozadr.hotelreservation;

import pl.pozadr.hotelreservation.model.Guest;
import pl.pozadr.hotelreservation.repository.GuestRepository;

public class Main {
    public static void main(String[] args) {
        GuestRepository repo = new GuestRepository();
        repo.createGuest("Adam", 90);
        Guest guest = repo.findById(1L);
        System.out.println("Find guest by id: " + guest);
        repo.updateAge(guest, 40);
        System.out.println("Updated guest: " + guest);
        repo.deleteGuest(guest);
    }
}
