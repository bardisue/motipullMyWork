package com.example.motipull.kanbanRow.repository;

import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanRepository extends JpaRepository<KanbanRowEntity, Integer> {
}
