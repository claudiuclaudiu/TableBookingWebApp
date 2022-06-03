package ro.itschool.tableBookingApp.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation_details")

public class ReservationModel {

    @Id
    private int id;
    private String reservationHolder;
    private int numberOfGuests;
    private String reservationHolderContact;
    private boolean barSeats;
@ManyToOne
    private ClubModel clubModel;

    // setters and getters//
    //---------------------//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReservationHolder() {
        return reservationHolder;
    }

    public void setReservationHolder(String reservationHolder) {
        this.reservationHolder = reservationHolder;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getReservationHolderContact() {
        return reservationHolderContact;
    }

    public void setReservationHolderContact(String reservationHolderContact) {
        this.reservationHolderContact = reservationHolderContact;
    }

    public boolean isBarSeats() {
        return barSeats;
    }

    public void setBarSeats(boolean barSeats) {
        this.barSeats = barSeats;
    }

    public ClubModel getClubModel() {
        return clubModel;
    }

    public void setClubModel(ClubModel clubModel) {
        this.clubModel = clubModel;
    }
}
