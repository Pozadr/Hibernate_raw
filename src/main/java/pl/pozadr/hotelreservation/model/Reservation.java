package pl.pozadr.hotelreservation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Guest> guest;

    public Reservation() {
    }

    public Reservation(List<Guest> guest) {
        this.guest = guest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Guest> getGuests() {
        return guest;
    }

    public void setGuests(List<Guest> guest) {
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
