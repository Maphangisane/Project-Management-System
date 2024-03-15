package com.algoExpert.demo.Service;


import com.algoExpert.demo.Entity.Member;
import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Repository.MemberRepository;
import com.algoExpert.demo.Repository.ProjectRepository;
import com.algoExpert.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberRepository memberRepository;

//    Invite member to project
    public Project inviteMember (int project_id , int user_id){

        Project userproject = projectRepository.findById(project_id).get();

        List<Member> members =  userproject.getMembersList();
        Member newMember = new Member(0,user_id, project_id,null);
        members.add(newMember);
        userproject.setMembersList(members);

        return projectRepository.save(userproject);
    }

//    get all members
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

//    get all members of a project

}
