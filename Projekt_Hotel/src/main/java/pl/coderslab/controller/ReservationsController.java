package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PaymentDao;
import pl.coderslab.dao.ReservationsDao;
import pl.coderslab.dao.RoomsDao;
import pl.coderslab.entity.Payment;
import pl.coderslab.entity.Reservations;
import pl.coderslab.entity.Rooms;
import pl.coderslab.services.ReservationsService;

import javax.persistence.metamodel.SetAttribute;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class ReservationsController {
    private final ReservationsService reservationsService;
    @Autowired
    RoomsDao roomsDao;

    @Autowired
    ReservationsDao reservationsDao;

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Reserve(Model model) {
        List<Reservations> reservations = reservationsDao.getList();
        List<String> reservationsDates = new ArrayList<>();
        for(Reservations reservationsElements:reservations){
            long period =  reservationsElements.getArrivalDate().until(reservationsElements.getCheckoutDate(), DAYS);

            for(int i=0;i<=period;i++){
                String formattedDate =reservationsElements.getArrivalDate().plusDays(i).toString();
                reservationsDates.add(formattedDate);
                System.out.println(formattedDate);
            }
        }
        model.addAttribute("reservationsDates", reservationsDates);
        Rooms();
        Payment();
        model.addAttribute("reservation", new Reservations());
        return "index";
    }
    // Connecting java with jsp. Sending list of rooms to select from in index.jsp
    @ModelAttribute("room")
    public Collection<Rooms> Rooms() {
        return this.roomsDao.getList();
    }
    // List of payments to select from in index.jsp
    @ModelAttribute("payment")
    public Collection<Payment> Payment() {
        return this.paymentDao.getList();
    }

    @ModelAttribute("reservations")
    public Collection<Reservations> Reservations(){return this.reservationsDao.getList();}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String processForm(Model model , @ModelAttribute("reservation") Reservations reservation, @RequestParam(name = "arrivalDate") String arrivalDate, @RequestParam(name = "checkoutDate") String checkoutDate) {


        //Parsing string "arrivalDate" to LocalDate

        LocalDate arrDate = LocalDate.parse(arrivalDate);

        //Parsing string "checkoutDate" to LocalDate
        LocalDate outDate = LocalDate.parse(checkoutDate);
        reservation.setArrivalDate(arrDate);
        reservation.setCheckoutDate(outDate);
        reservationsDao.saveReservations(reservation);
        return "reservation/guest";
    }
    @RequestMapping(value= "/contact", method = RequestMethod.GET)
    public String contact(){
        return "/about/contact";
    }
    @RequestMapping(value= "/gallery", method = RequestMethod.GET)
    public String gallery(){
        return "/about/gallery";
    }
}
