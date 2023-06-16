package com.example.motipull.cardClass.entity;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.cardAdmin.entity.CardAdminEntity;
import com.example.motipull.cardClass.dto.CardClassDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "card_class")
public class CardClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card;

    @Column
    private String cardClass;


    public static CardClassEntity toEntity(CardEntity card, String cardClass) {
        CardClassEntity cardClassEntity = new CardClassEntity(card, cardClass);
        return cardClassEntity;
    }


    public CardClassEntity(CardEntity card, String cardClass) {
        this.card = card;
        this.cardClass = cardClass;
    }
}
