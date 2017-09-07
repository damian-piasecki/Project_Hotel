package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.GuestDao;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservations;

import java.time.LocalDate;

@Controller
public class GuestController {
    @Autowired
    GuestDao guestDao;

    @RequestMapping(value= "/guest", method = RequestMethod.GET)
    public String guest(){
        return "login/guest";
    }
    @RequestMapping(value = "/guestSingUp", method = RequestMethod.POST)
    public String processForm(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName, @RequestParam(name = "pesel" ) String pesel, @RequestParam(name = "docNumber" ) String docNumber) {
        Guest guest = new Guest();

        guest.setName(firstName);
        guest.setLastname(lastName);
        guest.setPesel(pesel);
        guest.setDocNumber(docNumber);


        guestDao.saveGuest(guest);

        return "login/ok";
    }
    @RequestMapping(value= "/ok", method = RequestMethod.GET)
    public String gallery(){
        return "login/ok";
    }
}
