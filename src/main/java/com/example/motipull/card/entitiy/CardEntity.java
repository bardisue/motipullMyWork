package com.example.motipull.card.entitiy;

import com.example.motipull.card.dto.CardDto;
import com.example.motipull.config.BooleanToYNConverter;
import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.entity.Room;
import com.example.motipull.rowPrimary.entity.RowPrimaryEntity;
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
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardID;

    @Column
    private String cardName;

    @Column
    private String cardExplanation;
    @Column
    private String cardDomain;
    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean cardDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "row_id")
    private KanbanRowEntity row;

    public CardEntity(Integer cardID, String cardName, String cardExplanation, String cardDomain, boolean cardDetail, KanbanRowEntity row) {
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardExplanation = cardExplanation;
        this.cardDomain = cardDomain;
        this.cardDetail = cardDetail;
        this.row = row;
    }

    public static CardEntity toEntity(CardDto dto, KanbanRowEntity row) {
        return new CardEntity(dto.getCardId(), dto.getCardName(), dto.getCardExplanation(), dto.getCardDomain(), dto.getCardDetail(), row);
    }
}
