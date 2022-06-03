package ro.itschool.tableBookingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.itschool.tableBookingApp.entity.TableModel;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableModel, Integer> {

    @Query(value = "from TableModel where reservationHolder like :startWith%")
    List<TableModel> searchByReservationHolder(@Param("startWith")String param);
}