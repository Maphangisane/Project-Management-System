package com.algoExpert.demo.Repository;


import com.algoExpert.demo.Entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {

}
