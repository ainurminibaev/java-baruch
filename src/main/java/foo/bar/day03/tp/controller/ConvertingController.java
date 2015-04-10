package foo.bar.day03.tp.controller;

import foo.bar.day03.tp.domain.Guest;
import org.apache.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ainurminibaev on 10.04.15.
 */
@Controller
@RequestMapping("/convert")
public class ConvertingController {


    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public RequestEntity<String> createGuest(RequestEntity<Guest> guestRequestEntity) {

        RequestEntity<String> response = new RequestEntity<>("Creation OK", HttpStatus.SC_OK);
        response.getHeaders().add("Location", "/guests");
        return response;
    }
}
