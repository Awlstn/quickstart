package com.example.quickstart.repository;

import com.example.quickstart.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
    // JpaRepository<해당엔티티, 엔티티의 기본키(Id)의 데이터타입>
}
