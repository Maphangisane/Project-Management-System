package com.algoExpert.demo.Repository.Service.Impl;

import com.algoExpert.demo.Entity.Member;
import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Entity.RefreshToken;
import com.algoExpert.demo.Entity.User;
import com.algoExpert.demo.ExceptionHandler.InvalidArgument;
import com.algoExpert.demo.Jwt.JwtResponse;
import com.algoExpert.demo.Jwt.JwtService;
import com.algoExpert.demo.Repository.MemberRepository;
import com.algoExpert.demo.Repository.ProjectRepository;
import com.algoExpert.demo.Repository.RefreshTokenRepository;
import com.algoExpert.demo.Repository.Service.ProjectUserService;
import com.algoExpert.demo.Repository.UserRepository;
import com.algoExpert.demo.role.Role;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.algoExpert.demo.AppUtils.AppConstants.*;

@Service
@Slf4j
public class ProjectUserImpl implements ProjectUserService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  ProjectUserImpl projectUser;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private RefreshTokenSevice refreshTokenSevice;


    @Override
    public Project findProject(int project_id) throws InvalidArgument {
        Project foundProject= projectRepository.findById(project_id).orElseThrow(() -> new InvalidArgument(String.format(PROJECT_NOT_FOUND,project_id)));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User projectUser = null;

        if (authentication != null) {
            projectUser = (User) authentication.getPrincipal();
        }

        //clear the roles of the user who is loading the project
        List<Role> roleList = projectUser.getRoles();
        roleList.clear();
        log.info("clear roles:{} ",roleList);
//        //assign the role of the user that all users should have
        roleList.add(Role.valueOf(USER_ROLE));
        log.info("add roles:{} ",roleList);
        for (Member member : foundProject.getMemberList() ){
            if(member.getProjectRole().equals(OWNER_ROLE) && member.getUser_id().equals(projectUser.getUser_id()) ){
                //find if the member has a role of an onwer and assign owner role if you find
                roleList.add(Role.valueOf(OWNER_ROLE));
            }
            else if(member.getUser_id().equals(projectUser.getUser_id()) && member.getProjectRole().equals(MEMBER_ROLE)){
                //assign role of a member if you find the id matching the user id who is loading the project
                roleList.add(Role.valueOf(MEMBER_ROLE));
            }
        }
        projectUser.setRoles(roleList);
        userRepository.save(projectUser);
        return foundProject;
    }

    @Override
    public JwtResponse refreshJwtToken(String refreshTokenRequest){
        return  refreshTokenRepository.findByToken(refreshTokenRequest)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String accessToken = jwtService.generateToken(user.getUsername());
                    String refreshToken = refreshTokenSevice.createRefreshToken(user.getUsername()).getToken();
                    return  JwtResponse.builder()
                            .jwtToken(accessToken)
                            .refreshToken(refreshToken).build();
                }).orElseThrow(() ->new RuntimeException(
                        "Refresh token is not in database"
                ));
    }
    @Override
    public Integer loggedInUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = null;

        if (authentication != null && authentication.isAuthenticated()) {
            // Get the principal (authenticated user)
            loggedUser = (User) authentication.getPrincipal();
        }
        return loggedUser.getUser_id();
    }

    @Override
    public List<Project> getUserProjectIds() {
        // Find all members
        List<Member> memberList = memberRepository.findAll();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User projectUser = null;

        if (authentication != null) {
            projectUser = (User) authentication.getPrincipal();
        }

        User systemUser = userRepository.findById(projectUser.getUser_id()).get();

        // Filter members by user_id and map them to project ids
        List<Integer> userProjectIds = memberList.stream()
                .filter(member -> member.getUser_id() == systemUser.getUser_id())
                .map(Member::getProject_id) // Assuming you have a method getProject_id() in Member class
                .collect(Collectors.toList());

        return projectRepository.findAllById(userProjectIds);
    }
    //    get User Project Ids

}
