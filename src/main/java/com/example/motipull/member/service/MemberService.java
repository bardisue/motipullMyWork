package com.example.motipull.member.service;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.repository.MemberRepository;
import com.example.motipull.room.entity.Room;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void createMember(MemberDto dto) {
        MemberEntity member = MemberEntity.toEntity(dto);
        if (memberRepository.findById(dto.getMemberId()).isEmpty()) {
            log.info("[MemberService] new member created! | name : {}", dto.getMemberName());
        }
        memberRepository.save(member);
    }

    public List<MemberDto> getAllMembers() {
        List<MemberEntity> list = memberRepository.findAll();

        List<MemberDto> dtos = list.stream().map(x -> MemberDto.toDto(x)).collect(Collectors.toList());
        return dtos;
    }

    public MemberDto getMemberById(Integer memberId){
        System.out.println(memberId);
        MemberEntity member = memberRepository.findById(memberId).get();
        return MemberDto.toDto(member);
    }
}