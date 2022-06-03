package ro.itschool.tableBookingApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.tableBookingApp.dao.service.ClubService;
import ro.itschool.tableBookingApp.dao.service.ReservationService;
import ro.itschool.tableBookingApp.entity.ClubModel;
import ro.itschool.tableBookingApp.entity.ReservationModel;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClubService clubService;


    @GetMapping("view-reservation")
    public String viewReservations(Model model) {

        List<ReservationModel> reservationModels = reservationService.getReservation();
        model.addAttribute("reservation", reservationModels);

        return "reservation";

    }

    @GetMapping("add-reservation")
    public String addReservationPage(Model model) {

        List<ClubModel> clubs = clubService.getClubs();
        model.addAttribute("reservation", new ReservationModel());
        model.addAttribute("club", clubs);

        return "add-reservation";
    }

    @PostMapping("add-new-reservation")
    public String addNewReservation(ReservationModel reservation) {

        reservationService.addReservation(reservation);
        return "redirect:/view-reservation";
    }


    @GetMapping("edit-reservation-page/{reservationId}")
    public String editReservationPage(@PathVariable("reservationId") int reservationId, Model model) {

        ReservationModel reservationModel = reservationService.getReservation(reservationId);
        List<ClubModel> clubs = clubService.getClubs();

        model.addAttribute("reservation", reservationModel);
        model.addAttribute("club", clubs);

        return "edit-reservation";
    }

    @GetMapping("delete-reservation/{id}")
    public String deleteReservation(@PathVariable("id") int reservationId) {

        reservationService.removeReservation(reservationId);

        return "redirect:/view-reservation";
    }

    @PostMapping("edit-new-reservation")
    public String editReservation(ReservationModel reservationModel) {

        reservationService.updateReservation(reservationModel);

        return "redirect:/view-reservation";
    }


//    @GetMapping("view-table-page/{tableId}")
//    public String viewTablePage(@PathVariable("tableId") int tableId, Model model) {
//
//        TableModel tableModel = tableService.getTables(tableId);
//        List<ClubModel> clubs = clubService.getClubs();
//
//        model.addAttribute("table", tableModel);
//        model.addAttribute("club", clubs);
//
//        return "view-tables";
//    }


}
