package com.example.motipull.kanbanRow.entity;

import com.example.motipull.card.entitiy.CardEntity;
import com.example.motipull.config.BooleanToYNConverter;
import com.example.motipull.kanbanRow.dto.KanbanRowDto;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.dto.RoomDto;
import com.example.motipull.room.entity.Room;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
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
@Table(name = "kanban_row")
public class KanbanRowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowID;

    @Column
    private String rowName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_Id")
    private Room room;

    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean rowIsBacklog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "row_create_admin")
    private MemberEntity rowCreateAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "row_pull_admin")
    private MemberEntity rowPullAdmin;

    @Column
    private Integer rowWIPLimit;

    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean rowIsNoticePull;

    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean rowIsPrimary;

    @Convert(converter = BooleanToYNConverter.class)
    @Column
    private boolean rowNoticePrimary;

    @OneToMany(mappedBy = "row")
    private List<RowPrimaryEntity> RowPrimaryList = new ArrayList<>();

    /***
    @OneToMany(mappedBy = "row_card")
    private List<CardEntity> CardEntityList = new ArrayList<>();
    ***/

    public static Room toEntity(RoomDto dto, MemberEntity member) {
        return new Room(dto.getRoomId().intValue(), dto.getRoomName(), member);
    }


    public KanbanRowEntity(Integer rowID, String rowName, Room room, boolean rowIsBacklog, MemberEntity rowCreateAdmin, MemberEntity rowPullAdmin, Integer rowWIPLimit, boolean rowIsNoticePull, boolean rowIsPrimary, boolean rowNoticePrimary) {
        this.rowID = rowID;
        this.rowName = rowName;
        this.room = room;
        this.rowIsBacklog = rowIsBacklog;
        this.rowCreateAdmin = rowCreateAdmin;
        this.rowPullAdmin = rowPullAdmin;
        this.rowWIPLimit = rowWIPLimit;
        this.rowIsNoticePull = rowIsNoticePull;
        this.rowIsPrimary = rowIsPrimary;
        this.rowNoticePrimary = rowNoticePrimary;
    }
}
