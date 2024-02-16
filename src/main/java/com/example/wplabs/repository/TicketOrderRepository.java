package com.example.wplabs.repository;

import com.example.wplabs.entity.TicketOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketOrderRepository extends JpaRepository<TicketOrderEntity, Long> {
}
