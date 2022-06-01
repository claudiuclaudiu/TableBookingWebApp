package ro.itschool.tableBookingApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.tableBookingApp.dao.service.ClubService;
import ro.itschool.tableBookingApp.dao.service.TableService;
import ro.itschool.tableBookingApp.entity.ClubModel;
import ro.itschool.tableBookingApp.entity.TableModel;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;
    @Autowired
    private ClubService clubService;


    @GetMapping("view-tables")
    public String viewTables(Model model) {

        List<TableModel> tableModels = tableService.getTables();
        model.addAttribute("table", tableModels);

        return "tables";

    }

    @GetMapping("add-tables")
    public String addTablePage(Model model) {

        List<ClubModel> clubs = clubService.getClubs();
        model.addAttribute("table", new TableModel());
        model.addAttribute("club", clubs);

        return "add-tables";
    }

    @PostMapping("add-new-table")
    public String addNewTable(TableModel table) {

        tableService.addTable(table);
        return "redirect:/view-tables";
    }


    @GetMapping("edit-table-page/{tableId}")
    public String editTablePage(@PathVariable("tableId") int tableId, Model model) {

        TableModel tableModel = tableService.getTables(tableId);
        List<ClubModel> clubs = clubService.getClubs();

        model.addAttribute("table", tableModel);
        model.addAttribute("club", clubs);

        return "edit-tables";
    }

    @GetMapping("delete-table/{id}")
    public String deleteTable(@PathVariable("id") int tableId) {

        tableService.removeTable(tableId);

        return "redirect:/view-tables";
    }

    @PostMapping("edit-new-table")
    public String editTable(TableModel tableModel) {

        tableService.updateTable(tableModel);

        return "redirect:/view-tables";
    }


}
