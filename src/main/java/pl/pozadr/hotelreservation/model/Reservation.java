package pl.pozadr.hotelreservation.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Guest guest;

    public Reservation() {
    }

    public Reservation(Guest guest) {
        this.guest = guest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", guest=" + guest +
                '}';
    }
}
