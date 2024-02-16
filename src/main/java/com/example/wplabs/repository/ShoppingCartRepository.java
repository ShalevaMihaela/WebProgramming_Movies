package com.example.wplabs.repository;

import com.example.wplabs.entity.ShoppingCartEntity;
import com.example.wplabs.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {

    List<ShoppingCartEntity> findAllByUserAndDateCreatedBetween(UserEntity user, LocalDateTime from, LocalDateTime to);


}
