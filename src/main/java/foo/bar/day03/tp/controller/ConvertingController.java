package foo.bar.day03.tp.controller;

import foo.bar.day03.tp.domain.Guest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createGuest(RequestEntity<Guest> guestRequestEntity) {
        return null;
        //TODO чувак надо сделать
    }
}
