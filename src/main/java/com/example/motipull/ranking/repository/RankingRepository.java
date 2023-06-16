package com.example.motipull.ranking.repository;

import com.example.motipull.member.entity.MemberEntity;
import com.example.motipull.ranking.entity.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, String> {
}
