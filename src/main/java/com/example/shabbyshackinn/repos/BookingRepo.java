package com.example.shabbyshackinn.repos;

import com.example.shabbyshackinn.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT SUM(DATEDIFF(b.end_date, b.start_date)) FROM Booking b WHERE b.customer_id = :customerId AND b.start_date >= :startOfYear AND b.start_date < :startOfNextYear", nativeQuery = true)
    Optional<Integer> sumNightsByCustomerIdAndYear(Long customerId, LocalDate startOfYear, LocalDate startOfNextYear);

    List<Booking> findAllByEndDateAfter(LocalDate todayDate);

    List<Booking> findAllByIdIsNotAndRoomIdAndStartDateIsBeforeAndEndDateIsAfter(Long bookingId, Long roomId, LocalDate endDate, LocalDate startDate);

    List<Booking> findAllByStartDateIsBeforeAndEndDateIsAfter(LocalDate endDate, LocalDate startDate);

}
