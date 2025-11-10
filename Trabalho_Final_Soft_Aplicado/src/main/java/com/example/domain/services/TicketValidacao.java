package com.example.domain.services;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entities.Ticket;
import com.example.domain.enums.TicketStatus;
import com.example.infrastructure.exceptions.TicketNotFoundException;
import com.example.infrastructure.repositories.TicketRepository;

@Service
public class TicketValidacao {
    
    @Autowired
    private TicketRepository repository;

   

    public boolean validarTicket(String codigo){

          Ticket ticketEncontrado = repository.findTicketByCodigo(codigo)
            .orElseThrow(() -> new TicketNotFoundException("Ticket com o código " + codigo + " não encontrado."));

        LocalDateTime entrada = ticketEncontrado.getEntrada();
        LocalDateTime saida = LocalDateTime.now();

        Duration duracao = Duration.between(entrada, saida);

        long minutos = duracao.toMinutes();

        // Se o ticket está aberto, mas dentro dos 15 minutos, está válido
        if(ticketEncontrado.getStatus() == TicketStatus.ABERTO && minutos <= 15){
            return true;
        }
        
        // Se o ticket já foi pago, também está válido
        if(ticketEncontrado.getStatus() == TicketStatus.PAGO){
            return true;
        }

        // Caso contrário, não está válido
        return false;

    }
}
