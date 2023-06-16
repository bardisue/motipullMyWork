package com.example.motipull.card.entitiy;

import com.example.motipull.card.dto.CardDto;
import com.example.motipull.config.BooleanToYNConverter;
import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.entity.Room;
import com.example.motipull.rowPrimary.entity.RowPrimaryEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "card")
public class CardEntity {

    @Id
    private Integer id;
    @Column
    private Integer colId;
    @Column
    private String cardName;
    @Column
    private String cardDescription;
    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean isDetailWorks;
    @Column
    private Integer cheerUp;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @Column
    private LocalDate dueDate;

    public CardEntity(Integer id, Integer colId, String cardName, String cardDescription, boolean isDetailWorks, Integer cheerUp, LocalDate dueDate) {
        this.id = id;
        this.colId = colId;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.isDetailWorks = isDetailWorks;
        this.cheerUp = cheerUp;
        this.dueDate = dueDate;
    }

    public static CardEntity toEntity(CardDto dto) {
        return new CardEntity(dto.getId(), dto.getColId(), dto.getName(), dto.getDescription(), dto.getIsDetailWorks(), dto.getCheerUp(), dto.getDueDate());
    }
}
