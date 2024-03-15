package com.algoExpert.demo.Repository;

import com.algoExpert.demo.Entity.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneesRepository extends JpaRepository<Assignee, Integer> {

}
