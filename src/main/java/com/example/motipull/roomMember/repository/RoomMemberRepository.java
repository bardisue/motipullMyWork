package com.example.motipull.roomMember.repository;

import com.example.motipull.roomMember.entity.RoomMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMemberRepository extends JpaRepository<RoomMemberEntity, Integer> {
}