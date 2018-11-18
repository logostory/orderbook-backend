package io.logostory.orderbook.orderbookbackend.service;

import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import io.logostory.orderbook.orderbookbackend.domain.QSeat;
import io.logostory.orderbook.orderbookbackend.domain.Seat;
import io.logostory.orderbook.orderbookbackend.domain.dto.SeatDto;
import io.logostory.orderbook.orderbookbackend.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired SeatRepository seatRepository;

    public List<SeatDto.SeatSearchResultDto> findSeatList(SeatDto.SeatSearchDto dto) {

        List<Seat> seats = Lists.newArrayList(seatRepository.findAll(builder(dto)));
        return seats.stream().map(seat -> new SeatDto.SeatSearchResultDto(seat)).collect(Collectors.toList());
    }

    private BooleanBuilder builder(SeatDto.SeatSearchDto dto ) {

        BooleanBuilder builder = new BooleanBuilder();
        String keyword = "%"+dto.getKeyword()+"%";
        QSeat qSeat = QSeat.seat;
        builder.and(qSeat.name.like(keyword));

        //TODO: add more search condition

        return builder;
    }
}
