package com.example.motipull.cardDetail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardDetailDto {
    private Integer Id;
    private Integer cardId;
    private String detailExplanation;
    private Boolean detailCompleted;

}
