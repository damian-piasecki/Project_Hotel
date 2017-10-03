package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.GuestDao;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservations;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.time.LocalDate;

@Controller
public class GuestController {
    @Autowired
    GuestDao guestDao;

    @RequestMapping(value= "/guest", method = RequestMethod.GET)
    public String guest(){
        return "login/guest";
    }
    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public String processForm(Model model, @Validated({Default.class}) @Valid Guest guest, BindingResult result , @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName, @RequestParam(name = "pesel" ) String pesel, @RequestParam(name = "docnumber" ) String docNumber) {

        if (result.hasErrors()) {

            return "reservation/guest";
        }
        model.addAttribute("guest", guest );

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
