package com.example.motipull.cardAdmin.entity;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "card_admin")
public class CardAdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;


    public static CardAdminEntity toEntity(Integer id, CardEntity card, MemberEntity member) {
        CardAdminEntity cardAdminEntity = new CardAdminEntity(id, card, member);
        return cardAdminEntity;
    }

    public CardAdminEntity(int id, CardEntity card, MemberEntity member) {
        this.id = id;
        this.card = card;
        this.member = member;
    }

}
