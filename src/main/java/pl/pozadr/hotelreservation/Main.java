package pl.pozadr.hotelreservation;

import pl.pozadr.hotelreservation.repository.GuestRepository;

public class Main {
    public static void main(String[] args) {
        GuestRepository repo = new GuestRepository();
        repo.createGuest("Adam", 90);
    }
}
