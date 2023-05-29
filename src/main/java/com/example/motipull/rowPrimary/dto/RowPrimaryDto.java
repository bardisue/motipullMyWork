package com.example.motipull.rowPrimary.dto;

import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.rowPrimary.entity.RowPrimaryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RowPrimaryDto {
    private Integer id;
    private Integer rowId;
    private Integer memberId;
    public static RowPrimaryDto toDto(RowPrimaryEntity rowPrimary){
        return new RowPrimaryDto(rowPrimary.getId(), rowPrimary.getRow().getRowID(), rowPrimary.getMember().getMemberID());
    }
}
