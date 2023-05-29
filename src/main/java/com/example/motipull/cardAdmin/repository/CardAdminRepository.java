package com.example.motipull.cardAdmin.repository;

import com.example.motipull.cardAdmin.entity.CardAdminEntity;
import com.example.motipull.roomMember.entity.RoomMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardAdminRepository extends JpaRepository<CardAdminEntity, Integer> {
}
