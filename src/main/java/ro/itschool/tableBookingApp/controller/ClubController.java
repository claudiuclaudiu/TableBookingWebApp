package ro.itschool.tableBookingApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.tableBookingApp.dao.ClubRepository;
import ro.itschool.tableBookingApp.dao.service.ClubService;
import ro.itschool.tableBookingApp.dao.service.TableService;
import ro.itschool.tableBookingApp.entity.ClubModel;
import ro.itschool.tableBookingApp.entity.TableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClubController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private TableService tableService;


    @GetMapping("view-clubs")
    public String viewClubs(Model model) {
        List<ClubModel> clubModels = clubService.getClubs();
        model.addAttribute("club", clubModels);

        return "clubs";
    }


    @GetMapping("add-clubs")
    public String addClubPage(Model model) {

        List<TableModel> tables = tableService.getTables();
        model.addAttribute("club", new ClubModel());
        model.addAttribute("table", tables);

        return "add-clubs";
    }

    @PostMapping("add-new-club")
    public String addNewClub(ClubModel club) {

        clubService.addClub(club);
        return "redirect:/view-clubs";
    }


    @GetMapping("edit-club-page/{clubId}")
    public String editClubPage(@PathVariable("clubId") int clubId, Model model) {

        ClubModel clubModel = clubService.getClubs(clubId);
        List<TableModel> tables = tableService.getTables();

        model.addAttribute("club", clubModel);
        model.addAttribute("table", tables);

        return "edit-clubs";

    }

    @PostMapping("edit-new-club")
    public String editClub(ClubModel clubModel) {

        clubService.updateClub(clubModel);

        return "redirect:/view-clubs";
    }


    @GetMapping("delete-clubs/{id}")
    public String deteleClub(@PathVariable("id") int clubId) {

        clubService.deleteClub(clubId);

        return "redirect:/view-clubs";
    }


    @GetMapping("table-page/{tableId}")
    public String reservationPage(@PathVariable("tableId") int tableId, Model model) {

        ClubModel clubModel = clubService.getClubs(tableId);
        List<TableModel> tables = tableService.getTables();

        model.addAttribute("club", clubModel);
        model.addAttribute("table", tables);

        return "tables";

    }

    @GetMapping("home")
    public String homePage(ClubModel clubModel) {
        return "home-page";
    }

}
