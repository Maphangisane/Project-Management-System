package com.algoExpert.demo.Repository;

import com.algoExpert.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Integer> {

}