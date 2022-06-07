package ro.itschool.tableBookingApp.dao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.itschool.tableBookingApp.dao.ClubRepository;
import ro.itschool.tableBookingApp.dao.TableRepository;
import ro.itschool.tableBookingApp.entity.TableModel;

import java.util.List;
import java.util.Optional;

@Component
public class TableService {

    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private ClubRepository clubRepository;


    public void addTable(TableModel table) {

        tableRepository.save(table);
    }

    public List<TableModel> getTables() {

        List<TableModel> models = tableRepository.findAll();
        return models;
    }

    public void removeTable(int id) {
        tableRepository.deleteById(id);
    }

    public List<TableModel> searchByName(String reservationHolder) {
        return tableRepository.searchByReservationHolder(reservationHolder);
    }

    public TableModel getTables(int tableId) {
        Optional<TableModel> optionalTableModel = tableRepository.findById(tableId);
        TableModel tableModel = optionalTableModel.get();
        return tableModel;
    }

    public void updateTable(TableModel modifiedTable) {

        TableModel existingTable = getTables(modifiedTable.getId());

        existingTable.setReservationHolder(modifiedTable.getReservationHolderContact());
        existingTable.setReservationHolder(modifiedTable.getReservationHolder());
        existingTable.setNumberOfGuests(modifiedTable.getNumberOfGuests());
        existingTable.setId(modifiedTable.getId());
        existingTable.setBarSeats(modifiedTable.isBarSeats());

        tableRepository.save(modifiedTable);

    }

    public List<TableModel> viewReservation(int clubId) {
        List<TableModel> optionalTableModel = tableRepository.viewReservedTable(clubId  );
        return optionalTableModel;
    }

}