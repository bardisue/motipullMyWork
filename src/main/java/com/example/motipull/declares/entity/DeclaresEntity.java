package com.example.motipull.declares.entity;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.declares.dto.DeclaresDto;
import com.example.motipull.member.entity.MemberEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"declares\"")
public class DeclaresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @Column
    private LocalDate limits;

    public static DeclaresEntity toEntity(DeclaresDto dto, MemberEntity member, CardEntity card) {
        return new DeclaresEntity(dto.getId(), member, card, dto.getLimits());
    }

    public DeclaresEntity(int id, MemberEntity member, CardEntity card, LocalDate limits) {
        this.id = id;
        this.member = member;
        this.card = card;
        this.limits = limits;
    }
}
