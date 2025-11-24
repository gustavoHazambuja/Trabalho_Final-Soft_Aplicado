package com.example.domain.services.functions;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.entities.Ticket;
import com.example.domain.enums.TicketStatus;
import com.example.infrastructure.exceptions.TicketNotFoundException;
import com.example.infrastructure.repositories.TicketRepository;

public class TicketPagamento {
    
    @Autowired
    private TicketRepository repository;


    public String realizarPagamento(String codigo){

        Ticket ticketEncontrado = repository.findTicketByCodigo(codigo)
            .orElseThrow(() -> new TicketNotFoundException("Ticket com o código " + codigo + " não encontrado."));


        if(ticketEncontrado.getStatus() == TicketStatus.PAGO){
            return "Ticket já pago";
        }

        ticketEncontrado.setStatus(TicketStatus.PAGO);
        repository.save(ticketEncontrado);

        return "Pagamento realizado com sucesso.";
    }
}
