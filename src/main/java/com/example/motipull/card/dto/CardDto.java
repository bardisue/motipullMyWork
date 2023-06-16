package com.example.motipull.card.dto;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.room.entity.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CardDto {
    private Integer colId;
    private Integer id;
    private String name;
    private String description;
    private Boolean isDetailWorks;
    private Integer cheerUp;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate dueDate;

    public static CardDto toDto(CardEntity card){
        return new CardDto(card.getColId(), card.getId(), card.getCardName(), card.getCardDescription(), card.isDetailWorks(), card.getCheerUp(), card.getDueDate());
    }

}
