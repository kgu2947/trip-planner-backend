package org.feedapi.member.controller;

import org.feedapi.member.dto.JoinDTO;
import org.feedapi.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/getIdCnt/{userId}")
    public int getIdCnt(@PathVariable String userId){
        return memberService.getIdCnt(userId);
    }

    @PostMapping("/addMember")
    public void addMember(@RequestBody JoinDTO joinDTO){
        memberService.addMember(joinDTO);
    }


}
