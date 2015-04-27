package foo.bar.day03.tp.controller;

import foo.bar.day03.tp.domain.Guest;
import foo.bar.day03.tp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ainurminibaev on 10.04.15.
 */
@Controller
public class GuestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public String getGuestList(ModelMap map) {
        map.addAttribute("users", userService.findAll());
        //
        return "users";
    }

    @RequestMapping(value = "/guests", method = RequestMethod.POST)
    public String saveGuest(@ModelAttribute Guest guest) {
        userService.register(guest);
        return "redirect:/guests";
    }
}
