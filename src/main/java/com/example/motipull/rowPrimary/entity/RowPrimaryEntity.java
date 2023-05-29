package com.example.motipull.rowPrimary.entity;

import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.room.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "row_primary")
public class RowPrimaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "row_id")
    private KanbanRowEntity row;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;


    public static RowPrimaryEntity toEntity(Integer id, KanbanRowEntity row, MemberEntity member) {
        RowPrimaryEntity roomMemberEntity = new RowPrimaryEntity();
        roomMemberEntity.orderRow(row);
        //roomMemberEntity.orderRoom(Room.toEntity(dto.getRoom()));
        roomMemberEntity.orderMember(member);
        return roomMemberEntity;
    }

    public void orderRow(KanbanRowEntity row){
        if(row.getRowPrimaryList().contains(this)){
            row.getRowPrimaryList().remove(this);
        }

        this.row = row;
        row.getRowPrimaryList().add(this);
    }

    public void orderMember(MemberEntity member){
        this.member = member;
    }

}
