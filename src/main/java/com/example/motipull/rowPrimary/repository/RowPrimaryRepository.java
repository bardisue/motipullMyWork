package com.example.motipull.rowPrimary.repository;

import com.example.motipull.kanbanRow.entity.KanbanRowEntity;
import com.example.motipull.room.entity.Room;
import com.example.motipull.rowPrimary.entity.RowPrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowPrimaryRepository extends JpaRepository<RowPrimaryEntity, Integer> {
}
