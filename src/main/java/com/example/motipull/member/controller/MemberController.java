package com.example.motipull.member.controller;

import com.example.motipull.member.dto.MemberDto;
import com.example.motipull.member.dto.MemberIdDto;
import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/member/create")
    @ResponseBody
    public ResponseEntity createRoom(@RequestBody MemberDto dto) {
        memberService.createMember(dto);
        System.out.println("크리에잇");
        System.out.println(dto.getMemberId());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/members")
    @ResponseBody
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/members/search")
    @ResponseBody
    public ResponseEntity getMemberById(@RequestBody MemberIdDto dto) {
        System.out.println("뭔데");
        System.out.println(dto.getMemberId().intValue());
        return ResponseEntity.ok(memberService.getMemberById(1));
    }
}