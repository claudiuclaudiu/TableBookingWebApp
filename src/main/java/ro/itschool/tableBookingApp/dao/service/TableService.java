package ro.itschool.tableBookingApp.dao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.itschool.tableBookingApp.dao.ClubRepository;
import ro.itschool.tableBookingApp.dao.ReservationRepository;
import ro.itschool.tableBookingApp.entity.ReservationModel;

import java.util.List;
import java.util.Optional;

@Component
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ClubRepository clubRepository;


    public void addReservation(ReservationModel reservation) {

        reservationRepository.save(reservation);
    }

    public List<ReservationModel> getReservation() {

        List<ReservationModel> models = reservationRepository.findAll();
        return models;
    }

    public void removeReservation(int id) {
        reservationRepository.deleteById(id);
    }

    public List<ReservationModel> searchByName(String reservationHolder) {
        return reservationRepository.searchByReservationHolder(reservationHolder);
    }

    public ReservationModel getReservation(int reservationId) {
        Optional<ReservationModel> optionalReservationModelModel = reservationRepository.findById(reservationId);
        ReservationModel reservationModel = optionalReservationModelModel.get();
        return reservationModel;
    }

    public void updateReservation(ReservationModel modifiedReservation) {

        ReservationModel existingTable = getReservation(modifiedReservation.getId());

        existingTable.setReservationHolder(modifiedReservation.getReservationHolderContact());
        existingTable.setReservationHolder(modifiedReservation.getReservationHolder());
        existingTable.setNumberOfGuests(modifiedReservation.getNumberOfGuests());
        existingTable.setId(modifiedReservation.getId());
        existingTable.setBarSeats(modifiedReservation.isBarSeats());

        reservationRepository.save(modifiedReservation);

    }

}
