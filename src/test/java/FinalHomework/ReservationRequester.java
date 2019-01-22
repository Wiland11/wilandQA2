package FinalHomework;

import apiTests.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ReservationRequester {

    public Response getReservationsList() throws IOException {
        String url = "http://www.qaguru.lv:8090/tickets/getReservations.php";
        RestTemplate restTemplate = new RestTemplate();
        String responceToParse = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValues(responceToParse, Response.class);
    }
}
