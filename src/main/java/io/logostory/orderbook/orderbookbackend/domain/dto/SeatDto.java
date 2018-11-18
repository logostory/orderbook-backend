package io.logostory.orderbook.orderbookbackend.domain.dto;

import com.fasterxml.jackson.databind.JsonSerializer;
import io.logostory.orderbook.orderbookbackend.domain.Seat;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.AccessType;

@Data
public class SeatDto {


    String name;

    @Data
    public static class SeatAddDto extends  SeatDto {

    }

    @Data
    public static class SeatSearchDto extends  SearchDto {

    }


    @Data
    public static class SeatSearchResultDto extends SeatDto{

        long id;

        public SeatSearchResultDto(Seat seat) {
            this.id = seat.getSeatId();
            this.name = seat.getName();
        }
    }

    public static Seat getSeat(SeatAddDto dto) {
        Seat seat = new Seat();
        seat.setName(dto.getName());
        return seat;
    }
}
