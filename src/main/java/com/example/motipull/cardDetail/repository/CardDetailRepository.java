package com.example.motipull.cardDetail.repository;

import com.example.motipull.cardDetail.entity.CardDetailEntity;
import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailRepository extends JpaRepository<CardDetailEntity, Integer> {
}
