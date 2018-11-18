package io.logostory.orderbook.orderbookbackend.api;

import io.logostory.orderbook.orderbookbackend.domain.Seat;
import io.logostory.orderbook.orderbookbackend.domain.dto.SeatDto;
import io.logostory.orderbook.orderbookbackend.repository.SeatRepository;
import io.logostory.orderbook.orderbookbackend.service.SeatService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
public class SeatApi {

    @Autowired  SeatRepository  seatRepository;
    @Autowired  SeatService     seatService;

    @GetMapping(path = "/seats")
    public ResponseEntity<List<SeatDto.SeatSearchResultDto>> findSeats(SeatDto.SeatSearchDto dto) {
        return ResponseEntity.ok(seatService.findSeatList(dto));
    }

    @GetMapping(path = "/seats/{seatId}")
    public ResponseEntity<SeatDto.SeatSearchResultDto> findSeat(@PathVariable Long seatId) {

        Optional<Seat> optional = seatRepository.findById(seatId);
        if(optional.isPresent()) {
            return ResponseEntity.ok(new SeatDto.SeatSearchResultDto(optional.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/seats/{seatId}")
    public ResponseEntity deleteSeat(@PathVariable Long seatId) {

        seatRepository.deleteById(seatId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/seats")
    public ResponseEntity<SeatDto.SeatSearchResultDto> addSeat(@RequestBody SeatDto.SeatAddDto dto) {

        Seat seat = seatRepository.save(SeatDto.getSeat(dto));
        return ResponseEntity.ok(new SeatDto.SeatSearchResultDto(seat));
    }
}
