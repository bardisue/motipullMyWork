package com.example.motipull.cardDetail.entity;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.cardDetail.dto.CardDetailDto;
import com.example.motipull.config.BooleanToYNConverter;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "card_detail")
public class CardDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card;

    @Column
    private String detailExplanation;

    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean detailCompleted;


    public static CardDetailEntity toEntity(CardDetailDto dto, CardEntity card) {
        return new CardDetailEntity(dto.getId(), card, dto.getDetailExplanation(), dto.getDetailCompleted());
    }

    public CardDetailEntity(Integer id, CardEntity card, String detailExplanation, boolean detailCompleted) {
        this.id = id;
        this.card = card;
        this.detailExplanation = detailExplanation;
        this.detailCompleted = detailCompleted;
    }
}
