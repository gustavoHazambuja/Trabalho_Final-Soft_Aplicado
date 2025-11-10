package com.example.domain.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.dtos.TicketDTO;
import com.example.domain.entities.Ticket;
import com.example.infrastructure.repositories.TicketRepository;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository repository;

    @Autowired
    private TicketTarifa tarifa;


    public Ticket emitirTicket(String placa){
        return null;
    }

    public boolean validarTicket(String codigo){
        return true;
    }

    public BigDecimal calcularTarifa(String codigo){
        return tarifa.calcularTarifa(codigo);
    }




    private Ticket fromModel(TicketDTO dto){
        return new Ticket(
            dto.getCodigo(),
            dto.getEntrada(),
            dto.getPlaca(),
            dto.getStatus()
        );
    }
}
