package com.example.shabbyshackinn.services;

import com.example.shabbyshackinn.dtos.DetailedBookingDto;
import com.example.shabbyshackinn.dtos.DetailedRoomDto;
import com.example.shabbyshackinn.dtos.MiniRoomDto;
import com.example.shabbyshackinn.models.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {//

    DetailedRoomDto roomToDetailedRoomDTO(Room room);

    List<DetailedRoomDto> getAllRooms();

    Room detailedRoomToRoom(DetailedRoomDto room);

    MiniRoomDto roomToMiniRoomDto(Room room);

    MiniRoomDto findMiniRoomByRoomNumber(int roomNumber);

    List<DetailedRoomDto> findAvailableRooms(List<Long> detailedBookingDtoList);

    DetailedRoomDto findDetailedRoomById(Long id);

    MiniRoomDto findMiniRoomById(Long id);

    List<DetailedRoomDto> findBigEnoughRoomsForNumberOfGuests(int amountOfPersons);
    List<DetailedRoomDto> searchAvailableRooms(LocalDate startDate, LocalDate endDate, int numberOfGuests);

}
