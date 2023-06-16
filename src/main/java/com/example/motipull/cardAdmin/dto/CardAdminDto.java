package com.example.motipull.cardAdmin.dto;

import com.example.motipull.cardAdmin.entity.CardAdminEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardAdminDto {
    private Integer cardId;
    private String admin;

     public static CardAdminDto toDto(CardAdminEntity cardAdmin){
        return new CardAdminDto(cardAdmin.getCard().getId(), cardAdmin.getAdmin());
     }
}
