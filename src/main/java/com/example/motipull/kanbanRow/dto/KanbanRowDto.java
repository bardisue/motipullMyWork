package com.example.motipull.kanbanRow.dto;

import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KanbanRowDto {
    private Integer rowId;
    private String rowName;
    private Integer roomId;
    private Boolean rowIsBacklog;
    private Integer rowCreateAdmin;
    private Integer rowPullAdmin;
    private Integer rowWIPLimit;
    private Boolean rowIsNoticePull;
    private Boolean rowIsPrimary;
    private Boolean rowNoticePrimary;

}
