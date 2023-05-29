package com.example.motipull.declares.repository;

import com.example.motipull.declares.entity.DeclaresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclaresRepository extends JpaRepository<DeclaresEntity, Integer> {
}
