package com.example.domain.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.enums.TicketStatus;
import com.example.infrastructure.repositories.TicketRepository;

@Service
public class TicketTotalPagamentos {
    
    @Autowired
    private TicketRepository repository;

    @Autowired
    private TicketTarifa tarifa;


    public BigDecimal valorTotalRecebido(int dia, int mes){

        return (BigDecimal) repository.findAll().stream()
            .filter(t -> t.getStatus() == TicketStatus.PAGO)
            .filter(t -> {
                LocalDate data = t.getEntrada().toLocalDate();
                return data.getDayOfMonth() == dia && data.getMonthValue() == mes;
            })
            .map(t -> {
                return tarifa.calcularTarifa(t.getCodigo());
            })
            .filter(v -> v != null)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
            
    }
}
