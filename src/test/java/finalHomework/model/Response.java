package finalHomework.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private List<Reservations> reservations;

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
}
