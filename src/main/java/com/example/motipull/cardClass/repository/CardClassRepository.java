package com.example.motipull.cardClass.repository;

import com.example.motipull.cardClass.entity.CardClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardClassRepository extends JpaRepository<CardClassEntity, Integer> {
}
