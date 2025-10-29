package com.example.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    
    Optional<Ticket> findTicketByCodigo(String codigo);
}
