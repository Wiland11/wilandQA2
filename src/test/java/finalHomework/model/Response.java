package finalHomework.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private List<Response> reservations;

    public List<Response> getReservations() {
        return reservations;
    }

    public void setReservations(List<Response> reservations) {
        this.reservations = reservations;
    }
}
