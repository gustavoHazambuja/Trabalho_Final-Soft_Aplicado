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

    @Autowired
    private TicketValidacao validacao;


    public TicketDTO emitirTicket(TicketDTO dto){
        
        Ticket salvarTicket = fromModel(dto);
        repository.save(salvarTicket);

        return TicketDTO.toModel(salvarTicket);
    }

    public boolean validarTicket(String codigo){
        return validacao.validarTicket(codigo);
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
