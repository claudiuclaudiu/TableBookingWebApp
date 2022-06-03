package ro.itschool.tableBookingApp.dao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.itschool.tableBookingApp.dao.ClubRepository;
import ro.itschool.tableBookingApp.dao.TableRepository;
import ro.itschool.tableBookingApp.entity.ClubModel;

import java.util.List;
import java.util.Optional;

@Component
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private TableRepository tableRepository;


    public void addClub(ClubModel clubModel) {
        clubRepository.save(clubModel);
    }

    public List<ClubModel> getClubs() {
        return clubRepository.findAll();
    }

    public void deleteClub(int clubId) {
        clubRepository.deleteById(clubId);
    }

    public ClubModel getClubs(int clubId) {

        Optional<ClubModel> optionalClubModel = clubRepository.findById(clubId);
        ClubModel clubModel = optionalClubModel.get();
        return clubModel;

    }

    public void updateClub(ClubModel modifiedClub){

        ClubModel existingClub = getClubs(modifiedClub.getId());

        existingClub.setId(modifiedClub.getId());
        existingClub.setAddress(modifiedClub.getAddress());
        existingClub.setPhoneNumber(modifiedClub.getPhoneNumber());
        existingClub.setName(modifiedClub.getName());

        clubRepository.save(modifiedClub);
    }

}