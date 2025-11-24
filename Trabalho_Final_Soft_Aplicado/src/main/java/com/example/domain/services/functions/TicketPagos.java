package com.example.domain.services.functions;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.enums.TicketStatus;
import com.example.infrastructure.repositories.TicketRepository;

@Service
public class TicketPagos {

    @Autowired
    private TicketRepository repository;
    
    public int numTicketsPagos(int dia, int mes){

        return (int) repository.findAll().stream()
            .filter(t -> t.getStatus() == TicketStatus.PAGO)
            .filter(t -> {
                LocalDate data = t.getEntrada().toLocalDate();
                return data.getDayOfMonth() == dia && data.getMonthValue() == mes;
            })
            .count();
    }
}
