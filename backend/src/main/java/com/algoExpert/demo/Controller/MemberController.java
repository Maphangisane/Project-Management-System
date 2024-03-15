package com.algoExpert.demo.Controller;

import com.algoExpert.demo.Entity.Member;
import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

//    invite member to a project
    @PostMapping("/inviteMember/{project_id}/{user_id}")
    public Project inviteMember(@PathVariable int project_id, @PathVariable int user_id){

        return memberService.inviteMember(project_id,user_id);
    }

//    get all members of a project
    @GetMapping("/getAllMembers")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

}