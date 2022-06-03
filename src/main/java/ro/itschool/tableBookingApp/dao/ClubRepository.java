package ro.itschool.tableBookingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.tableBookingApp.entity.ClubModel;

@Repository
public interface ClubRepository extends JpaRepository<ClubModel, Integer> {
}