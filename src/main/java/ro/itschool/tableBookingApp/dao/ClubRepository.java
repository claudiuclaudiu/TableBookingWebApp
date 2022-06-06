package ro.itschool.tableBookingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.itschool.tableBookingApp.entity.ClubModel;
import ro.itschool.tableBookingApp.entity.TableModel;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<ClubModel, Integer> {

    @Query(value = "from ClubModel where name like :startWith%")
    List<ClubModel> searchByClubName(@Param("startWith")String param);
}